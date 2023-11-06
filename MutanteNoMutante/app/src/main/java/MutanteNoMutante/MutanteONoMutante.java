/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MutanteNoMutante;

/**
 *
 * @author admin
 */
public class MutanteONoMutante {
   
    public int contador = 0; //Declaramos contador para todo el proyecto
    
    public boolean mutante(String[][] dna){
    
        
    
    contador = contador + vertical(dna); // PASARLE PARA TENER DE FORMA CASI GLOBAL FILA, COLUMNA 
    contador = contador + diagonal(dna);
    contador = contador + horizontal(dna);
    //tambien desde aca podia llamar a los horizontales directamente
    
    if (contador >= 2){ //Si el contador es mayor o igual a 2 entonces retornamos true, ya que en el main if true es mutante, false no mutante 
        return true;
    }else{
        return false;
    }

    }
   public int horizontal(String[][] dna) {
       
    
    int filas = dna.length;
    int columna = dna[0].length;
    
    for (int i = 0; i < filas; i++) {
   
        for (int j = 0; j < columna - 3; j++) {   //Igualamos el elemento X en la matriz, y luego lo comparamos con el de el lado, por eso es J+1
            if (dna[i][j] == dna[i][j+1] && 
                dna[i][j] == dna[i][j+2] && 
                dna[i][j] == dna[i][j+3]) {
                contador++;
            }
        }
    }

    return contador;
}
    
 public int vertical(String[][] dna) {
    
int filas = dna.length;
    int columna = dna[0].length;
    
    for (int i = 0; i < filas - 3; i++) {
        for (int j = 0; j < columna; j++) { //Aca comparamos el elemento con el de abajo, ya que si sumamos i pasamos de 00 a 10 a 20
            if (dna[i][j] == dna[i+1][j] && 
                dna[i][j] == dna[i+2][j] && 
                dna[i][j] == dna[i+3][j]) {
                contador++;
            }
        }
    }

    return contador;
}   
 public int diagonal(String[][] dna){

contador = contador + izquierdaADerechaAbajo(dna);
contador = contador + izquierdaADerechaArriba(dna);
return contador;

}
    public int izquierdaADerechaAbajo(String[][] dna) {
   
        int filas = dna.length;
    int columna = dna[0].length;

    for (int i = 0; i < filas - 3; i++) {
        for (int j = 0; j < columna - 3; j++) { //Comparamos con el elemento de abajo a la derecha ya que comenzamos de arriba a la izuiqerda
            if (dna[i][j] == dna[i+1][j+1] &&                 //00 a 11 a 22
                dna[i][j] == dna[i+2][j+2] && 
                dna[i][j] == dna[i+3][j+3]) {
                contador++;
            }
        }
    }

    return contador;
}
public int izquierdaADerechaArriba(String[][] dna) {
    
    
    for (int i = dna.length - 1; i >= 3; i--) {
        for (int j = 0; j < dna[i].length - 3; j++) {  //probar empezar en el i ultimo y descontar hasta 3 digamos <<<--- FUNCIONA
            if (dna[i][j] == dna[i-1][j+1] && 
                dna[i][j] == dna[i-2][j+2] && 
                dna[i][j] == dna[i-3][j+3]) {
                contador++;
            }
        }
    }

    return contador;
}
}
