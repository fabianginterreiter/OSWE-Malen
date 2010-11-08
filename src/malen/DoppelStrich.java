package malen;

import java.awt.Color;
import java.awt.Graphics;

public class DoppelStrich extends Strich {

	public DoppelStrich(int xs, int ys, int xe, int ye, Color c) {
		super(xs, ys, xe, ye, c);
	}
	
	public Verbindung newVerbindung(int xs, int ys, int xe, int ye, Color c) {
		return new DoppelStrich(xs,ys,xe,ye,c);
	}

	public void zeichne(Graphics g) {
		super.zeichne(g);
		g.drawLine(this.xs + 3, ys + 3, xe + 3, ye + 3);
	}

	@Override
	public Object clone() { 
		return new DoppelStrich(this.xs, this.ys, this.xe, this.ye, this.color);	
	}
}
