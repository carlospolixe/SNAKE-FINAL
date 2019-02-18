package snakegam;

import java.util.ArrayList;

/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class Serpiente {
    ArrayList<bloque> blocks = new ArrayList<bloque>();

    bloque cabeza;
    
    public Serpiente(int il, CampoJuego f) {
      //nos devuelve el valor del ancho y el alto del juego
      int ipx = f.getW()/ 2;
      int ipy = f.getH()/ 2;
      
      cabeza = new bloque (ipx,ipy,null);
      
      bloque previo = cabeza;
      
      for(int i= 1;i< il;i++){
          bloque b = new bloque(ipx + i, ipy,previo);
          blocks.add(b); 
          previo = b;
      }
     }
    }


