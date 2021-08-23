/*********************************************************************************************
 *
 * 'WorkspacePreferences.java, in plugin msi.gama.application, is part of the source code of the GAMA modeling and
 * simulation platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.core.application.workspace;

import static gama.common.preferences.GamaPreferenceStore.getStore;
import static java.lang.System.setProperty;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.datalocation.Location;

import gama.common.preferences.GamaPreferenceStore;
import gama.common.ui.IApplicationControl;
import gama.core.dev.utils.DEBUG;

public class WorkspaceManager {

	private static final String KEY_WORSPACE_PATH = "pref_workspace_path";
	public static final String KEY_CLEAR_WORKSPACE = "pref_clear_workspace";
	private static final String KEY_WORKSPACE_REMEMBER = "pref_workspace_remember";
	private static final String KEY_WORKSPACE_LIST = "pref_workspace_list";
	private static final String KEY_ASK_REBUILD = "pref_ask_rebuild";
	private static final String KEY_ASK_OUTDATED = "pref_ask_outdated";
	public static final String WORKSPACE_IDENTIFIER = ".gama_application_workspace";

	/**
	 * The argument for whether the persisted state should be cleared on startup. Copied from IWorkbench <br>
	 *
	 */
	public static final String CLEAR_PERSISTED_STATE = "clearPersistedState";
	private static String MODEL_IDENTIFIER = null;

	static String selectedWorkspaceRootLocation;

	/**
	 * Returns whether the user selected "remember workspace" in the preferences
	 */
	public static boolean isRememberWorkspace() {
		return getStore().getBoolean(KEY_WORKSPACE_REMEMBER, false);
	}

	public static void isRememberWorkspace(final boolean remember) {
		getStore().putBoolean(KEY_WORKSPACE_REMEMBER, remember);
	}

	public static String getLastUsedWorkspaces() {
		return getStore().get(KEY_WORKSPACE_LIST, "");
	}

	public static void setLastUsedWorkspaces(final String used) {
		getStore().put(KEY_WORKSPACE_LIST, used);
	}

	/**
	 * Returns the last set workspace directory from the preferences
	 *
	 * @return null if none
	 */
	public static String getLastSetWorkspaceDirectory() {
		return getStore().get(KEY_WORSPACE_PATH, "");
	}

	public static void setLastSetWorkspaceDirectory(final String last) {
		getStore().put(KEY_WORSPACE_PATH, last);
	}

	public static boolean askBeforeRebuildingWorkspace() {
		// true by default
		return getStore().getBoolean(KEY_ASK_REBUILD, true);
	}

	public static void askBeforeRebuildingWorkspace(final boolean ask) {
		// true by default
		getStore().putBoolean(KEY_ASK_REBUILD, ask);
	}

	public static boolean askBeforeUsingOutdatedWorkspace() {
		// true by default
		return getStore().getBoolean(KEY_ASK_OUTDATED, true);
	}

	public static void askBeforeUsingOutdatedWorkspace(final boolean ask) {
		// true by default
		getStore().putBoolean(KEY_ASK_OUTDATED, ask);
	}

	public static String getSelectedWorkspaceRootLocation() {
		return selectedWorkspaceRootLocation;
	}

	public static void setSelectedWorkspaceRootLocation(final String s) {
		selectedWorkspaceRootLocation = s;
	}

	public static String getCurrentGamaStampString() {
		String gamaStamp = null;
		try {
			final URL tmpURL = new URL("platform:/plugin/msi.gama.models/models/");
			final URL resolvedFileURL = FileLocator.toFileURL(tmpURL);
			// We need to use the 3-arg constructor of URI in order to properly escape file system chars
			final URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null).normalize();
			final File modelsRep = new File(resolvedURI);

			// loading file from URL Path is not a good idea. There are some bugs
			// File modelsRep = new File(urlRep.getPath());

			final long time = modelsRep.lastModified();
			gamaStamp = ".built_in_models_" + time;
			DEBUG.OUT(">GAMA version " + Platform.getProduct().getDefiningBundle().getVersion().toString()
					+ " loading...");
			DEBUG.OUT(">GAMA models library version: " + gamaStamp);
		} catch (final IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return gamaStamp;
	}

	/**
	 * Ensures a workspace directory is OK in regards of reading/writing, etc. This method will get called externally as
	 * well.
	 *
	 * @param parentShell
	 *            Shell parent shell
	 * @param workspaceLocation
	 *            Directory the user wants to use
	 * @param askCreate
	 *            Whether to ask if to create the workspace or not in this location if it does not exist already
	 * @param fromDialog
	 *            Whether this method was called from our dialog or from somewhere else just to check a location
	 * @return null if everything is ok, or an error message if not
	 */
	public static String checkWorkspaceDirectory(final IApplicationControl ui, final String workspaceLocation,
			final boolean askCreate, final boolean fromDialog, final boolean cloning) {
		final File f = new File(workspaceLocation);
		if (!f.exists() && askCreate) {
			final boolean create = ui.getGui().question("New Directory",
					workspaceLocation + " does not exist. Would you like to create a new workspace here"
							+ (cloning ? ", copy the projects of your current workspace into it," : "")
							+ " and proceeed ?");
			if (create) {
				try {
					f.mkdirs();
					final File wsDot = new File(workspaceLocation + File.separator + WORKSPACE_IDENTIFIER);
					wsDot.createNewFile();
					final File dotFile = new File(workspaceLocation + File.separator + getModelIdentifier());
					dotFile.createNewFile();
				} catch (final RuntimeException | IOException er) {
					er.printStackTrace();
					return "Error creating directories, please check folder permissions";
				}
			}
			if (!f.exists()) return "The selected directory does not exist";
			return null;
		}
		if (!f.canRead()) return "The selected directory is not readable";
		if (!f.isDirectory()) return "The selected path is not a directory";

		testWorkspaceSanity(ui, f);

		final File wsTest = new File(workspaceLocation + File.separator + WORKSPACE_IDENTIFIER);
		if (fromDialog) {
			if (!wsTest.exists()) {
				final boolean create = ui.getGui().question("New Workspace", "The directory '"
						+ wsTest.getAbsolutePath()
						+ "' exists but is not identified as a GAMA workspace. \n\nWould you like to use it anyway ?");
				if (!create) return "Please select a directory for your workspace";
				try {
					f.mkdirs();
					final File wsDot = new File(workspaceLocation + File.separator + WORKSPACE_IDENTIFIER);
					wsDot.createNewFile();
				} catch (final Exception err) {
					return "Error creating directories, please check folder permissions";
				}

				if (!wsTest.exists()) return "The selected directory does not exist";
				return null;
			}
		} else if (!wsTest.exists()) return "The selected directory is not a workspace directory";
		final File dotFile = new File(workspaceLocation + File.separator + getModelIdentifier());
		if (!dotFile.exists()) {
			if (fromDialog) {
				boolean create = true;
				if (askBeforeUsingOutdatedWorkspace()) {
					create = ui.getGui().question("Different version of the models library",
							"The workspace contains a different version of the models library. Do you want to proceed anyway ?");
				}
				if (create) {
					try {
						dotFile.createNewFile();
					} catch (final IOException e) {
						return "Error updating the models library";
					}
					return null;
				}
			}

			return "models";
		}
		if (cloning) {
			final boolean b = ui.getGui().question("Existing workspace",
					"The path entered is a path to an existing workspace. All its contents will be erased and replaced by the current workspace contents. Proceed anyway ?");
			if (!b) return "";
		}
		return null;
	}

	public static boolean testWorkspaceSanity(final IApplicationControl ui, final File workspace) {
		DEBUG.OUT("[GAMA] Checking for workspace sanity");
		File[] files = workspace.listFiles((FileFilter) file -> ".metadata".equals(file.getName()));
		if (files == null || files.length == 0) return true;
		final File[] logs = files[0].listFiles((FileFilter) file -> file.getName().contains(".log"));
		if (logs != null) {
			for (final File log : logs) {
				log.delete();
			}
		}
		files = files[0].listFiles((FileFilter) file -> ".plugins".equals(file.getName()));
		if (files == null) return false;
		if (files.length == 0) return true;
		files = files[0].listFiles((FileFilter) file -> "org.eclipse.core.resources".equals(file.getName()));
		if (files == null) return false;
		if (files.length == 0) return true;
		files = files[0].listFiles((FileFilter) file -> file.getName().contains("snap"));
		if (files == null) return false;
		DEBUG.OUT("[GAMA] Workspace appears to be " + (files.length == 0 ? "clean" : "corrupted"));
		if (files.length == 0) return true;
		boolean rebuild = true;
		if (askBeforeRebuildingWorkspace()) {
			rebuild = ui.getGui().question("Corrupted workspace",
					"The workspace appears to be corrupted (due to a previous crash) or it is currently used by another instance of the platform. Would you like GAMA to clean it ?");
		}
		if (rebuild) {
			for (final File file : files) {
				if (file.exists()) { file.delete(); }
			}
			GamaPreferenceStore.getStore().putBoolean(KEY_CLEAR_WORKSPACE, true);
			return false;
		}
		return true;
	}

	public static String getModelIdentifier() {
		if (MODEL_IDENTIFIER == null) { MODEL_IDENTIFIER = getCurrentGamaStampString(); }
		return MODEL_IDENTIFIER;
	}

	public static boolean checkWorkspace(final IApplicationControl ui) throws IOException, MalformedURLException {
		try {
			final Location instanceLoc = Platform.getInstanceLocation();
			if (instanceLoc == null) {
				// -data @none was specified but GAMA requires a workspace
				ui.getGui().error("Error", "A workspace is required to run GAMA");
				return false;
			}
			boolean remember = false;
			String lastUsedWs = null;
			if (instanceLoc.isSet()) {
				lastUsedWs = instanceLoc.getURL().getFile();
				final String ret = checkWorkspaceDirectory(ui, lastUsedWs, false, false, false);
				if (ret != null) {
					/*
					 * If we dont or cant remember and the location is set, we cant do anything as we need a workspace
					 */
					ui.close(true, "The workspace provided cannot be used. Please change it");
					return false;
				}
			} else {

				/* Get what the user last said about remembering the workspace location */
				remember = isRememberWorkspace();
				/* Get the last used workspace location */
				lastUsedWs = getLastSetWorkspaceDirectory();
				/* If we have a "remember" but no last used workspace, it's not much to remember */
				if (remember && (lastUsedWs == null || lastUsedWs.length() == 0)) { remember = false; }
				if (remember) {
					/*
					 * If there's any problem with the workspace, force a dialog
					 */
					final String ret = checkWorkspaceDirectory(ui, lastUsedWs, false, false, false);
					// AD Added this check explicitly as the checkWorkspaceDirectory() was not supposed to return null
					// at
					// this stage
					if (ret != null) {
						remember = "models".equals(ret) && !ui.getGui().question(
								"Different version of the models library",
								"The workspace contains a different version of the models library. Do you want to use another workspace ?");
					}
				}
			}

			/* If we don't remember the workspace, show the dialog */
			if (!remember) {
				final int pick = ui.getGui().chooseWorkspace();
				/* If the user cancelled, we can't do anything as we need a workspace */
				if (pick == 1 /* Window.CANCEL */ && getSelectedWorkspaceRootLocation() == null) {
					ui.close(true, "The application can not start without a workspace and will now exit.");
					return false;
				}
				/* Tell Eclipse what the selected location was and continue */
				instanceLoc.set(new URL("file", null, getSelectedWorkspaceRootLocation()), false);
				// if ( applyPrefs() ) { applyEclipsePreferences(getSelectedWorkspaceRootLocation()); }
			} else if (!instanceLoc.isSet()) {
				/* Set the last used location and continue */
				instanceLoc.set(new URL("file", null, lastUsedWs), false);
			}

			return true;
		} finally {
			if (GamaPreferenceStore.getStore().getBoolean(KEY_CLEAR_WORKSPACE, false)) {
				setProperty(CLEAR_PERSISTED_STATE, "true");
				GamaPreferenceStore.getStore().putBoolean(KEY_CLEAR_WORKSPACE, false);
			}
		}
	}

}
