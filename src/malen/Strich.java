package malen;

import java.awt.Color;
import java.awt.Graphics;

public class Strich implements Verbindung {
	// Koordinaten vom Strich (s steht für start (xs,ys), e fuer ende (xe,ye))
	protected int ye;
	protected int xe;
	protected int ys;
	protected int xs;

	// Farbe
	protected Color color;

	/**
	 * Initialisiert Koordinaten und Farbe.
	 * 
	 * @param xs
	 * @param ys
	 * @param xe
	 * @param ye
	 * @param c
	 */
	public Strich(int xs, int ys, int xe, int ye, Color c) {
		this.xs = xs;
		this.ys = ys;
		this.xe = xe;
		this.ye = ye;
		this.color = c;
	}

	/**
	 * Setzt die Farbe und zeichnet die Linie.
	 * 
	 * @param g
	 */
	public void zeichne(Graphics g) {
		g.setColor(this.color);
		g.drawLine(this.xs, ys, xe, ye);
	}
	
	public Verbindung newVerbindung(int xs, int ys, int xe, int ye, Color c) {
		return new Strich(xs,ys,xe,ye,c);
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}

	@Override
	public void aktualisiereKoord(int xe, int ye) {
		this.xs = this.xe;
		this.ys = this.ye;
		this.xe = xe;
		this.ye = ye;
	}

	@Override
	public void aktualisiereFarbe(Color farbe) {
		this.color = farbe;
		
	}

	@Override
	public Color getFarbe() {
		return this.color;
	}

	@Override
	public Object clone() { 
		return new Strich(this.xs, this.ys, this.xe, this.ye, this.color);	
	}
}
