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
public class NewFXMain {
    
    public static void main(String[] args) {
        Matriz mostrar = new Matriz();
        for(int y=0; y<10;y++){
        mostrar.ponerSerpiente();
        mostrar.ponerManzana();
        mostrar.mostrarTablero();
        mostrar.moveArriba();
        mostrar.moveAbajo();
        mostrar.moveIzquierda();
        mostrar.moveDerecha();
        
        System.out.println("---------------");
        mostrar.quitarManzana();
        }
    }
}
