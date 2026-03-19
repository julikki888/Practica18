package practica18;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class Ej1 extends JFrame implements FocusListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7267869947954630479L;
	JTextArea ta;
	
	public Ej1() {
		super("Ejemplo FocusLitener");
		
        Container contentPane = this.getContentPane();
		
		ta = new JTextArea();
		
		JPanel pNorte = new JPanel();
		
		contentPane.add(pNorte,BorderLayout.NORTH);
		
		pNorte.add(new JTextField("Campo de texto"));
		pNorte.add(new JLabel("Una Etiqueta"));
		pNorte.add(new JComboBox<String>(new String[]{"Selecciona item #1","Selecciona item #2","Selecciona item #3"}));
		pNorte.add(new JButton("Boton"));
		
		JPanel pCentro = new JPanel(new GridLayout(2,1));
		contentPane.add(pCentro,BorderLayout.CENTER);
		
	
		String[] strArray = new String[11];
		for (int i = 0; i <= 10; i++) {
			strArray[i]= "Lista item #"+i;
		}
		JList<String> miLista = new JList<>(strArray);
		
		JScrollPane sp1 = new JScrollPane(miLista);
		JScrollPane sp2 = new JScrollPane(ta);
		
		pCentro.add(sp1);
		pCentro.add(sp2);
		
		ta.addFocusListener(this);
	}
	public static void main(String[] args) {
		
		Ej1 gui = new Ej1();
		
		gui.setVisible(true);
		gui.pack();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		ta.append(e.paramString()+"\n");
	}

	@Override
	public void focusLost(FocusEvent e) {
		ta.append(e.paramString()+"\n");
	}

}
