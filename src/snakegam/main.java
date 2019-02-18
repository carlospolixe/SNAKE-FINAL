package snakegam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author CarlosDiaz,Alejando Dianez 
 */
public class main extends Application {
    
    static int bloque_tamaño = 10;
    int ancho = 30, alto =15;
    int il = 5;
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(10);
        //root.setPadding(new Insets(10));
        CampoJuego f = new CampoJuego(ancho,alto);
        f.addSnake(new Serpiente(il,f));
        root.getChildren().add(f);
      
       
        Scene scene = new Scene(root, 950, 1010);
        primaryStage.setTitle("SNAKEGAME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
