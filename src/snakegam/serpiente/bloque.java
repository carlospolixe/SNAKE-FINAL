package snakegam.serpiente;

import javafx.scene.shape.Rectangle;
import snakegam.campo.CampodeJuego;
import snakegam.main;
import snakegam.main;

/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class bloque extends Rectangle {
    //Definimos las variables a usar en esta clase
    //Variables para el movimiento
    public static final int UP= 0,RIGHT=1,DOWN=2, LEFT=3;
    //Posiciones x e y
    int posX;
    int posY;
    //Posiciones x e y anteriores
    int antposX;
    int antposY;
    bloque previo;
    
    public int direccion = LEFT;
    //Posicionas maximas x e y
    int maxX, maxY;
    
    public bloque(int x,int y,bloque p, CampodeJuego f){
        // Hace referencia a un constructor de la clase main.
       super(main.bloque_tamaño,main.bloque_tamaño); 
       posX = x;
       posY = y;
       // Ponemos en funcion la posicion x e y , del tamaño del bloque 
       setTranslateX(posX * main.bloque_tamaño);
       setTranslateY(posY * main.bloque_tamaño);
       
       previo = p;
       //Devuelve la altura y anchura
       maxX= f.getW();
       maxY= f.getH();
       }
    //En este metodo actualizamos las posiciones de la serpiente
    public void actualizar(){
        //Igualamos las posiciones anteriores a las actuales.
        antposX=posX;
        antposY=posY;
        //En este if realizamos los movimientos de la serpiente
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
            //Si no vuelve a la antigua posicion
        }else {
            posX = previo.antposX;
            posY = previo.antposY;
        }
        actualizarPos();
    }
    //Metodo para mover hacia arriba
    public void moveArriba(){
        posY--;
        if(posY<0){
            posY=maxY - 1;
        }
    }
    //Metodo para mover hacia la derecha
    public void moveDerecha(){
        posX++;
        if(posX>=maxX){
            posX=0;
        }
    }
    //Metodo para mover hacia la izquierda
    public void moveIzquierda(){
        posX--;
        if(posX<0){
            posX=maxX - 1;
        }
    }
    //Metodo para mover hacia abajo
    public void moveAbajo(){
        posY++;
        if(posY>=maxY){
            posY=0;
        }
    }
    //Metodo para actualizar la posicion traduciendo su posicion
    public void actualizarPos(){
        
        setTranslateX(posX * main.bloque_tamaño);
        setTranslateY(posY * main.bloque_tamaño);
    }
}
    
    

