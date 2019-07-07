
package juegolssi;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
 
public class Sonidotension extends Thread {
    @Override
    public void run(){
      
        try {
            FileInputStream fis = null;
            Player player;
          
            fis= new FileInputStream("./Musica/tension.mp3");
            
            BufferedInputStream  bis= new BufferedInputStream(fis);
            
            
            player=new Player(bis);
            player.play();
        } catch (FileNotFoundException | JavaLayerException ex) {
            Logger.getLogger(Sonidotension.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
  
}