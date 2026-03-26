package prCalculadora;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.*;

public class Controlador implements ActionListener, FocusListener, KeyListener{
	
	ProcesaDatos pd;
	Vista miVista;
	
	public Controlador(Vista v) {
		miVista = v;
		pd = new ProcesaDatos(miVista.getTfRdo());
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char valorTecla = e.getKeyChar(); 
		JButton botonPulsado = null;		
		
		try {
			botonPulsado = asignaFoco(valorTecla);
			
			pd.procesa(valorTecla);
		} catch (MiExcepcion e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		JButton botonPulsado = (JButton) e.getSource();
		/*try {
			Integer.parseInt(botonPulsado.getActionCommand());
			e.getComponent().setBackground(Color.cyan);
		} catch (Exception e2) {
			e.getComponent().setBackground(UIManager.getColor("Button.setBackground"));
		}*/
		e.getComponent().setBackground((botonPulsado.getText().matches("[0-9]")?Color.CYAN:null));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botonPulsado = (JButton) e.getSource();
		
		

		char valorBotn = botonPulsado.getActionCommand().charAt(0);
		
		try {
			pd.procesa(valorBotn);
		} catch (MiExcepcion e1) {
			botonPulsado.setBackground(Color.RED);
			miVista.getTfRdo().setText(e1.getMessage());
		}
	}
	
}
