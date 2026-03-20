package practica19;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
		JPanel pOeste = new JPanel(new GridLayout(4,1,5,15));
		
		ta = new JTextArea();
		ta.setEditable(false);
		
		cbMelon = new JCheckBox("Melon");
		cbNaranja = new JCheckBox("Naranja");
		cbPlatano = new JCheckBox("Platano");
		cbManzana = new JCheckBox("Manzana");
		
		pOeste.add(cbMelon);
		pOeste.add(cbNaranja);
		pOeste.add(cbPlatano);
		pOeste.add(cbManzana);
		
		JScrollPane sp = new JScrollPane(ta);
		sp.setPreferredSize(new Dimension(200,200));
		
		pCentro.add(sp);
		
		contenPane.add(pOeste,BorderLayout.WEST);
		contenPane.add(pCentro,BorderLayout.CENTER);
		
		itemListener it = new itemListener();
		
		cbMelon.addItemListener(it);
		cbNaranja.addItemListener(it);
		cbPlatano.addItemListener(it);
		cbManzana.addItemListener(it);

	}
	
	class itemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			JCheckBox item = (JCheckBox) e.getSource();
			
			
			ta.append("Componente: "+item.getText()
						+ "\nEstado actual: "+ item.isSelected()
						+ "\nEstado actual: "+ e.getStateChange()
						+ "\n"+(e.getStateChange()==ItemEvent.SELECTED?"Seleccionado\n":"No Seleccionado\n"));
		}
		
	}
	

	public static void main(String[] args) {
		
		Ej3 gui = new Ej3();
		
		gui.setVisible(true);
		gui.pack();
		gui.setPreferredSize(new Dimension(400,300));
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	
	
}
