package snakegam;

import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import snakegam.main;


/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class CampoJuego extends Pane {
    private int w,h;
    
    public ArrayList<bloque> blocks = new  ArrayList<bloque>();
    public Serpiente snake;


    
    public CampoJuego(int ancho, int alto){
        w = ancho;
        h = alto;
        setMinSize(w * main.bloque_tamaño, h * main.bloque_tamaño);
        setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,new BorderWidths(1))));
        addManzana();
    }

    public CampoJuego() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        int randomX = (int)(Math.random()*w);
        int randomY= (int)(Math.random()*h);
        Manzana manzana = new Manzana(randomX,randomY);
        getChildren().add(manzana);
    }
    
    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
}
