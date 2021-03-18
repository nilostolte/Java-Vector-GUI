package com;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Window  extends JFrame {
	   private MenuInfographics6 menu;
	   public Window() {
	      super("");
	      calculateWindowsBounds();
	      setSize(virtualBounds.width, virtualBounds.height );
	      setLocation(0,0);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      //setLocationRelativeTo(null);
	      setResizable(false);
	      setUndecorated(true);
	      setBackground(new Color(0f, 0f, 0f, 0f));
	      menu = new MenuInfographics6();
	      getContentPane().add(menu); 
	   }
	   private Rectangle virtualBounds = new Rectangle();
	   private void calculateWindowsBounds() {
		   GraphicsEnvironment ge = GraphicsEnvironment.
		           getLocalGraphicsEnvironment();
		   GraphicsDevice[] gs =
		           ge.getScreenDevices();
		   for (int j = 0; j < gs.length; j++) {
		       GraphicsDevice gd = gs[j];
		       GraphicsConfiguration[] gc =
		           gd.getConfigurations();
		       for (int i=0; i < gc.length; i++) {
		           virtualBounds =
		               virtualBounds.union(gc[i].getBounds());
		       }
		   }
	   }
	   public static void main(String[] args) {
	      SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            new Window().setVisible(true);
	         }
	      });
	   }
	}