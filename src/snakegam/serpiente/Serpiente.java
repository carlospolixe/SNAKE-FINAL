package snakegam.serpiente;
import Matriz.Matriz;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import snakegam.campo.CampodeJuego;
/**
 *
 * @author CarlosDiaz
 */
public class Serpiente {
    Matriz matriz2 = new Matriz();
   
    //Creamos un array para el cuerpo de la serpiente donde meteremos 
    //la cabeza de la serpiente con las posiciones dadas en la matriz
    public ArrayList<bloque> blocks = new ArrayList<bloque>();
   
    //Creamos el bloque cabeza
    bloque cabeza;
    
    public Serpiente(int il, CampodeJuego f) {
   
      //Añadimos la cabeza al bloque
      cabeza = new bloque (matriz2.posX,matriz2.posY,null,f);
      
      blocks.add(cabeza);
      //Le damos el color a la cabeza
      cabeza.setFill(Color.RED.desaturate());
      bloque previo = cabeza;
      
      //En este for creamos un bucle en el que va aumentando de 1 en 1 el tamaño de la serpiente
      for(int i= 1;i< il;i++){
          bloque b = new bloque(matriz2.posX + i, matriz2.posY,previo,f);
            blocks.add(b); 
          previo = b;
      }
     }
   //Obtenemos la direccion de la serpiente
   public int getDireccion(){
       return cabeza.direccion;
      
   }
   //Definimos la direccion de la serpiente
    public void setDireccion(int d){
        cabeza.direccion = d;
    }
    }


