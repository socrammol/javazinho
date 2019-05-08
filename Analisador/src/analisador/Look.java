/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Marcos Mol
 */
public class Look {
    
    	public static void definelook(Component tela){
		
		UIManager.LookAndFeelInfo Look[] = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(Look[1].getClassName());
			SwingUtilities.updateComponentTreeUI(tela); 
			SwingUtilities.updateComponentTreeUI(tela);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
