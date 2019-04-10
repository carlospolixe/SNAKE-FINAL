package snakegam.campo;
import Matriz.Matriz;
import snakegam.comida.Manzana;
import snakegam.serpiente.Serpiente;
import java.util.ArrayList;
import javafx.scene.Scene;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import snakegam.serpiente.bloque;
import snakegam.main;
/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class CampodeJuego extends Pane {
    Matriz matriz2 = new Matriz();
    GridPane matriz = new GridPane();
    public ArrayList<bloque> blocks = new  ArrayList<bloque>();
    public Serpiente snake;
    public CampodeJuego(int ancho, int alto){

        setMinSize(matriz2.w* main.bloque_tamaño, matriz2.h * main.bloque_tamaño);
        setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND,null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,new BorderWidths(1))));
        addManzana();
        addLimite();
    }

    
    
    //metodo publico de los limites visuales del juego
    public void addLimite(){
         //Limites del juego
        Rectangle rarriba = new Rectangle();
        Rectangle rabajo = new Rectangle();
        Rectangle rderecha = new Rectangle();
        Rectangle rizquierda = new Rectangle();
        //Limite superior del recuadro de juego---------------------------------
        rarriba.setRotate(0);
        rarriba.setX(0);
        rarriba.setY(0);
        rarriba.setWidth(500);
        rarriba.setHeight(5);
        rarriba.setFill(Color.RED);
        getChildren().add(rarriba);
        //Limite inferior del recuadro de juego---------------------------------
        rabajo.setRotate(0);
        rabajo.setX(0);
        rabajo.setY(350);
        rabajo.setWidth(500);
        rabajo.setHeight(5);
        rabajo.setFill(Color.RED);
        getChildren().add(rabajo);
        //Limite derecho del recuadro de juego----------------------------------
        rderecha.setRotate(90);
        rderecha.setX(250);
        rderecha.setY(100);
        rderecha.setWidth(500);
        rderecha.setHeight(5);
        rderecha.setFill(Color.RED);
        getChildren().add(rderecha);
        //Limite izquierdo del recuadro de juego--------------------------------
        rizquierda.setRotate(90);
        rizquierda.setX(-250);
        rizquierda.setY(100);
        rizquierda.setWidth(500);
        rizquierda.setHeight(5);
        rizquierda.setFill(Color.RED);
        getChildren().add(rizquierda);
    }
    /*
     metodo publico con el que se añade la cabeza de la serpiente junto al 
     cuerpo al campo de juego de forma visual 
    */
    public void addSnake(Serpiente s){
       snake = s; 
       s.blocks.forEach((b) -> {
           addBloque(b);
        });
    }
    //metodo el cual actualiza la pocion visual de la serpiente en el campo de juego
    public void actualizar(){
        for(bloque b:blocks){
            b.actualizar();
        }
    }
    
    public void addBloque(bloque b){
        getChildren().add(b);
        blocks.add(b);
    }
    /*
    metodo que añade la manzana de forma visual conforme a los datos dados
    por la matriz creando ala clase manzana conforme a las posiciones de la
    manzana en la matriz y que ejecute
    */
    public void addManzana(){
        System.out.println(matriz2.xManzana + matriz2.yManzana);
        Manzana manzana = new Manzana(matriz2.xManzana,matriz2.yManzana);
        getChildren().add(manzana);
        System.out.println("Poniendo MANZANA en " + matriz2.posX + ", " + matriz2.yManzana);
        matriz2.comerManzana();
    }
    /*
     metodo publico que muestra un mensaje fin de juego cuando  la serpiente choca 
     con los limites predefinidos en la matriz en el metodo de  GameOver
    */
    public void finjuego(){ 
        matriz2.gameOver();
        Text derrota = new Text ("¡¡GAME OVER!!");
        derrota.setFont(Font.font(20));
        derrota.setX(150);
        derrota.setY(150);
        derrota.setFill(Color.BLACK);
    }
    
    /*
    metodo publico en que mostramos de forma visual la parte donde la cabeza de 
    la serpiente se come la manzana
     */
    public void comiendo(){ 
        matriz2.comerManzana();
        
    }
    
    /*
    metodo publico por el cual se retorna el dato  del tipo entero de el ancho
    del juego conforme al dato dado en la matriz
     */
    public int getW() {
        return matriz2.w;
    }
    
    /*
    metodo publico por el cual se retorna el dato de tipo entero de el alto del 
    juego conforme al dato dado en la matriz
     */
    public int getH() {
        return matriz2.h;
    }
}
