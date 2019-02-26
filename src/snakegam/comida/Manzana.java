/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegam.comida;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import snakegam.main;

/**
 *
 * @author Alex
 */
public class Manzana extends Rectangle {
    int posX, posY;
    public Manzana(int x, int y){
        super(main.bloque_tamaño,main.bloque_tamaño);
        posX= x;
        posY=y;
        setTranslateX(posX * main.bloque_tamaño);
        setTranslateY(posY * main.bloque_tamaño);
        setFill(Color.LIGHTGREEN);
        setStroke(Color.GREEN);
        
    }
    
}
