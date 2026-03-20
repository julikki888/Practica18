package practica19;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ej3 extends JFrame{

	private static final long serialVersionUID = 8252803797747008454L;

	JCheckBox cbMelon, cbNaranja, cbPlatano, cbManzana;
	JTextArea ta;
	
	
	public Ej3() {
		
		super("Prueba eventos ItemListener");
		
		Container contenPane = this.getContentPane();
		
		JPanel pCentro = new JPanel();
		JPanel pOeste = new JPanel();
		
		ta = new JTextArea();
		
		cbMelon = new JCheckBox("Melon");
		cbNaranja = new JCheckBox("Naranja");
		cbPlatano = new JCheckBox("Platano");
		cbManzana = new JCheckBox("Manzana");
		
		pOeste.add(cbMelon);
		pOeste.add(cbNaranja);
		pOeste.add(cbPlatano);
		pOeste.add(cbManzana);
		
		JScrollPane sp = new JScrollPane(ta);
		
		pCentro.add(sp);
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Ej3 gui = new Ej3();
		
		gui.setVisible(true);
		gui.pack();
		gui.setPreferredSize(new Dimension(400,300));
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	
	
}
