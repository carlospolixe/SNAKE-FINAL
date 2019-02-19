package snakegam;

import javafx.scene.shape.Rectangle;
import snakegam.CampoJuego;
import snakegam.main;

/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class bloque extends Rectangle {
    public static final int UP= 0,RIGHT=1,DOWN=2, LEFT=3;
    int posX;
    int posY;
    int antposX;
    int antposY;
    bloque previo;
    
    int direccion = LEFT;
    
    int maxX, maxY;
    
    public bloque(int x,int y,bloque p, CampoJuego f){
       super(main.bloque_tamaño,main.bloque_tamaño); 
       posX = x;
       posY = y;
       
       setTranslateX(posX * main.bloque_tamaño);
       setTranslateY(posY * main.bloque_tamaño);
       
       previo = p;
       maxX= f.getW();
       maxY= f.getH();
       }
    
    public void actualizar(){
        System.out.println(previo);
        antposX=posX;
        antposY=posY;
        if(previo==null){
            switch(direccion){
                case UP:
                    moveArriba();
                    break;
                case RIGHT:
                    moveDerecha();
                    break;
                case LEFT:
                    moveIzquierda();
                    break;
                case DOWN:
                    moveAbajo();
                    break;
                    
            }
        }else {
            posX = previo.antposX;
            posY = previo.antposY;
        }
        actualizarPos();
    }
    public void moveArriba(){
        posY--;
        if(posY<0){
            posY=maxY - 1;
        }
    }
    public void moveDerecha(){
        posX++;
        if(posX>=maxX){
            posX=0;
        }
    }
    public void moveIzquierda(){
        posX--;
        if(posX<0){
            posX=maxX - 1;
        }
    }
    public void moveAbajo(){
        posY++;
        if(posY>=maxY){
            posY=0;
        }
    }
    public void actualizarPos(){
        
        setTranslateX(posX * main.bloque_tamaño);
        setTranslateY(posY * main.bloque_tamaño);
    }
}
    
    

