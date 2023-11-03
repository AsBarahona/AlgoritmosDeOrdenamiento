import java.util.Arrays;

// CODIGO TOMADO DE: 
// https://tutospoo.jimdofree.com/tutoriales-java/m%C3%A9todos-de-ordenaci%C3%B3n/ordenaci%C3%B3n-por-combinaci%C3%B3n-mergesort/ 

public class MergeSort {

        public static void main(String args[]){
                //int large = 10000; // for the array with 10000 elements
                //int large = 100000; // for the array with 100000 elements
                int large = 1000000; // for the array with 1000000 elements

                int vec[]= MessyArray.generateMessyArray(large);

                //System.out.println("Vector original"); //To verify the original array 
                //imprimirVector(vec);

                long startTime = System.nanoTime(); // Start time
                ordenacionMergeSort(vec); // Calls the method that does the merge sort 
                long endTime = System.nanoTime();  //Finish time
                

                long duration = (endTime - startTime); // Calculate the duration in nanoseconds
                double seconds = duration / 1e9; // Convierte a segundos

                System.out.println("\nTiempo de ejecución (en segundos): " + seconds);

                //System.out.println("\nVector ordenado"); //To verify the result array 
                //imprimirVector(vec); 
        }
        
        public static void ordenacionMergeSort(int vec[]){
                if(vec.length<=1) return;
                int mitad= vec.length/2;
                int izq[]=Arrays.copyOfRange(vec, 0, mitad);
                int der[]=Arrays.copyOfRange(vec, mitad, vec.length);
                ordenacionMergeSort(izq);
                ordenacionMergeSort(der);       
                combinarVector(vec, izq, der);
        }
        
        public static void combinarVector(int v[], int izq[],int der[]){
                int i=0;
                int j=0;
                for(int k=0;k<v.length;k++){
                        if(i>=izq.length){
                                v[k]=der[j];
                                j++;
                                continue;
                        }
                        if(j>=der.length){
                                v[k]=izq[i];
                                i++;
                                continue;
                        }
                        if(izq[i]<der[j]){
                                v[k]=izq[i];
                                i++;
                        }else{
                                v[k]=der[j];
                                j++;
                        }
                }
        }
        
        public static void imprimirVector(int vec[]){
                for(int i=0;i<vec.length;i++){
                        System.out.print(vec[i]+" ");
                }
        }
        
}