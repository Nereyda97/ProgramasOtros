/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author taller
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           imp=LeerVariable.leerEntero ("Que desea imprimir fila (DIGITE 1),columna (DIGITE 2): ");
    nro=LeerVariable.leerEntero ("digite el numero de fila o columna que desea imprimir: ");
    /*El usuario quiere Imprimir Filas*/
    if (imp==1){
           for (int j=0;i<M;j++)
                 System.out.println(A[nro][j]+"  ");
    }
    /*El usuario desea Imprimir columnas*/
    else{
            if (imp==2){
                for (int i=0;i<N;i++)
                   System.out.println(A[i][nro]+"  ");
            }
            else
                   System.out.pritln("No sea tan tonto, Dije que Ingrese 1 o 2 Tontin");
    }
    }
    
}
