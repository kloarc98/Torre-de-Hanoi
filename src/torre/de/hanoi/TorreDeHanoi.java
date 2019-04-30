/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torre.de.hanoi;
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class TorreDeHanoi {

    static int nMovimientos = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          // LEE EL NUMERO DE DISCOS
        Scanner teclado = new Scanner(System.in);
        System.out.print("Numero de discos: ");
        int nDiscos = teclado.nextInt();
        System.out.println("");
        
        Hanoi(nDiscos, "TORRE 1", "TORRE 2", "TORRE 3");
        
        System.out.println("Se resolvio en: "+nMovimientos+" Movimientos.");
        
    }
    
    // METODO RECURSIVO
    public static void Hanoi(int disco, String torreA, String torreB, String torreC) {
        if(disco == 1) {
            nMovimientos = nMovimientos + 1;
            System.out.println(nMovimientos+": Mover disco "+disco+" de "+torreA+" a "+torreC);
        } else {      
            Hanoi(disco-1, torreA, torreC, torreB);
            nMovimientos = nMovimientos + 1;
            System.out.println(nMovimientos+": Mover disco "+disco+" de "+torreA+" a "+torreC);
            Hanoi(disco-1, torreB, torreA, torreC);
        }
    }
    
}
