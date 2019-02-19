package snakegam;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import snakegam.CampoJuego;

/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class Serpiente {
    public ArrayList<bloque> blocks = new ArrayList<bloque>();

    bloque cabeza;
    
    public Serpiente(int il, CampoJuego f) {
      //nos devuelve el valor del ancho y el alto del juego
      int ipx = f.getW()/ 2;
      int ipy = f.getH()/ 2;
      
      cabeza = new bloque (ipx,ipy,null,f);
      blocks.add(cabeza);
      
      cabeza.setFill(Color.RED.desaturate());
      bloque previo = cabeza;
      
      for(int i= 1;i< il;i++){
          bloque b = new bloque(ipx + i, ipy,previo,f);
          blocks.add(b); 
          previo = b;
      }
     }
    
   public int getDireccion(){
       return cabeza.direccion;
   }
    public void setDireccion(int d){
        cabeza.direccion = d;
    }
    }


