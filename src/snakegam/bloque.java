package snakegam;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class bloque extends Rectangle {
    
    int posX;
    int posY;
    int antposX;
    int antposY;
    
    bloque previous;
    
    public bloque(int x,int y,bloque p){
       super(main.bloque_tamaño,main.bloque_tamaño); 
       posX = x;
       posY = y;
       
       setTranslateX(posX * main.bloque_tamaño);
       setTranslateY(posY * main.bloque_tamaño);
    }
}
    
    

