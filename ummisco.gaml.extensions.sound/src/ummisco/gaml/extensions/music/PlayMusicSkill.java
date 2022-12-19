/*******************************************************************************************************
 *
 * PlayMusicSkill.java, in ummisco.gama.network, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.9.0).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package ummisco.gaml.extensions.music;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import msi.gama.precompiler.GamlAnnotations.doc;
import msi.gama.precompiler.GamlAnnotations.skill;
import msi.gama.precompiler.IConcept;
import msi.gaml.skills.Skill;
import ummisco.gama.dev.utils.DEBUG;

/**
 * The Class PlayMusicSkill.
 */
@skill (
		name = IPlayMusic.MUSIC_SKILL,
		concept = { IConcept.NETWORK, IConcept.COMMUNICATION, IConcept.SKILL },
		doc = @doc ("Skill allowing agents to output sounds"))
public class PlayMusicSkill extends Skill implements IPlayMusic {

	/** The volume. */
	public int volume = 200;

	/** The synthetiseur. */
	private Synthesizer synthetiseur;

	/** The canal. */
	private final MidiChannel canal;

	/**
	 * Instantiates a new play music skill.
	 */
	public PlayMusicSkill() {

		try {
			// On récupère le synthétiseur, on l'ouvre et on obtient un canal
			synthetiseur = MidiSystem.getSynthesizer();
			synthetiseur.open();
		} catch (final MidiUnavailableException ex) {
			DEBUG.OUT(ex);
		}
		canal = synthetiseur.getChannels()[0];

		// On initialise l'instrument 0 (le piano) pour le canal
		canal.programChange(0);
	}

	/**
	 * Note on.
	 *
	 * @param note
	 *            the note
	 */
	// Joue la note dont le numéro est en paramètre
	public void note_on(final int note) {
		canal.noteOn(note, volume);
	}

	/**
	 * Note off.
	 *
	 * @param note
	 *            the note
	 */
	// Arrête de jouer la note dont le numéro est en paramètre
	public void note_off(final int note) {
		canal.noteOff(note);
	}

	/**
	 * Sets the instrument.
	 *
	 * @param instru
	 *            the new instrument
	 */
	// Set le type d'instrument dont le numéro MIDI est précisé en paramètre
	public void set_instrument(final int instru) {
		canal.programChange(instru);
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		
		final PlayMusicSkill mon_instru = new PlayMusicSkill();
		mon_instru.note_on(75);
		mon_instru.note_on(50);
		mon_instru.note_on(25);
		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			
			e.printStackTrace();
		}

	}

}
