package practica18;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Iterator;

import javax.swing.*;

public class Ej1 extends JFrame implements FocusListener{

	JTextArea ta;
	
	public Ej1() {
		super("Ejemplo FocusLitener");
		
		ta = new JTextArea();
		
		JPanel pNorte = new JPanel();
		
		pNorte.add(new JTextField("Campo de texto"));
		pNorte.add(new JLabel());
		pNorte.add(new JComboBox<String>(new String[]{"Selecciona item #1","Selecciona item #2","Selecciona item #3"}));
		pNorte.add(new JButton("Boton"));
		
		JPanel pCentro = new JPanel(new GridLayout(1,2));
		
		JList<String> miLista = new JList<>();
		for (int i = 0; i < 10; i++) {
			miLista.add(new JLabel("Lista item #"+i));
		}
		
		JScrollPane sp1 = new JScrollPane(miLista);
		JScrollPane sp2 = new JScrollPane(ta);
		
		pCentro.add(sp1);
		pCentro.add(sp2);
		
		ta.addFocusListener(this);
	}
	
	
	
	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

}
