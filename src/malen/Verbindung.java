/**
 * 
 */
package malen;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author ginterre
 *
 */
public interface Verbindung extends Cloneable {
	void zeichne(Graphics g);
	Verbindung newVerbindung(int xs, int ys, int xe, int ye, Color c);
	String toString();
	
	public Object clone();
	public void aktualisiereKoord(int xe, int ye);
	public void aktualisiereFarbe(Color farbe);
	public Color getFarbe();
}
