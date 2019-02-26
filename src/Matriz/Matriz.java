/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;
/**
 *
 * @author Alex
 */
public class Matriz {
    public char [][] matriz= new char [50][35];
        int w = 50;
        int h = 35;
        int posX=0,posY=0;
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
        int randomX = (int)(Math.random()*w);
        int randomY= (int)(Math.random()*h);
        matriz[randomX][randomY] = 'M';
    } 
    public void ponerSerpiente() {
        matriz[posX][posY] = 'S';
    } 
    
    //Aqui tengo que meter todos los posibles movimientos de la serpiente ARRIBA, ABAJO, IZQ y DERECHA
    public void moverSerpiente(){
       int posAnt= posX-1;
       if(posX>0){
           matriz[posAnt][posY] ='0';
       }
       posX++;
    }
    }
