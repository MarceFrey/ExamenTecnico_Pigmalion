public class Main {
    public static void main(String[] args) {

        int [] arreglo1 = {1,4,3,9};
        int [] arreglo2 = {1,2,4,4};
        int requiredSum = 8;

        System.out.println(Methods.sumaDeNumerosBasico(arreglo1, requiredSum));

        System.out.println(Methods.sumaDeNumerosComplejo(arreglo2, requiredSum));
    }
}