/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.india;

import java.awt.BorderLayout;
import java.awt.Component;
import java.net.URL;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.JPanel;

/**
 *
 * @author bhupendra
 */
public class MediaPanel extends JPanel
{
  public MediaPanel(URL mediaURL)
  {
      setLayout(new BorderLayout());
      Manager.setHint(Manager.LIGHTWEIGHT_RENDERER,true);
      try {
          Player mediaPlayer=Manager.createRealizedPlayer(mediaURL);
          Component video=mediaPlayer.getVisualComponent();
          Component controls=mediaPlayer.getControlPanelComponent();
          if(video!=null)
          {
              add(video, "Center");
          }
          if(controls!=null)
          {
              add(controls,"South");
          }
          mediaPlayer.start();
      } 
      catch (Exception e) 
      {
          System.out.println("No Media Player Found");
      }
      
      
      
      
      
      
      
      
      
      
      
  }
}
