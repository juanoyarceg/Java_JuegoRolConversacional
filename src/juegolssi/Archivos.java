 
package juegolssi;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Archivos {
    
    protected String nombreArchivo;
    // En esta clase van los metodos cargar la historia (CSV), encriptar, desencriptar (ASCII) 
    //y la animación de los archivos (método Thread.sleep) 
   public void encriptar(String nombreArchivo)  {

        StringBuilder codificar = new StringBuilder();
         
        String dir_noencriptado="./dibujosnoencriptados/";
        String dir_encriptado="./dibujosencriptados/";
        File archivo_no_encriptado = new File(dir_noencriptado + nombreArchivo);
        FileWriter archivo_encriptado = null;
            try {
                archivo_encriptado = new FileWriter(dir_encriptado + nombreArchivo);
            } catch (IOException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        PrintWriter guardar_encriptado = new PrintWriter(archivo_encriptado);

        int clave = 5;
        String texto;

        try (Scanner leerArchivo = new Scanner(archivo_no_encriptado)) {

            while (leerArchivo.hasNext()) {
                texto = leerArchivo.nextLine();

                for (int i = 0; i < texto.length(); i++) {

                    codificar.append((char) (texto.charAt(i) + clave));
                }

                guardar_encriptado.println(codificar);

                codificar.delete(0, codificar.length());
            }

            guardar_encriptado.close();
            leerArchivo.close();
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void desencriptar(String nombreArchivo) throws FileNotFoundException {
        String dir_encriptado="./dibujosencriptados/";  
        int clave = -5;
        String descifrado;

        File archivo = new File(dir_encriptado + nombreArchivo);

        try (Scanner leerArchivo = new Scanner(archivo)) {

            while (leerArchivo.hasNext()) {
                StringBuilder cifrado = new StringBuilder();
                descifrado = leerArchivo.nextLine();

                for (int i = 0; i < descifrado.length(); i++) {

                    cifrado.append((char) (descifrado.charAt(i) + clave));
                }
                System.out.println(cifrado);
                 

                
            }
            leerArchivo.close();
        }
 System.out.println("\n");
    }
   
  
   
public static class  Historia extends Archivos{

       // protected String nombrejugador;
        
        public int nescena;
         
    
        Historia(String nom) {
            
           // this.nombrejugador =nom;
        }

        public Historia() {
        }
        
        public void leerDatos(int nesc) {
        
            try {
                CSVReader reader = new CSVReader(new FileReader("historiafull.csv"),';');
                String [] Escena;
                 System.out.println("-------------------------------------------------------"
                         + "----------------------------------------------------------------"
                         + "---------------------------------" );
                 System.out.println("");
                try {
                    while ((Escena = reader.readNext()) != null) {
                        
                       
                        this.nescena=nesc;
                       
                        System.out.println(Escena[nescena] );
                        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
       
                
                
protected static class  Dibujos extends Archivos{

        public Dibujos() {
           
        }
        public void leerdibujo(String nombreArchivo){
        
            try {
                super.desencriptar(nombreArchivo);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void encriptardibujos(){
        
           super.encriptar("0.txt");
           super.encriptar("1.txt");
           super.encriptar("2.txt");
           super.encriptar("3.txt");
           super.encriptar("4.txt");
           super.encriptar("5.txt");
           super.encriptar("6.txt");
           super.encriptar("7.txt");
           super.encriptar("8.txt");
           super.encriptar("9.txt");
           super.encriptar("10.txt");
           super.encriptar("11.txt");
           super.encriptar("12.txt");
           super.encriptar("13.txt");
           super.encriptar("14.txt");
           super.encriptar("15.txt");
           super.encriptar("16.txt");
           super.encriptar("17.txt");
           super.encriptar("18.txt");
           super.encriptar("19.txt");
          
        }
         
        
}
protected static class  Animaciones extends Archivos{

        public Animaciones() {
            
        }
        public void encriptaranimaciones(){
           super.encriptar("Bus1.txt");
           super.encriptar("Bus2.txt");
           super.encriptar("Bus3.txt");
           super.encriptar("Disparo1.txt");
           super.encriptar("Disparo2.txt");
           super.encriptar("Disparo3.txt");
           super.encriptar("Disparo4.txt");
           super.encriptar("Disparo5.txt");
           super.encriptar("INICIO.txt");
           super.encriptar("INICIO2.txt");
           super.encriptar("muerte1.txt");
           super.encriptar("muerte2.txt");
           super.encriptar("muerte3.txt");
           super.encriptar("paso1.txt");
           super.encriptar("paso2.txt");
       
        }
       public void leeranimaciones(String nombreArchivo){
        
            try {
                super.desencriptar(nombreArchivo);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
       public void animacionBus() throws InterruptedException{
       
       leeranimaciones("Bus1.txt");
        Thread.sleep(1000);
       leeranimaciones("Bus2.txt");
        Thread.sleep(1000);
       leeranimaciones("Bus3.txt");
        Thread.sleep(1000);
       leeranimaciones("Bus1.txt");
        Thread.sleep(1000);
       leeranimaciones("Bus2.txt");
        Thread.sleep(1000);
       leeranimaciones("Bus3.txt");
        Thread.sleep(1000);
       }
       public void animacionInicio() throws InterruptedException{
       
       leeranimaciones("INICIO.txt");
        Thread.sleep(1500);
       leeranimaciones("INICIO2.txt");
        Thread.sleep(1500);
       leeranimaciones("INICIO.txt");
        Thread.sleep(2000);
       leeranimaciones("INICIO2.txt");
        Thread.sleep(1000);
     
       }
       public void animacionDisparo() throws InterruptedException{
       
       leeranimaciones("Disparo1.txt");
        Thread.sleep(1000);
       leeranimaciones("Disparo2.txt");
        Thread.sleep(1000);
       leeranimaciones("Disparo3.txt");
        Thread.sleep(1200);
       leeranimaciones("Disparo4.txt");
        Thread.sleep(1200);
       leeranimaciones("Disparo5.txt");
        Thread.sleep(1000);
     
       }
        public void animacionPaso() throws InterruptedException{
       
       leeranimaciones("paso1.txt");
        Thread.sleep(1000);
       leeranimaciones("paso2.txt");
        Thread.sleep(1000);
       leeranimaciones("paso1.txt");
        Thread.sleep(1200);
       leeranimaciones("paso2.txt");
        Thread.sleep(1200);
       leeranimaciones("paso1.txt");
        Thread.sleep(1000);
       leeranimaciones("paso2.txt");
        Thread.sleep(1000);
       }
          public void animacionMuerte() throws InterruptedException{
       
       leeranimaciones("muerte1.txt");
        Thread.sleep(1000);
       leeranimaciones("muerte2.txt");
        Thread.sleep(1000);
       leeranimaciones("muerte3.txt");
        Thread.sleep(1200);
       leeranimaciones("muerte2.txt");
        Thread.sleep(1200);
       leeranimaciones("muerte1.txt");
        Thread.sleep(1000);
       leeranimaciones("muerte3.txt");
        Thread.sleep(1000);
       }
        }

}
}