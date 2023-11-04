import java.util.Arrays;

// CODIGO TOMADO DE: 
//https://chat.openai.com/
public class RadixSort {
    public static void radixSort(int[] arr) {
        // Encuentra el valor máximo en el array para determinar el número de dígitos
        int max = Arrays.stream(arr).max().getAsInt();
        
        // Realiza el ordenamiento para cada dígito, desde el dígito menos significativo hasta el más significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
    
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        Arrays.fill(count, 0);
        
        // Contar la frecuencia de cada dígito en el dígito actual
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        // Calcular las posiciones reales de cada dígito en el array de salida
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Construir el array de salida
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        // Copiar el array de salida al array original
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    
    public static void main(String[] args) {

        //int large = 10000; // for the array with 10000 elements
        //int large = 100000; // for the array with 100000 elements
        int large = 1000000; // for the array with 1000000 elements

        int arr[]= MessyArray.generateMessyArray(large);
        
        //System.out.println("Array original: " + Arrays.toString(arr));

        long startTime = System.nanoTime(); // Start time
        radixSort(arr); // Calls the method that does the radix sort 
        long endTime = System.nanoTime();  //Finish time
        long duration = (endTime - startTime); // Calculate the duration in nanoseconds
        double seconds = duration / 1e9; // Convierte a segundos

        System.out.println("\nTiempo de ejecución (en segundos): " + seconds);
        
        //System.out.println("Array ordenado: " + Arrays.toString(arr));
    }
}

