package malen;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Zeichnung extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Verbindung> list;

	public Zeichnung() {
		list = new ArrayList<Verbindung>();
	}
	
	public void loesche() {
		this.list = new ArrayList<Verbindung>();
		this.repaint();
	}
	
	public void addiere(Verbindung s) {
		this.list.add(s);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Verbindung s : this.list) {
			s.zeichne(g);
		}
	}
	
	
}
