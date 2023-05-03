/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author julia
 */
public class JPanelImage extends JPanel {
    private ImageIcon image;
    
    private final String path;
    
    public JPanelImage(String path) {
        this.path = path;
    }
    
    @Override
    public void paint (Graphics g) {
        image = new ImageIcon(getClass().getResource(path));
        g.drawImage(image.getImage(), 0, 0, null);
        setOpaque(false);
        super.paint(g);
    }
}
