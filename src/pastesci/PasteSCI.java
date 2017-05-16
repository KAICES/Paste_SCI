package pastesci;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.util.Collections.list;
import javax.swing.filechooser.FileFilter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * @author cesar.ramirez
 */
public class PasteSCI {        
     //** Busqueda de archivos .txt en el directorio para pegar 
    public static void main(String[] args) throws IOException {
    
        String path = "", path2 = "" ;
        String files ;
        String f;
        int conteo; 
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(chooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            path = (file.getPath());            
        }
        
        else {     
            
            System.exit(0);
        }
    //*******************************************************************************************************
        String filesBrowse;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();         
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String pegado = ""; 
        FileWriter flwriter = null;
        String texto = JOptionPane.showInputDialog("Nombre del archivo a guardar")+".txt"; 
            try {
               //crea el flujo para escribir en el archivo       
               flwriter = new FileWriter( path+ "\\"+texto);
               //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
               BufferedWriter bfwriter = new BufferedWriter(flwriter);
               int conteoLinea = 0;                      
               for (int j = 0; j < listOfFiles.length; j++){
                    if (listOfFiles[j].isFile()){
                        archivo = new File (  path + "\\" + listOfFiles[j].getName() );
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
                                         pegado = cadena.toString() ;      
                                        } 
                                    
                                        System.out.println(pegado);
                                        bfwriter.write(pegado);
                                        bfwriter.newLine();
                                         
                                    }          
                                }       
                            }
               
                bfwriter.close();   
                JOptionPane.showMessageDialog(null,"Archivo "+ texto + " creado satisfactoriamente..");
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
    

