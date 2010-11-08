package malen;

import java.awt.Color;
import java.awt.Graphics;

public class PunktStrich extends Strich {

	public PunktStrich(int xs, int ys, int xe, int ye, Color c) {
		super(xs, ys, xe, ye, c);
	}
	
	public Verbindung newVerbindung(int xs, int ys, int xe, int ye, Color c) {
		return new PunktStrich(xs,ys,xe,ye,c);
	}
	
	public void zeichne(Graphics g) {
		g.setColor(this.color);
		g.drawOval(this.xs, ys, 5, 5);
	}

	@Override
	public Object clone() { 
		return new PunktStrich(this.xs, this.ys, this.xe, this.ye, this.color);	
	}
}
