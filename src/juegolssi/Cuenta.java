
package juegolssi;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUAN
 */
public class Cuenta extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int segundos, i;
            String texto;
            texto = "El tiempo restante es ... ";
            for (i=10;i>0;i--) {
            System.out.println(texto+i); 
            if (i==1){
            
            System.out.println("SE TE ACABO EL TIEMPO - PERDISTE - cierra y vuelve a iniciar!!!!" );
            int div= 10/0;
            
            break;
            }
            try {
            Thread.sleep(1000);
            } catch (InterruptedException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
           
        
    }
}
