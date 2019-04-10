package snakegam;
import Matriz.Matriz;
import snakegam.serpiente.bloque;
import snakegam.campo.CampodeJuego;
import snakegam.serpiente.Serpiente;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class main extends Application {
    /*
    crea un objeto de la clase matriz en la que podremos llamar a los diferentes 
    elementos de la matriz como pueden ser variables metodos y demas datos 
    necesarios
    */
    Matriz matriz = new Matriz();
    //Variables de tipo entero
    public static int bloque_tamaño = 10;
    int il = 5;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(10);
        CampodeJuego f = new CampodeJuego(matriz.maxX,matriz.maxY);
        f.addSnake(new Serpiente(il,f));
        /*
        animation timer que hace el movimiento de la serpiente conforme  a los
        datos dados por una variable de tipo tiempo llamada then que toma  la
        hora en segundos del sistema actualizando asi de forma visual los datos 
        los cuales incrementan en la matriz
        */
        AnimationTimer mov = new AnimationTimer(){
            @Override
            public void handle(long now) {
                if(now - matriz.then>1000000000 / 8){
                f.actualizar();
                matriz.then = now;
            }
            }
        };
        mov.start();
        root.getChildren().add(f);
        Scene scene = new Scene(root);
        
        //control de pulsciones de movimiento de la serpiente
        scene.setOnKeyPressed(e-> {
        /*
        iguala el dato de la cabeza de la serpiente al moviento  que estemos 
        haciendo y que anuna la opcion del movimiento contrario al que hagamos de 
        forma horizontal o vertical 
        */
        //CASO ARRIBA
        if(e.getCode().equals(KeyCode.UP) && f.snake.getDireccion() != bloque.DOWN){
            f.snake.setDireccion(bloque.UP);
        }
        //CASO ABAJO
        if(e.getCode().equals(KeyCode.DOWN)&& f.snake.getDireccion() != bloque.UP){
            f.snake.setDireccion(bloque.DOWN);
        }
        //CASO DERECHA
        if(e.getCode().equals(KeyCode.RIGHT)&& f.snake.getDireccion() != bloque.LEFT){
            f.snake.setDireccion(bloque.RIGHT);
        }
        //CASO IZQUIERDA
        if(e.getCode().equals(KeyCode.LEFT)&& f.snake.getDireccion() != bloque.RIGHT){
            f.snake.setDireccion(bloque.LEFT);
        }
        });
        
        //nombre del juego
        primaryStage.setTitle("SNAKE_GAME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
    launch(args);
    }
    
}
