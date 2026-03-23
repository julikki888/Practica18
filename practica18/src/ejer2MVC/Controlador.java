package ejer2MVC;


import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controlador implements ListSelectionListener, ItemListener {
	
	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	
	/**
	 * Constructor
	 * @param v
	 */
	public Controlador(Vista v) {
		miVista = v;
	}

	/**
	 * Método de la interfaz ItemListener
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		miVista.getEtiqueta().setForeground(Color.blue);
		
		// Comprobar si el componente que seha activado es el JComboBox
		if (e.getSource() == miVista.getCbRadios()) {
			miVista.getEtiqueta().setText("Número de radios: " + miVista.getCbRadios().getSelectedItem());
			return;
		}
		
		// Si continuamos en esta línea de código, es porque se ha marcado/desmarcado
		// uno de los check
		
		// Guardar en variables locales el texto del check y su estado
		String textoCheck = ((JCheckBox)e.getSource()).getText();
		int estadoCheck = e.getStateChange();  // SELECTED o DESELECTED
		
		// Mostrar en la etiqueta el texto del check activado
		miVista.getEtiqueta().setText(textoCheck);
		
		// Programar los check de Llantas, Pintura y Asientos
		if (e.getSource() == miVista.getChLlantas()) {
			miVista.getCbRadios().setEnabled(estadoCheck == ItemEvent.SELECTED);
		}
		else if (e.getSource() == miVista.getChPintura()) {
			miVista.getSpLista().setVisible(estadoCheck == ItemEvent.SELECTED);
		}
		else if (e.getSource() == miVista.getChAsientos()) {
			miVista.getChTapiceria().setSelected(estadoCheck == ItemEvent.SELECTED);
			miVista.getChTapiceria().setEnabled(estadoCheck == ItemEvent.DESELECTED);
			miVista.getEtiqueta().setText("Asientos deportivos");
		}
		
		
		
	}

	/**
	 * Método de la interfaz ListSelectionListener
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
	
		miVista.getEtiqueta().setForeground(
				miVista.getMapaColores().get(
						miVista.getListaColores().getSelectedValue()));
	
		miVista.getEtiqueta().setText("Color pintura: " + miVista.getListaColores().getSelectedValue());
		
	}

}

