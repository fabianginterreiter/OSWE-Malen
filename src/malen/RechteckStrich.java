package malen;

import java.awt.Color;
import java.awt.Graphics;

public class RechteckStrich extends Strich {

	public RechteckStrich(int xs, int ys, int xe, int ye, Color c) {
		super(xs, ys, xe, ye, c);
	}
	
	public Verbindung newVerbindung(int xs, int ys, int xe, int ye, Color c) {
		return new RechteckStrich(xs,ys,xe,ye,c);
	}
	
	public void zeichne(Graphics g) {
		g.setColor(this.color);
		g.drawRect(xs, ys, 5, 5);
	}

	@Override
	public Object clone() { 
		return new RechteckStrich(this.xs, this.ys, this.xe, this.ye, this.color);	
	}
}
