package pastesci;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.*;
import static java.util.Collections.list;
import javax.swing.filechooser.FileFilter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        

            //Creamos selector de apertura
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("*.txt"));
            //Titulo que llevara la ventana
            chooser.setDialogTitle("Seleccionar carpeta de pegado");
            //Elegiremos archivos del directorio
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            //Si seleccionamos algún archivo retornaremos su directorio
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //Si no seleccionamos nada retornaremos No seleccion
       /// ---> mirar!!      System.out.println(chooser.);
            } else {
            System.out.println("No seleccion ");
            }
        
        
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
    

