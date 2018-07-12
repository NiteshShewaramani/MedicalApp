/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.india;

import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author bhupendra
 */
public class MediaTest {
    public static void main(String[] args) {
        JFileChooser fc=new JFileChooser();
        int result=fc.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            URL mediaURL=null;
            try {
                mediaURL=fc.getSelectedFile().toURL();
                
            } catch (Exception e) 
            {
                System.err.println(e);
            }
            if(mediaURL!=null)
            {
                JFrame mediaTest=new JFrame("Media Tester");
                mediaTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                MediaPanel mp=new MediaPanel(mediaURL);
                mediaTest.add(mp);
                mediaTest.setSize(400,400);
                mediaTest.setVisible(true);
                
            }
        }
    }
    
}
