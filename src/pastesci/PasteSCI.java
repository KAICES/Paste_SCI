package pastesci;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.*;
import static java.util.Collections.list;
import javax.swing.filechooser.FileFilter;
import javax.swing.JFileChooser;
/**
 * @author cesar.ramirez
 */
public class PasteSCI {    
    
    public static void main(String[] args) {
        
     //** Busqueda de archivos .txt en el directorio para pegar     
        String path; 
        String files ;
        String f;
        int conteo;      
        path = "C:\\Users\\cesar.ramirez\\Documents\\para pegar" ;    
    //**************************
        String filesBrowse;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String pegado = "";                             
            try {
               // Apertura del fichero y creacion de BufferedReader para poder
               // hacer una lectura comoda (disponer del metodo readLine()).           
            int conteoLinea = 0;                      
            for (int j = 0; j < listOfFiles.length; j++){
                if (listOfFiles[j].isFile()){
                    archivo = new File ("C:\\Users\\cesar.ramirez\\Documents\\para pegar\\"+ 
                                        listOfFiles[j].getName() );
                }
                    fr = new FileReader (archivo);
                    br = new BufferedReader(fr);
                    String linea ;                     
                    while((linea=br.readLine())!=null) {  
                        String [] lineaComa = linea.split(",");                          
                        if (lineaComa.length > 5 ){
                        conteoLinea++;    
                        lineaComa[0] = Integer.toString(conteoLinea);
                        StringBuffer cadena = new StringBuffer(); 
                        for (int x=0;x<lineaComa.length;x++){
                             cadena =cadena.append(lineaComa[x]+","); 
                             pegado = cadena.toString() ;                          } 
                             System.out.println(pegado); 
                        }                             
                    }
            }
        }
            
        catch(Exception e){
        e.printStackTrace();       
        }
            
            finally{
               // En el finally cerramos el fichero, para asegurarnos
               // que se cierra tanto si todo va bien como si salta 
               // una excepcion.
               try{                    
                  if( null != fr ){   
                     fr.close();     
                  }                  
               }
               
               catch (Exception e2){ 
               e2.printStackTrace();
               }
            }           
   }    
}
    

