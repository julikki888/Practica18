package ejer2MVC;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.HashMap;
import java.util.Vector;


public class Vista extends JPanel{

	private static final long serialVersionUID = 6148346265580389981L;
	
	/**
	 * Variables de instancia
	 */
	private JCheckBox chDiesel, chAsientos, chTapiceria, chLlantas, chPintura;
	private JComboBox<String> cbRadios;
	private JList<String> listaColores;
	private JLabel etiqueta;
	private JScrollPane spLista;
	private HashMap<String,Color> mapaColores;
	
	/**
	 * Constructor
	 */
	public Vista() {
		// Crear el panel principal
				JPanel panelPrincipal = new JPanel();
				panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
				panelPrincipal.setPreferredSize(new Dimension(300,350));
				panelPrincipal.setBorder(new EmptyBorder(15,15,15,15));
				
				// Añadir al panel principal el panel con los check
			//	JPanel panelCheck = preparaPanelCheck();
			//	panelPrincipal.add(panelCheck);
			
				panelPrincipal.add(preparaPanelCheck());
				panelPrincipal.add(preparaPanelLlantas());
				panelPrincipal.add(preparaPanelPintura());
				panelPrincipal.add(preparaPanelEtiqueta());
				
				this.add(panelPrincipal);
	}
	

	/**
	 * Método que crea los check y prepara el panel con ellos
	 * @return
	 */
	private JPanel preparaPanelCheck() {
		
		// Pedir  memoria para los check
		this.chDiesel = new JCheckBox("Diesel",true);
		this.chAsientos = new JCheckBox("Asientos deportivos",true);
		this.chTapiceria = new JCheckBox("Tapicería de cuero",true);
		this.chLlantas = new JCheckBox("Llantas de aleación",false);
		this.chPintura = new JCheckBox("Pintura metalizada",true);
		
		// Deshabilitar el check de la Tapicería de cuero, ya que está
		// marcado el check de asientos deportivos
		this.chTapiceria.setEnabled(false);
		
		// Crear el panel y añadir los 5 check
		JPanel p = new JPanel(new GridLayout(5,1));
		p.setBorder(new TitledBorder("Elija extras"));
		
		p.add(this.chDiesel);
		p.add(this.chAsientos);
		p.add(this.chTapiceria);
		p.add(this.chLlantas);
		p.add(this.chPintura);
		
		return p;
	}
	
	

	/**
	 * Método que prepara el panel de las llantas
	 * @return
	 */
	private JPanel preparaPanelLlantas() {
		
		String [] arrayLlantas = {"Tres radios", "Cinco radios", "Siete radios" , "Nueve radios"};
		
		this.cbRadios = new JComboBox<String>(arrayLlantas);
		this.cbRadios.setEnabled(false);
		
		JPanel p = new JPanel();
		p.add(this.cbRadios);
		p.setBorder(new TitledBorder("Elija número de llantas"));
		
		return p;
	}
	
	
	/**
	 * Método que prepara el panel de la pintura
	 * @return
	 */
	private JPanel preparaPanelPintura() {
	
	//	String [] arrayPintura = {"Rojo","Verde","Azul","Gris","Blanco","Negro","Naranja"};
		
	//	this.listaColores = new JList<String>(arrayPintura);
		
		// Pedir memoria para el mapa de colores, y cargar algunos valores
		this.mapaColores = new HashMap<String,Color>();
		
		mapaColores.put("Rojo", Color.RED);
		mapaColores.put("Verde", Color.GREEN);
		mapaColores.put("Negro", Color.BLACK);
		mapaColores.put("Azul", Color.BLUE);
		mapaColores.put("Amarillo", Color.YELLOW);
		mapaColores.put("Naranja", Color.ORANGE);
			
		// Extraer las claves del mapa anterior y guardarlas en una colecci n tipo Vector
		Vector<String> listaClaves = new Vector<String>(mapaColores.keySet());
		this.listaColores = new JList<String>(listaClaves);
		
		// Colocar el Jlist en un JScrollPane
		this.spLista = new JScrollPane(this.listaColores);
		this.spLista.setPreferredSize(new Dimension(80,40));
		
		// Prepara el panel
		JPanel p = new JPanel();
		p.add(spLista);
		p.setBorder(new TitledBorder("Elija color"));
		p.setPreferredSize(new Dimension(80,80));
		
		return p;
	}
	
	/**
	 * Preparar el panel con la etiqueta
	 * @return
	 */
	private JPanel preparaPanelEtiqueta() {
		
		this.etiqueta = new JLabel("Información");
		this.etiqueta.setForeground(Color.blue);
		
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Acciones realizadas"));
		p.add(etiqueta);
		
		return p;
	}


	public JCheckBox getChDiesel() {return chDiesel;}
	public JCheckBox getChAsientos() {return chAsientos;}
	public JCheckBox getChTapiceria() {return chTapiceria;}
	public JCheckBox getChLlantas() {return chLlantas;}
	public JCheckBox getChPintura() {return chPintura;}
	public JComboBox<String> getCbRadios() {return cbRadios;}
	public JList<String> getListaColores() {return listaColores;}
	public JLabel getEtiqueta() {return etiqueta;}
	public JScrollPane getSpLista() {return spLista;}
	public HashMap<String,Color> getMapaColores() {return mapaColores;}

	public void setChDiesel(JCheckBox chDiesel) {this.chDiesel = chDiesel;}
	public void setChAsientos(JCheckBox chAsientos) {this.chAsientos = chAsientos;}
	public void setChTapiceria(JCheckBox chTapiceria) {this.chTapiceria = chTapiceria;}
	public void setChLlantas(JCheckBox chLlantas) {this.chLlantas = chLlantas;}
	public void setChPintura(JCheckBox chPintura) {this.chPintura = chPintura;}
	public void setCbRadios(JComboBox<String> cbRadios) {this.cbRadios = cbRadios;}
	public void setListaColores(JList<String> listaColores) {this.listaColores = listaColores;}
	public void setEtiqueta(JLabel etiqueta) {this.etiqueta = etiqueta;}
	public void setSpLista(JScrollPane spLista) {this.spLista = spLista;}
	public void setMapaColores(HashMap<String,Color> mapaColores) {this.mapaColores = mapaColores;}
	
	
	/**
	 * Método que añade control a los componentes
	 */
	public void control(Controlador ctr) {
		this.listaColores.addListSelectionListener(ctr);
			
		this.chDiesel.addItemListener(ctr);
		this.chAsientos.addItemListener(ctr);
		this.chTapiceria.addItemListener(ctr);
		this.chLlantas.addItemListener(ctr);
		this.chPintura.addItemListener(ctr);
		
		this.cbRadios.addItemListener(ctr);
	}
	
	
	
}
