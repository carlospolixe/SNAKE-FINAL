package snakegam.serpiente;
import Matriz.Matriz;
import javafx.scene.shape.Rectangle;
import snakegam.campo.CampodeJuego;
import snakegam.main;

/**
 *
 * @author CarlosDiaz
 */
public class bloque extends Rectangle {
    
    Matriz matriz = new Matriz();
    //Definimos las variables a usar en esta clase
    //Variables para el movimiento
    public static final int UP= 0,RIGHT=1,DOWN=2, LEFT=3;
    //Posiciones x e y
    //Posiciones x e y anteriores
    int antposX;
    int antposY;
    bloque previo;
    
    public int direccion = LEFT;
 
    
    public bloque(int x,int y,bloque p, CampodeJuego f){
        // Hace referencia al metodo padre de la clase main.
       super(main.bloque_tamaño,main.bloque_tamaño); 
       matriz.posX = x;
       matriz.posY = y;
       // Ponemos en funcion la posicion x e y , del tamaño del bloque 
       setTranslateX(matriz.posX * main.bloque_tamaño);
       setTranslateY(matriz.posY * main.bloque_tamaño);
       
       previo = p;
       //Devuelve la altura y anchura
       matriz.maxX= f.getW();
       matriz.maxY= f.getH();
       }
    //En este metodo actualizamos las posiciones de la serpiente
    public void actualizar(){
        //Igualamos las posiciones anteriores a las actuales.
        antposX=matriz.posX;
        antposY=matriz.posY;
        //En este if realizamos los casos de movimientos de la serpiente 
        //conforme a los datos de la matriz
        if(previo==null){
            switch(direccion){
                case UP:
                    matriz.moveArriba();
                    break;
                case RIGHT:
                    matriz.moveDerecha();
                    break;
                case LEFT:
                    matriz.moveIzquierda();
                    break;
                case DOWN:
                    matriz.moveAbajo();
                    break;
                    
            }
            
        }else {
            matriz.posX = previo.antposX;
            matriz.posY = previo.antposY;
        }
        actualizarPos();
    }

    //Metodo para actualizar la posicion de la serpiente
    public void actualizarPos(){
        
        setTranslateX(matriz.posX * main.bloque_tamaño);
        setTranslateY(matriz.posY * main.bloque_tamaño);
    }
}
    
    

