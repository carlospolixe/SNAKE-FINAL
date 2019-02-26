package snakegam;

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
    //Variables
    public static int bloque_tamaño = 10;
    int ancho = 50, alto =35;
    int il = 5;
    //Variable para comparar con la hora del sistema
    long then= System.nanoTime();
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(10);
        //root.setPadding(new Insets(10));
        CampodeJuego f = new CampodeJuego(ancho,alto);
        f.addSnake(new Serpiente(il,f));
        
        AnimationTimer mov = new AnimationTimer(){
            @Override
            public void handle(long now) {
                if(now - then>1000000000 / 8){
                f.actualizar();
                then = now;
            }
            }
        };
        mov.start();
        root.getChildren().add(f);
        Scene scene = new Scene(root);
        
        scene.setOnKeyPressed(e-> {
        if(e.getCode().equals(KeyCode.UP) && f.snake.getDireccion() != bloque.DOWN){
            f.snake.setDireccion(bloque.UP);
        }
        if(e.getCode().equals(KeyCode.DOWN)&& f.snake.getDireccion() != bloque.UP){
            f.snake.setDireccion(bloque.DOWN);
        }
        if(e.getCode().equals(KeyCode.RIGHT)&& f.snake.getDireccion() != bloque.LEFT){
            f.snake.setDireccion(bloque.RIGHT);
        }
        if(e.getCode().equals(KeyCode.LEFT)&& f.snake.getDireccion() != bloque.RIGHT){
            f.snake.setDireccion(bloque.LEFT);
        }
        });
        primaryStage.setTitle("SNAKEGAME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
    launch(args);
    }
    
}
