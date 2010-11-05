package malen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Malen implements ActionListener, ItemListener, MouseMotionListener {
	private Container behaelter;

	private Color aktuelleFarbe = Color.black;
	private JButton loeschKnopf;
	private JComboBox farbWahl;
	private JButton endeKnopf;

	private JComboBox strichWahl;

	private Zeichnung zeichnung;

	private static final String schwarz = "Schwarz";
	private static final String rot = "Rot";
	private static final String gelb = "Gelb";
	private static final String gruen = "Grün";
	private static final String blau = "Blau";
	// add new colors
	private static final String zyan = "Zyan";
	private static final String magenta = "Magenta";
		
	private static final Verbindung[] verbindungen = {
		new Strich(0,0,0,0,Color.black),
		new DoppelStrich(0,0,0,0,Color.black),
		new PunktStrich(0,0,0,0,Color.black),
		new RechteckStrich(0,0,0,0,Color.black)
	};
	
	private Verbindung aktuelleVerbindung = verbindungen[0];
	


	public void init() {
		this.zeichnung = new Zeichnung();

		behaelter.setLayout(new BorderLayout());

		JPanel menue = new JPanel();

		behaelter.add(menue, BorderLayout.NORTH);

		behaelter.setBackground(Color.gray);

		loeschKnopf = new JButton("Löschen");
		loeschKnopf.addActionListener(this);
		loeschKnopf.setForeground(Color.black);
		loeschKnopf.setBackground(Color.lightGray);
		menue.add(loeschKnopf);

		farbWahl = new JComboBox();
		farbWahl.addItemListener(this);
		farbWahl.addItem(schwarz);
		farbWahl.addItem(rot);
		farbWahl.addItem(gelb);
		farbWahl.addItem(gruen);
		farbWahl.addItem(blau);
		// add new colors
		farbWahl.addItem(zyan);
		farbWahl.addItem(magenta);
		this.aktuelleVerbindung.aktualisiereFarbe(Color.black);
		farbWahl.setForeground(Color.white);
		menue.add(new JLabel("Farbe: "));
		menue.add(farbWahl);

		endeKnopf = new JButton("Ende");
		endeKnopf.addActionListener(this);
		endeKnopf.setForeground(Color.black);
		endeKnopf.setBackground(Color.lightGray);
		menue.add(endeKnopf);

		zeichnung.addMouseMotionListener(this);

		this.strichWahl = new JComboBox();

		for( Verbindung v : verbindungen ) {
			this.strichWahl.addItem(v.toString());
		}

		this.strichWahl.addActionListener(this);
		
		menue.add(this.strichWahl);

		behaelter.add(this.zeichnung, BorderLayout.CENTER);
	}

	public void setBehaelter(Container behaelter) {
		this.behaelter = behaelter;
	}
	
	
	public void actionPerformed(ActionEvent ereignis) {
		Object ereignisQuelle = ereignis.getSource();
		if (ereignisQuelle == loeschKnopf) {
			this.zeichnung.loesche();
		} else if (ereignisQuelle == endeKnopf) {
			System.exit(0);
		} else if (ereignisQuelle == this.strichWahl) {
			for (Verbindung v : verbindungen) {
				if (v.toString().compareTo(this.strichWahl.getSelectedItem().toString()) == 0) {
					this.aktuelleVerbindung = v;
					break;
				}
			}			
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getItem() == schwarz) {
			this.setColor(Color.black);
			farbWahl.setForeground(Color.white);
		} else if (e.getItem() == rot) {
			this.setColor(Color.red);
		} else if (e.getItem() == gelb) {
			this.setColor(Color.yellow);
		} else if (e.getItem() == gruen) {
			this.setColor(Color.green);
		} else if (e.getItem() == blau) {
			this.setColor(Color.blue);
		}
		// add new colors
		else if (e.getItem() == zyan) {
			this.setColor(Color.cyan);
		} else if (e.getItem() == magenta) {
			this.setColor(Color.magenta);
		}
	}

	private void setColor(Color c) {
		this.aktuelleVerbindung.aktualisiereFarbe(c);
		farbWahl.setBackground(c);
		farbWahl.setForeground(Color.black);
	}

	public void mouseDragged(MouseEvent e) {		
		
		this.aktuelleVerbindung.aktualisiereKoord(e.getX(),e.getY());
				
		this.zeichnung.addiere((Verbindung) this.aktuelleVerbindung.clone());
		this.zeichnung.repaint();		
	}

	public void mouseMoved(MouseEvent e) {
		this.aktuelleVerbindung.aktualisiereKoord(e.getX(),e.getY());
		
	}

	public void addiere(JComponent komponente) {
		behaelter.add(komponente);
	}

	public static void main(String[] argument) {

		JFrame f = new JFrame("Malen");

		Malen m = new Malen();
		m.setBehaelter(f.getContentPane());
		m.init();

		f.pack(); // Trick: Erzeugt Peer-Frame
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 400);
		f.setVisible(true);
	}

}