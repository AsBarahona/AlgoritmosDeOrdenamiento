// CÓDIGO TOMADO DE:
//https://tutospoo.jimdofree.com/tutoriales-java/m%C3%A9todos-de-ordenaci%C3%B3n/shellshort/

public class ShellSort {

        public static void main(String[] args) {
                //int large = 10000; // for the array with 10000 elements
                //int large = 100000; // for the array with 100000 elements
                int large = 1000000; // for the array with 1000000 elements

                int vec[]= MessyArray.generateMessyArray(large);
                //int vec[]={45,17,23,67,21,55,8,18,89,26,58};

                //System.out.println("Vector original");
                //imprimirVector(vec);
                //System.out.println("\n");

                long startTime = System.nanoTime(); // Start time
                vec=ordenacionShell(vec);
                long endTime = System.nanoTime();  //Finish time

                long duration = (endTime - startTime); // Calculate the duration in nanoseconds
                double seconds = duration / 1e9; // Convierte a segundos

                System.out.println("\nTiempo de ejecución (en segundos): " + seconds);

                //imprimirVector(vec);
        }

        public static int[] ordenacionShell(int vec[]){
                int cont=0;
                final int N=vec.length; 
                int k=N/2;
                   while (k>=1){ 
                     for (int i = 0; i < k; i++){
                       //para cada subvector recorremos sus elementos
                       for (int j = k+i; j < N; j+= k)
                       {
                         int v = vec[j];
                         int n = j - k;
                         while (n>=0&& vec[n] >v){
                           vec[n + k] = vec[n];
                           n-=k;
                         }
                         vec[n + k] = v;
                       } 
                     } 
                   //obtenemos un nuevo salto
                   k /= 2;
                  //System.out.print("iteracion: "+(++cont)+": ");imprimirVector(vec);System.out.println();
                   } 
                   return vec;
        }
        
        public static void imprimirVector(int vec[]){
                for(int i=0;i<vec.length;i++){
                        System.out.print(vec[i]+" ");
                }
        }
                    
}
