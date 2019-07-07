
package juegolssi;




import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
 
public class Sonidointro extends Thread {
    @Override
    public void run(){
      
        try {
            FileInputStream fis = null;
            Player player;
          
            fis= new FileInputStream("./Musica/intro.mp3");
            
            BufferedInputStream  bis= new BufferedInputStream(fis);
            
            
            player=new Player(bis);
            player.play();
        } catch (FileNotFoundException | JavaLayerException ex) {
            Logger.getLogger(Sonidointro.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
  
}