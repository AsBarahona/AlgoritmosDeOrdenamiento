import java.util.Random;

public class MessyArray {

    public static int[] generateMessyArray(int large) {  //Make the array with the established number of elements.
        int[] array = new int[large];
        for (int i = 0; i < large; i++) {
            array[i] = i + 1;
        }

        Random random = new Random(); // unorder the array
        for (int i = 0; i < large; i++) {
            int j = random.nextInt(large);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }

    public static void printArray(int[] array) { //Prints it (to verify)
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) { 
        int[] array = generateMessyArray(10000);
        System.out.println("Arreglo desordenado creado:");
        printArray(array);
    }
}

