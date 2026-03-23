package practica20;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ej2 extends JFrame{

	private static final long serialVersionUID = 2535259759515106589L;

	/**
	 * Variables de instancia
	 */
	private JCheckBox chDiesel, chAsientos, chTapiceria, chLlantas, chPintura;
	private JComboBox<String> cbRadios;
	private JList<String> listaColores;
	private JLabel etiqueta;
	private JScrollPane spLista;
	
	// Mapa con los colores
	private Map<String,Color> mapaColores;  // Ejemplo: Amarillo, Color.Yellow

	
	/**
	 * Constructor
	 */
	public Ej2() {
		super("Eventos varios");
		
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
		
		this.getContentPane().add(panelPrincipal);

		control();
		
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
	
	
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ej2 ventana = new Ej2();
		
		ventana.setLocationRelativeTo(null);
		ventana.pack();
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Método que añade control a los componentes
	 */
	private void control() {
		this.listaColores.addListSelectionListener(new ControlLista());
	
		ControlItem ci = new ControlItem();
		
		this.chDiesel.addItemListener(ci);
		this.chAsientos.addItemListener(ci);
		this.chTapiceria.addItemListener(ci);
		this.chLlantas.addItemListener(ci);
		this.chPintura.addItemListener(ci);
		
		this.cbRadios.addItemListener(ci);
	}
	/**

	 * Clase que va a programar los eventos de las listas (JList)
	 * con la ayuda de la interfaz ListSelectionListener
	 */
	class ControlLista implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			etiqueta.setForeground(
					mapaColores.get(
							listaColores.getSelectedValue()));
		
			etiqueta.setText("Color pintura: " + listaColores.getSelectedValue());
			
		}
	} // fin clase ControlLista
	
	
	
	
	
	/**
	 * Clase para programar los eventos de tipo itemEvent, concretamente
	 * vamos a programar los CheckBox y el comboBox con la ayuda
	 * de la interfaz ItemListener 
	 * 
	 */
	class ControlItem implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			etiqueta.setForeground(Color.blue);
			
			// Comprobar si el componente que seha activado es el JComboBox
			if (e.getSource() == cbRadios) {
				etiqueta.setText("Número de radios: " + cbRadios.getSelectedItem());
				return;
			}
			
			// Si continuamos en esta línea de código, es porque se ha marcado/desmarcado
			// uno de los check
			
			// Guardar en variables locales el texto del check y su estado
			String textoCheck = ((JCheckBox)e.getSource()).getText();
			int estadoCheck = e.getStateChange();  // SELECTED o DESELECTED
			
			// Mostrar en la etiqueta el texto del check activado
			etiqueta.setText(textoCheck);
			
			// ---------------------------------------------------
			// Programar los check de Llantas, Pintura y Asientos
			// Primer planteamiento
			if (e.getSource() == chLlantas) {
				if (estadoCheck == ItemEvent.SELECTED) 
					cbRadios.setEnabled(true);
				else
					cbRadios.setEnabled(false);
			}
			else if (e.getSource() == chPintura) {
				if (estadoCheck == ItemEvent.SELECTED)
					spLista.setVisible(true);
				else
					spLista.setVisible(false);
			}
			else if (e.getSource() == chAsientos) {
				if (estadoCheck == ItemEvent.SELECTED) {
					chTapiceria.setSelected(true);
					chTapiceria.setEnabled(false);
				}
				else {
					chTapiceria.setSelected(false);
					chTapiceria.setEnabled(true);				}
			}
			
			// Segundo planteamiento
	/*		if (e.getSource() == chLlantas) {
				cbRadios.setEnabled(estadoCheck == ItemEvent.SELECTED);
			}
			else if (e.getSource() == chPintura) {
				spLista.setVisible(estadoCheck == ItemEvent.SELECTED);
			}
			else if (e.getSource() == chAsientos) {
				chTapiceria.setSelected(estadoCheck == ItemEvent.SELECTED);
				chTapiceria.setEnabled(estadoCheck == ItemEvent.DESELECTED);
				etiqueta.setText("Asientos deportivos");
			}
		*/	
			
			
		}
		
	}
	
} // Fin de la clase principal

