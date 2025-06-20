import java.util.HashSet;

public class Methods {

    public static boolean sumaDeNumerosBasico (int [] arreglo, int requiredSum){
        boolean sumaCompleta = false; //Este Boolean detectara la suma de dos numeros del array es igual al entero pasado como param

        for (int i=0; i < arreglo.length-1; i++){     // Recorro el arreglo con un bucle for anidado (No es lo ideal por la complejidad)
            for (int j=i+1; j < arreglo.length; j++){ // De la manera que se plantea el ejercicio, el primer for debe cortar una posicion antes que la longitud del array para evitar indexar fuera de rango
                if (arreglo[i] + arreglo[j] == requiredSum){ //Condicion que detecta cuando la suma se cumple
                    sumaCompleta = true; //Setea el boolean en true.
                    System.out.println(arreglo[i]+ " + "+ arreglo[j]+" Es igual a " + requiredSum); // Al no haber un break, de existir mas combinaciones, las mostrara por consola.
                }
            }
        }
        return sumaCompleta;
    }

    public static boolean sumaDeNumerosComplejo (int [] arreglo, int requiredSum ){
        boolean sumaCompleta = false; //Este Boolean detectara la suma de dos numeros del array es igual al entero pasado como param

        HashSet<Integer> vistos = new HashSet<>(); //Declaro la estructura de datos HashSet, aqui se guardara cada elemento del array
        //De esta manera, evitamos recorrer el arreglo con dos bucles anidados.
        for (int num : arreglo) { //Recorro el arreglo con un for each
            int complemento = requiredSum - num; //Si al numero objetivo, le resto un numero del arreglo, me da como resultado el  numero faltante. Ese numero es el que almacena la variable complemento
            if (vistos.contains(complemento)) {  //Solo falta saber si complemento tambien existe en el arreglo. Gracias a HashSet podemos consultar en O(1)
                sumaCompleta = true; //Setea el boolean en true.
                System.out.println(num + " + " + complemento + " es igual a " + requiredSum); // Al no haber un break, de existir mas combinaciones, las mostrara por consola.
            }
            vistos.add(num); //Agrego num al HashSet.
        }
        return sumaCompleta;
    }

}
//Al realizar los calculos de complejidad, se puede notar que:
//En -sumaDeNumerosBasico- la complejidad es O(n²), esto se da al utilizar bucles for anidados.

//En -sumaDeNumerosComplejo- al implementar HashSet, podemos consultar en O(1).
//Como de todas maneras es necesario recorrer el arreglo con un bucle for, la complejidad depende del tamaño de la entrada (array)
//Por ende, complejidad = O(n).