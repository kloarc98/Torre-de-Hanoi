/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torre.de.hanoi;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * Kevin Oswaldo Loarca Fuentes
 * 0901-17-11537
 */
public class TorreDeHanoi {
    
    // Las 3 pilas de discos
    private Stack columnas[];
    private int longitud = 0;

        // Constructor, toma el nº de fichas total
        public TorreDeHanoi(int fichas) {
            columnas = new Stack[3];
            // Inicializamos las columnas vacias
            columnas[0] = new Stack();
            columnas[1] = new Stack();
            columnas[2] = new Stack();
            // Colocamos en la primera las fichas, de mayor a menor
                for (int i=fichas;i>0;i--) columnas[0].push(i);
}

// Muestra el estado actual
        public void Mostrar() {
            
            for (int i=0;i<3;i++) {
                System.out.print("Torre "+i+": ");
                    for (Iterator it = columnas[i].iterator(); it.hasNext();) {
                        int n = (int) it.next();
                        System.out.print(n+"["+"]");
                        longitud++;
                }
            System.out.println("");
            
            }
        }
        
        public int longitud(){
        return longitud;
    }

// Mueve de la columna origen a la columna destino 1 disco
        public void Mover(int origen, int destino) {
            
            // Mostramos en pantalla lo que hacemos
            Mostrar();
            System.out.println("Movemos desde ("+origen+") hasta ("+destino+")");
            System.out.println("Movimiento: "+ longitud());
            System.out.println("");
            
            
            // Y luego, lo hacemos, claro
            columnas[destino].push(columnas[origen].pop());
}

// Mueve de la columna origen a la columna destino varios discos
        public void MoverN(int origen, int destino, int cuantas) {
            // Si solo es uno, se mueve sin más
            if (cuantas <= 1) Mover(origen,destino);
                else {
                // Si son varios, entonces:
                // - Primero movemos N-1 a la columna ni origen ni destino
                    MoverN(origen,3 - (origen+destino),cuantas-1);
                    // - Movemos la N, es decir, la grande
                    Mover(origen,destino);
                    // - Movemos las N-1 del primer paso, a la col. destino
                    MoverN(3 - (origen+destino),destino,cuantas-1);
                    }
                }

// Programa principal
        public static void main(String args[]) {
            // Creamos una partida de 5 discos
            TorreDeHanoi h = new TorreDeHanoi(5);
            // Y la resolvemos (movemos de col.0 a col.2 los 5 discos
            h.MoverN(0,2,5);
            // Mostramos resultado, resuelto
            h.Mostrar();
            }
    
}
