/*******************************************************************************************************
 *
 * BasicController.java, in gama.ext.audio, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package javazoom.jlgui.basicplayer;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * This interface defines player controls available.  
 */
public interface BasicController
{
    
    /**
     * Open inputstream to play.
     *
     * @param in the in
     * @throws BasicPlayerException the basic player exception
     */
    public void open(InputStream in) throws BasicPlayerException;

    /**
     * Open file to play.
     *
     * @param file the file
     * @throws BasicPlayerException the basic player exception
     */
    public void open(File file) throws BasicPlayerException;

    /**
     * Open URL to play.
     *
     * @param url the url
     * @throws BasicPlayerException the basic player exception
     */
    public void open(URL url) throws BasicPlayerException;

    /**
     * Skip bytes.
     *
     * @param bytes the bytes
     * @return bytes skipped according to audio frames constraint.
     * @throws BasicPlayerException the basic player exception
     */
    public long seek(long bytes) throws BasicPlayerException;

    /**
     * Start playback.
     *
     * @throws BasicPlayerException the basic player exception
     */
    public void play() throws BasicPlayerException;

    /**
     * Stop playback. 
     *
     * @throws BasicPlayerException the basic player exception
     */
    public void stop() throws BasicPlayerException;

    /**
     * Pause playback. 
     *
     * @throws BasicPlayerException the basic player exception
     */
    public void pause() throws BasicPlayerException;

    /**
     * Resume playback. 
     *
     * @throws BasicPlayerException the basic player exception
     */
    public void resume() throws BasicPlayerException;

    /**
     * Sets Pan (Balance) value.
     * Linear scale : -1.0 <--> +1.0
     *
     * @param pan value from -1.0 to +1.0
     * @throws BasicPlayerException the basic player exception
     */
    public void setPan(double pan) throws BasicPlayerException;

    /**
     * Sets Gain value.
     * Linear scale 0.0  <-->  1.0
     *
     * @param gain value from 0.0 to 1.0
     * @throws BasicPlayerException the basic player exception
     */
    public void setGain(double gain) throws BasicPlayerException;
}
