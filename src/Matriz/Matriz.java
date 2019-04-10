/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;
import java.util.ArrayList;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;

/**
 *
 * @author Alex
 */
public class Matriz {
    //Lista de variables publicas a usar en la clase y en el resto de paquetes
    public char [][] matriz= new char [50][35];
    public int maxX=50;
    public int maxY=35;
    public int w = 50;
    public int h = 35;
    public int velocidad=1;
    public int posX=25,posY=16;
    public long then= System.nanoTime();
    public int xManzana = (int)(Math.random()*w);
    public int yManzana = (int)(Math.random()*h);
    ArrayList<Point> listaCuerpo = new ArrayList();
    public int longitud;
    public int tamaño;
    
    //Metodo constructor para crear la matriz
    public Matriz() {
        for(int y=0; y<35; y++) {
            for(int x=0; x<50; x++) {
                matriz[x][y] = '0';
            }
        }
    }
    
    //Metodo para mostrar el tablero en la consola
    public void mostrarTablero() {
        for(int y=0; y<35; y++) {
            for(int x=0; x<50; x++) {
                System.out.print(matriz[x][y]);
            }
            System.out.println();
        }          
    }
    //Metodo para insertar la manzana en la matriz
    public void ponerManzana() {
        //Creamos variables aleatorias en funcion de la anchura y altura de 
        // el tablero
        xManzana = (int)(Math.random()*w);
        yManzana= (int)(Math.random()*h);
        matriz[xManzana][yManzana] = 'M';
         System.out.println("·Poniendo manzana...");
    } 
    
    //Metodo para quitar    
     public void quitarManzana(){
         
     matriz[xManzana][yManzana] = '0';
    }
    
     //Metodo para insertar serpiente
    public void ponerSerpiente() {
        //Insertamos la serpiente en la posicion indicada
        System.out.println("·Poniendo serpiente en " + posX + ", " + posY);
        matriz[posX][posY] = 'S';
        //Creamos el cuerpo de la serpiente mediante un ArrayList<Point>
        listaCuerpo.add(new Point(posX, posY, 0, Color.BLACK));
        listaCuerpo.add(new Point(posX, posY+1, 0, Color.BLACK));
        listaCuerpo.add(new Point(posX, posY+2, 0, Color.BLACK));
        listaCuerpo.add(new Point(posX, posY+3, 0, Color.BLACK));
    }     
    
   //Metodo para mover hacia arriba
    
    public void moveArriba(){
        //En esta variables guardamos constantemente el tamaño de la lista
        tamaño=listaCuerpo.size();
        //Añadimos un nuevo punto para que se realice el movimiento 
        listaCuerpo.add(0,new Point(posX, posY-1, 0, Color.RED));
        posY-=velocidad;
        //Con este bucle obtenemos las posiciones en todo momento de snake
        for(int i=0; i<tamaño; i++){
            Point p = listaCuerpo.get(i);
            System.out.println("[Punto X: " + p.getX() + "  , Punto Y: " + p.getY() + "]");
        }
        System.out.println("·Serpiente en: " + posX + ", " + posY);
        System.out.println("·Se está moviendo arriba");      
       int posAntY = posY+1;
           matriz[posX][posAntY] ='0';
    }
    //Metodo para mover hacia la derecha
    public void moveDerecha(){
        tamaño=listaCuerpo.size();
        listaCuerpo.add(0,new Point(posX+1, posY, 0, Color.RED));

        for(int i=0; i<tamaño; i++){
            Point p = listaCuerpo.get(i);
            System.out.println("[Punto X: " + p.getX() + "  , Punto Y: " + p.getY() + "]");
        }
        posX+=velocidad;
        System.out.println("·Serpiente en: " + posX + ", " + posY);
        System.out.println("·Se está moviendo a la derecha");

       int posAntX = posX-1;
           matriz[posAntX][posY] ='0';
    }
    //Metodo para mover hacia la izquierda
    public void moveIzquierda(){
        tamaño=listaCuerpo.size();
        listaCuerpo.add(0,new Point(posX-1, posY, 0, Color.RED));
     
        for(int i=0; i<tamaño; i++){
            Point p = listaCuerpo.get(i);
            System.out.println("[Punto X: " + p.getX() + "  , Punto Y: " + p.getY() + "]");
        }
        posX-=velocidad;
        System.out.println("·Serpiente en: " + posX + ", " + posY);
        System.out.println("·Se está moviendo a la izquierda");

       int posAntX = posX+1;
           matriz[posAntX][posY] ='0';
    }
    //Metodo para mover hacia abajo
    public void moveAbajo(){
        tamaño=listaCuerpo.size();
        listaCuerpo.add(0,new Point(posX, posY+1, 0, Color.RED));
   
        for(int i=0; i<tamaño; i++){
            Point p = listaCuerpo.get(i);
            System.out.println("[Punto X: " + p.getX() + "  , Punto Y: " + p.getY() + "]");
        }
      posY+=velocidad;
      System.out.println("·Serpiente en: " + posX + ", " + posY);
        System.out.println("·Se está moviendo abajo...");

       int posAntY = posY-1;
           matriz[posX][posAntY] ='0';
    }
    
    //Metodo para comer manzana
    public void comerManzana(){
        //longitud = listaCuerpo.size() - 1 ;
        if(posX==xManzana && posY==yManzana){
            System.out.println("·Comiendo manzana...");
            quitarManzana();
            ponerManzana();
        }
        //else listaCuerpo.remove(longitud);
        System.out.println("·No come manzana...");
    }
    //Metodo GameOver
    public boolean gameOver(){
        if(posX==49 || posY==34 || posX==0 || posY==0){
            velocidad=0;
            quitarManzana();
            matriz[posX][posY] = '0';
            listaCuerpo.clear();
            System.out.println("                 ¡GAMEOVER!");
            return true;
        }
        System.out.println("·Sigue el juego...");
        return false;
    }
}
