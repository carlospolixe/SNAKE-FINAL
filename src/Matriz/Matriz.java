/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;
import snakegam.campo.CampodeJuego;

/**
 *
 * @author Alex
 */
public class Matriz {
    public char [][] matriz= new char [50][35];
    int maxX=50;
    int maxY=35;
    int xManzana;
    int yManzana;
    int w = 50;
    int h = 35;
    int posX=25,posY=16;
    
    public Matriz() {
        for(int y=0; y<35; y++) {
            for(int x=0; x<50; x++) {
                matriz[x][y] = '0';
            }
        }
    }
    
    public void mostrarTablero() {
        for(int y=0; y<35; y++) {
            for(int x=0; x<50; x++) {
                System.out.print(matriz[x][y]);
            }
            System.out.println();
        }          
    }
    
    public void ponerManzana() {
        xManzana = (int)(Math.random()*w);
        yManzana= (int)(Math.random()*h);
        matriz[xManzana][yManzana] = 'M';
    } 
    
     public void quitarManzana(){
         
     matriz[xManzana][yManzana] = '0';
    }
    
    public void ponerSerpiente() {
        matriz[0][0]='0';
        System.out.println("Poniendo serpiente en " + posX + ", " + posY);
        matriz[posX][posY] = 'S';
    }     
//    //Aqui tengo que meter todos los posibles movimientos de la serpiente ARRIBA, ABAJO, IZQ y DERECHA
//    public void moverSerpiente(){
//        maxX= 50;
//        maxY= 35;
//       
//       posX++;
//    }
   //Metodo para mover hacia arriba
    public void moveArriba(){
        posY--;
        if(posY<0){
            System.out.println("Se está moviendo arriba");
            posY=maxY - 1;
        }
       int posAntX = posX-1;
       int posAntY = posY-1;
       if(posX>0 && posY>0){
           matriz[posAntX][posY] ='0';
           matriz[posX][posAntY] ='0';
       }
    }
    //Metodo para mover hacia la derecha
    public void moveDerecha(){
        posX++;
        if(posX>=maxX){
            System.out.println("Se está moviendo a la derecha");
            posX=0;
        }
       int posAntX = posX-1;
       int posAntY = posY-1;
       if(posX>0 && posY>0){
           matriz[posAntX][posY] ='0';
           matriz[posX][posAntY] ='0';
       }
    }
    //Metodo para mover hacia la izquierda
    public void moveIzquierda(){
        posX--;
        if(posX<0){
            System.out.println("Se está moviendo a la izquierda");
            posX=maxX - 1;
        }
       int posAntX = posX-1;
       int posAntY = posY-1;
       if(posX>0 && posY>0){
           matriz[posAntX][posY] ='0';
           matriz[posX][posAntY] ='0';
       }
    }
    //Metodo para mover hacia abajo
    public void moveAbajo(){
        posY++;
        if(posY>=maxY){
            System.out.println("Se está moviendo abajo");
            posY=0;
        }
       int posAntX = posX-1;
       int posAntY = posY-1;
       if(posX>0 && posY>0){
           matriz[posAntX][posY] ='0';
           matriz[posX][posAntY] ='0';
       }
    }
}
