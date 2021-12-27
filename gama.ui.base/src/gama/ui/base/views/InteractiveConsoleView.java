/*******************************************************************************************************
 *
 * InteractiveConsoleView.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.base.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.internal.console.IOConsoleViewer;

import gama.common.ui.IGamaView;
import gama.common.util.StringUtils;
import gama.kernel.experiment.ITopLevelAgent;
import gama.metamodel.agent.IAgent;
import gama.runtime.ExecutionScope;
import gama.runtime.GAMA;
import gama.runtime.IExecutionContext;
import gama.runtime.IScope;
import gama.ui.base.resources.GamaIcons;
import gama.ui.base.resources.IGamaColors;
import gama.ui.base.resources.IGamaIcons;
import gama.ui.base.toolbar.GamaToolbar2;
import gama.ui.base.toolbar.GamaToolbarFactory;
import gama.ui.base.toolbar.IToolbarDecoratedView;
import gama.ui.base.utils.ThemeHelper;
import gama.ui.base.utils.ViewsHelper;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.GamaColor;
import gaml.compilation.GAML;
import gaml.descriptions.IVarDescriptionProvider;
import gaml.expressions.IExpression;
import gaml.expressions.IVarExpression;
import gaml.operators.Cast;
import gaml.operators.Strings;
import gaml.types.GamaType;
import gaml.types.IType;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractiveConsoleView.
 */
public class InteractiveConsoleView extends GamaViewPart implements IToolbarDecoratedView.Sizable,
		IToolbarDecoratedView.LogExportable, IGamaView.Console, IExecutionContext, IVarDescriptionProvider {

	/** The msg console. */
	private IOConsole msgConsole;

	/** The viewer. */
	IOConsoleViewer viewer;

	/** The error writer. */
	private OutputStreamWriter resultWriter, errorWriter;

	/** The reader. */
	BufferedReader reader;

	/** The scope. */
	private IScope scope;

	/** The temps. */
	private final Map<String, Object> temps = new LinkedHashMap<>();

	/** The history. */
	private final List<String> history = new ArrayList<>();

	/** The index in history. */
	private int indexInHistory = 0;

	/** The control to display in full screen. */
	private Composite controlToDisplayInFullScreen;

	/** The parent of control to display full screen. */
	private Composite parentOfControlToDisplayFullScreen;

	/**
	 * Creates the part control.
	 *
	 * @param composite the composite
	 */
	@Override
	public void createPartControl(final Composite composite) {
		setParentOfControlToDisplayFullScreen(composite);
		final var layout = new GridLayout(1, true);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		getParentOfControlToDisplayFullScreen().setLayout(layout);
		controlToDisplayInFullScreen = new Composite(composite, SWT.BORDER);
		controlToDisplayInFullScreen.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		super.createPartControl(controlToDisplayInFullScreen);

	}

	/**
	 * Inits the.
	 *
	 * @param site the site
	 * @throws PartInitException the part init exception
	 */
	@Override
	public void init(final IViewSite site) throws PartInitException {
		super.init(site);
		// Issue #2816
		this.setTitleImage(GamaIcons.create("view.interactive2").image());
	}

	/**
	 * Gets the scope.
	 *
	 * @return the scope
	 */
	@Override
	public IScope getScope() { return scope; }

	/**
	 * Own create part control.
	 *
	 * @param p the p
	 */
	@Override
	public void ownCreatePartControl(final Composite p) {
		msgConsole = new IOConsole("GAMA Console", null);
		reader = new BufferedReader(new InputStreamReader(msgConsole.getInputStream()));
		var stream = msgConsole.newOutputStream();
		stream.setColor(ThemeHelper.isDark() ? IGamaColors.NEUTRAL.lighter() : IGamaColors.NEUTRAL.color());
		// stream.setFontStyle(SWT.ITALIC);
		resultWriter = new OutputStreamWriter(stream);
		stream = msgConsole.newOutputStream();
		stream.setColor(IGamaColors.ERROR.color());
		errorWriter = new OutputStreamWriter(stream);
		viewer = new IOConsoleViewer(p, msgConsole);

		viewer.setWordWrap(true);

		msgConsole.getDocument().addDocumentListener(new IDocumentListener() {

			@Override
			public void documentChanged(final DocumentEvent event) {
				if (Strings.LN.equals(event.getText())) {
					var textEntered = "";
					try {
						textEntered = reader.readLine();
					} catch (final IOException e) {
						append("Error in reading command", true, true);
						return;
					}
					processInput(textEntered);
				}
			}

			@Override
			public void documentAboutToBeChanged(final DocumentEvent event) {

			}
		});

		viewer.getTextWidget().addVerifyKeyListener(e -> {
			if (e.keyCode == SWT.ARROW_UP || e.keyCode == SWT.ARROW_DOWN) {
				final var text = (StyledText) e.widget;
				final var selection = text.getSelection();
				final var line = text.getLineAtOffset(selection.y);
				if (line == text.getLineCount() - 1) {
					e.doit = false;
					insertHistory(e.keyCode == SWT.ARROW_UP);

				}
			}
		});
		p.layout(true, true);
		showPrompt();

	}

	/**
	 * Gets the control to display in full screen.
	 *
	 * @return the control to display in full screen
	 */
	public Composite getControlToDisplayInFullScreen() { return controlToDisplayInFullScreen; }

	/** The Constant PROMPT. */
	public static final String PROMPT = "gaml> ";

	/**
	 * Show prompt.
	 */
	private void showPrompt() {

		new Thread(() -> {
			append(Strings.LN + PROMPT, false, false);
			try {
				// Wait for the output stream to finish
				Thread.sleep(200);
			} catch (final InterruptedException e) {}
			WorkbenchHelper.run(() -> {
				if (viewer != null && viewer.getTextWidget() != null && !viewer.getTextWidget().isDisposed()) {
					viewer.getTextWidget().setCaretOffset(viewer.getTextWidget().getCharCount());
				}

			});

		}).start();

	}

	/**
	 * Insert history.
	 *
	 * @param back
	 *            the back
	 */
	private void insertHistory(final boolean back) {

		if (history.size() == 0) {
			ViewsHelper.requestUserAttention(this, "No history");
			return;
		}
		if (indexInHistory <= 0) {
			if (back) { ViewsHelper.requestUserAttention(this, "No more history"); }
			indexInHistory = 0;
		} else if (indexInHistory >= history.size() - 1) {
			if (!back) { ViewsHelper.requestUserAttention(this, "No more history"); }
			indexInHistory = history.size() - 1;
		}
		try {
			final var text = viewer.getTextWidget();
			final var lineIndex = text.getLineCount() - 1;
			final var nbChars = text.getCharCount();
			final var firstOffset = text.getOffsetAtLine(lineIndex) + PROMPT.length();
			viewer.getDocument().replace(firstOffset, nbChars - firstOffset, history.get(indexInHistory));
			text.setCaretOffset(text.getCharCount());
			if (back) {
				indexInHistory--;
			} else {
				indexInHistory++;
			}
		} catch (final org.eclipse.jface.text.BadLocationException e1) {}

	}

	/**
	 * Append the text to the console.
	 *
	 * @param text            to display in the console
	 * @param error the error
	 * @param showPrompt the show prompt
	 */
	public void append(final String text, final boolean error, final boolean showPrompt) {

		WorkbenchHelper.asyncRun(() -> {
			@SuppressWarnings ("resource") final var writer = error ? errorWriter : resultWriter;
			try {
				writer.append(text);
				writer.flush();
				if (showPrompt) { showPrompt(); }
			} catch (final IOException e) {}

		});

	}

	/**
	 * Widget disposed.
	 *
	 * @param e the e
	 */
	@Override
	public void widgetDisposed(final DisposeEvent e) {
		reset();
		super.widgetDisposed(e);
	}

	/**
	 * Close.
	 *
	 * @param scope the scope
	 */
	@Override
	public void close(final IScope scope) {
		reset();
		super.close(scope);
	}

	/**
	 * Reset.
	 */
	@Override
	public void reset() {
		msgConsole.clearConsole();
		setExecutorAgent(null);
		showPrompt();
	}

	/**
	 * Gets the sizable font control.
	 *
	 * @return the sizable font control
	 */
	@Override
	public Control getSizableFontControl() {
		if (viewer == null) return null;
		return viewer.getTextWidget();
	}

	/**
	 * Creates the tool items.
	 *
	 * @param tb the tb
	 */
	@Override
	public void createToolItems(final GamaToolbar2 tb) {
		super.createToolItems(tb);
		tb.sep(GamaToolbarFactory.TOOLBAR_SEP, SWT.RIGHT);
		tb.button(IGamaIcons.ACTION_CLEAR, "Clear", "Clear the console", e -> {
			msgConsole.clearConsole();
			showPrompt();
		}, SWT.RIGHT);

	}

	/**
	 * Creates the update job.
	 *
	 * @return the gama UI job
	 */
	@Override
	protected GamaUIJob createUpdateJob() {
		return null;
	}

	/**
	 * As ConsoleView is automatically opened by moving to the simulation perspective, the automatic closing can cause
	 * problems. So the view is stated as accepting an "experiment-less" mode. See Issue #1361 Method
	 * shouldBeClosedWhenNoExperiments()
	 *
	 * @return true, if successful
	 * @see ummisco.gama.ui.views.GamaViewPart#shouldBeClosedWhenNoExperiments()
	 */
	@Override
	protected boolean shouldBeClosedWhenNoExperiments() {
		return false;
	}

	/**
	 * Needs output.
	 *
	 * @return true, if successful
	 */
	@Override
	protected boolean needsOutput() {
		return false;
	}

	/**
	 * Append.
	 *
	 * @param text the text
	 * @param agent the agent
	 * @param color the color
	 */
	@Override
	public void append(final String text, final ITopLevelAgent agent, final GamaColor color) {
		setExecutorAgent(agent);
		if (text != null) { append(text, false, true); }
	}

	/**
	 * Sets the executor agent.
	 *
	 * @param agent
	 *            the new executor agent
	 */
	private void setExecutorAgent(final ITopLevelAgent agent) {
		if (scope != null) {
			scope.clear();
			scope = null;
		}
		if (agent == null) {

			WorkbenchHelper.asyncRun(() -> {
				if (toolbar != null && !toolbar.isDisposed()) { toolbar.wipe(SWT.LEFT, true); }
			});
		} else {
			scope = new ExecutionScope(agent, " in console", this);
			agent.getSpecies().getDescription().attachAlternateVarDescriptionProvider(this);
			WorkbenchHelper.asyncRun(() -> toolbar.status(GamaIcons.create(IGamaIcons.MENU_AGENT).image(),
					"Listening agent: " + Cast.toGaml(agent), IGamaColors.NEUTRAL, SWT.LEFT));
		}

	}

	/**
	 * Process input.
	 *
	 * @param s
	 *            the s
	 */
	protected void processInput(final String s) {
		final var agent = getListeningAgent();
		if (agent == null || agent.dead()) {
			setExecutorAgent(null);
		} else {
			final var entered = s.trim();
			history.add(entered);
			indexInHistory = history.size() - 1;
			String result = null;
			var error = false;
			if (entered.startsWith("?")) {
				result = GAML.getDocumentationOn(entered.substring(1));
			} else {
				try {
					final var expr = GAML.compileExpression(s, agent, this, false);
					if (expr != null) { result = StringUtils.toGaml(scope.evaluate(expr, agent).getValue(), true); }
				} catch (final Exception e) {
					error = true;
					result = "> Error: " + e.getMessage();
				} finally {
					agent.getSpecies().removeTemporaryAction();
				}
			}
			if (result == null) { result = "nil"; }
			append(result, error, true);
			if (!error && GAMA.getExperiment() != null) { GAMA.getExperiment().refreshAllOutputs(); }
		}

	}

	/**
	 * Gets the parent of control to display full screen.
	 *
	 * @return the parent of control to display full screen
	 */
	public Composite getParentOfControlToDisplayFullScreen() { return parentOfControlToDisplayFullScreen; }

	/**
	 * Sets the parent of control to display full screen.
	 *
	 * @param parentOfControlToDisplayFullScreen
	 *            the new parent of control to display full screen
	 */
	public void setParentOfControlToDisplayFullScreen(final Composite parentOfControlToDisplayFullScreen) {
		this.parentOfControlToDisplayFullScreen = parentOfControlToDisplayFullScreen;
	}

	/**
	 * Gets the listening agent.
	 *
	 * @return the listening agent
	 */
	private IAgent getListeningAgent() {
		if (scope == null) { setExecutorAgent(GAMA.getPlatformAgent()); }
		return scope.getRoot();
	}

	/**
	 * Sets the temp var.
	 *
	 * @param name the name
	 * @param value the value
	 */
	@Override
	public void setTempVar(final String name, final Object value) {
		temps.put(name, value);

	}

	/**
	 * Gets the temp var.
	 *
	 * @param name the name
	 * @return the temp var
	 */
	@Override
	public Object getTempVar(final String name) {
		return temps.get(name);
	}

	/**
	 * Gets the local vars.
	 *
	 * @return the local vars
	 */
	@Override
	public Map<? extends String, ? extends Object> getLocalVars() { return temps; }

	/**
	 * Clear local vars.
	 */
	@Override
	public void clearLocalVars() {
		temps.clear();

	}

	/**
	 * Put local var.
	 *
	 * @param name the name
	 * @param val the val
	 */
	@Override
	public void putLocalVar(final String name, final Object val) {
		temps.put(name, val);

	}

	/**
	 * Gets the local var.
	 *
	 * @param name the name
	 * @return the local var
	 */
	@Override
	public Object getLocalVar(final String name) {
		return temps.get(name);
	}

	/**
	 * Checks for local var.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	@Override
	public boolean hasLocalVar(final String name) {
		return temps.containsKey(name);
	}

	/**
	 * Removes the local var.
	 *
	 * @param name the name
	 */
	@Override
	public void removeLocalVar(final String name) {
		temps.remove(name);
	}

	/**
	 * Gets the outer context.
	 *
	 * @return the outer context
	 */
	@Override
	public IExecutionContext getOuterContext() { return this; }

	/**
	 * Creates the copy.
	 *
	 * @return the i execution context
	 */
	@Override
	public IExecutionContext createCopy() {
		return this;
	}

	/**
	 * Creates the child context.
	 *
	 * @return the i execution context
	 */
	@Override
	public IExecutionContext createChildContext() {
		return this;
	}

	/**
	 * Gets the var expr.
	 *
	 * @param name the name
	 * @param asField the as field
	 * @return the var expr
	 */
	@Override
	public IExpression getVarExpr(final String name, final boolean asField) {
		if (temps.containsKey(name)) {
			final var value = temps.get(name);
			final IType<?> t = GamaType.of(value);
			return GAML.getExpressionFactory().createVar(name, t, false, IVarExpression.TEMP, null);
		}
		return null;
	}

	/**
	 * Checks for attribute.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	@Override
	public boolean hasAttribute(final String name) {
		return temps.containsKey(name);
	}

	/**
	 * Gets the contents.
	 *
	 * @return the contents
	 */
	@Override
	public String getContents() { return viewer.getDocument().get(); }

}
