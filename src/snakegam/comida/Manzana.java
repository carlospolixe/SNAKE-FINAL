package snakegam.comida;
import Matriz.Matriz;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import snakegam.main;

/**
 *
 * @author Carlos
 */

/*
 Clase publica donde dibujamos la manzana de forma visual y la añadimos a 
 la posicion del campo de juego correspondiente al dato de la matriz
*/

public class Manzana extends Rectangle {
    Matriz matriz2 = new Matriz();
    public Manzana(int x, int y){
        super(main.bloque_tamaño,main.bloque_tamaño);
        setTranslateX(matriz2.posX * main.bloque_tamaño);
        setTranslateY(matriz2.posY * main.bloque_tamaño);
        setFill(Color.LIGHTGREEN);
        setStroke(Color.GREEN);
        
    }
    
}
