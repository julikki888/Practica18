package practica20;

import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class ActA extends JFrame implements KeyListener{
    
    private static final long serialVersionUID = 6662344877285985110L;

    private JButton primero,segundo;
    private JLabel texto;
    
    public ActA() {
        
        super("");
        
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(3,1));
        
        primero = new JButton("Primero");
        segundo = new JButton("Segundo");
        texto = new JLabel("");
        
        c.add(primero);
        c.add(segundo);
        c.add(texto);
        
        segundo.addKeyListener(this);
        
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        this.texto.setText(texto.getText() + e.getKeyChar());
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public static void main(String[] args) {
        
        new ActA();
        
    }

}