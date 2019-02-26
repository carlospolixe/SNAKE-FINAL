package snakegam.serpiente;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import snakegam.campo.CampodeJuego;
/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class Serpiente {
    //Creamos una lista de arrays para el cuerpo de la serpiente
    public ArrayList<bloque> blocks = new ArrayList<bloque>();
    //Creamos el bloque cabeza
    bloque cabeza;
    
    public Serpiente(int il, CampodeJuego f) {
      //nos devuelve el valor del ancho y el alto del juego
      int ipx = f.getW()/ 2;
      int ipy = f.getH()/ 2;
      //Añadimos la cabeza al bloque
      cabeza = new bloque (ipx,ipy,null,f);
      blocks.add(cabeza);
      //Le damos el color a la cabeza
      cabeza.setFill(Color.RED.desaturate());
      bloque previo = cabeza;
      
      //En este for creamos un bucle en el que va aumentando de 1 en 1 el tamaño de la serpiente
      for(int i= 1;i< il;i++){
          bloque b = new bloque(ipx + i, ipy,previo,f);
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


