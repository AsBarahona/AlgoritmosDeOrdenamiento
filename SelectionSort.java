// CÓDIGO TOMADO DE:
//https://tutospoo.jimdofree.com/tutoriales-java/m%C3%A9todos-de-ordenaci%C3%B3n/selecci%C3%B3n/

public class SelectionSort {

        public static void main(String[] args) {

                //int large = 10000; // for the array with 10000 elements
                //int large = 100000; // for the array with 100000 elements
                int large = 1000000; // for the array with 1000000 elements

                int vec[]= MessyArray.generateMessyArray(large);

                //int vec[]={45,17,23,67,21};
                //System.out.println("Vector original");
                //imprimirVector(vec);
               // System.out.println("\n");
               long startTime = System.nanoTime(); // Start time
                vec=ordenacionSeleccion(vec); //Calls the method that does the selection sort
                long endTime = System.nanoTime();  //Finish time

                long duration = (endTime - startTime); // Calculate the duration in nanoseconds
                double seconds = duration / 1e9; // Convierte a segundos

                System.out.println("\nTiempo de ejecución (en segundos): " + seconds);
                //imprimirVector(vec);
        }

        public static int[] ordenacionSeleccion(int vec[]){
                final int N=vec.length;
                for(int i=0;i<N;i++){
                        int posMenor=i;
                        for(int j=i+1;j<N;j++){
                                if(vec[j]<vec[posMenor])
                                        posMenor=j;
                        }
                        if(posMenor!=i){
                                int temp=vec[i];
                                vec[i]=vec[posMenor];
                                vec[posMenor]=temp;
                        }
                        //System.out.print("iteracion: "+i+": ");imprimirVector(vec);System.out.println();
                }
                
                return vec;
        }
        
        public static void imprimirVector(int vec[]){
                for(int i=0;i<vec.length;i++){
                        System.out.print(vec[i]+" ");
                }
        }
}
                    
