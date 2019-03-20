package snakegam.campo;

import snakegam.comida.Manzana;
import snakegam.serpiente.Serpiente;
import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import snakegam.serpiente.bloque;
import snakegam.main;
/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class CampodeJuego extends Pane {
    int randomX ;
    int randomY ;
    public int w,h;
    GridPane matriz = new GridPane();
    public ArrayList<bloque> blocks = new  ArrayList<bloque>();
    public Serpiente snake;
    public CampodeJuego(int ancho, int alto){
        w = ancho;
        h = alto;
        setMinSize(w * main.bloque_tamaño, h * main.bloque_tamaño);
        setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,new BorderWidths(1))));
        addManzana();
        addLimite();
    }
    public GridPane getMatriz(){
        getChildren().add(matriz);
        System.out.println(matriz);
        return matriz;
    }
    public void addLimite(){
         //Limites del juego
        Rectangle rarriba = new Rectangle();
        Rectangle rabajo = new Rectangle();
        Rectangle rderecha = new Rectangle();
        Rectangle rizquierda = new Rectangle();
        //Limite superior
        rarriba.setRotate(0);
        rarriba.setX(0);
        rarriba.setY(0);
        rarriba.setWidth(500);
        rarriba.setHeight(5);
        rarriba.setArcWidth(5);
        rarriba.setArcHeight(5);
        rarriba.setFill(Color.RED);
        getChildren().add(rarriba);
        //Limite inferior
        rabajo.setRotate(0);
        rabajo.setX(0);
        rabajo.setY(350);
        rabajo.setWidth(500);
        rabajo.setHeight(5);
        rabajo.setArcWidth(5);
        rabajo.setArcHeight(5);
        rabajo.setFill(Color.RED);
        getChildren().add(rabajo);
        //Limite derecha
        rderecha.setRotate(90);
        rderecha.setX(250);
        rderecha.setY(150);
        rderecha.setWidth(500);
        rderecha.setHeight(5);
        rderecha.setArcWidth(5);
        rderecha.setArcHeight(5);
        rderecha.setFill(Color.RED);
        getChildren().add(rderecha);
        //Limite izquierda
        rizquierda.setRotate(90);
        rizquierda.setX(-250);
        rizquierda.setY(150);
        rizquierda.setWidth(500);
        rizquierda.setHeight(5);
        rizquierda.setArcWidth(5);
        rizquierda.setArcHeight(5);
        rizquierda.setFill(Color.RED);
        getChildren().add(rizquierda);
    }
    public void addSnake(Serpiente s){
       snake = s; 
       s.blocks.forEach((b) -> {
           addBloque(b);
        });
    }
    
    public void actualizar(){
        for(bloque b:blocks){
            b.actualizar();
        }
    }
    
    public void addBloque(bloque b){
        getChildren().add(b);
        blocks.add(b);
    }
    
    public void addManzana(){
        randomX = (int)(Math.random()*w);
        randomY= (int)(Math.random()*h);
        Manzana manzana = new Manzana(randomX,randomY);
        getChildren().add(manzana);
    }
    
    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
