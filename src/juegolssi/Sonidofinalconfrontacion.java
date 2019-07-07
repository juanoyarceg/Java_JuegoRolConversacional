
package juegolssi;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
 
public class Sonidofinalconfrontacion extends Thread {
    @Override
    public void run(){
      
        try {
            FileInputStream fis = null;
            Player player;
          
            fis= new FileInputStream("./Musica/finalconfrontacion.mp3");
            
            BufferedInputStream  bis= new BufferedInputStream(fis);
            
            
            player=new Player(bis);
            player.play();
        } catch (FileNotFoundException | JavaLayerException ex) {
            Logger.getLogger(Sonidofinalconfrontacion.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
  
}
