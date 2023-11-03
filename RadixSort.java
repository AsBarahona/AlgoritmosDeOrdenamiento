public class RadixSort{
 
    public static void radixSort(int[] arr){
        if(arr.length == 0)
            return;
        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i,j,k,l,f = 0;
        for(k=0;k<4;k++){
            for(i=0;i<(np.length-1);i++)
                np[i][1] = i+1;
            np[i][1] = -1;
            for(i=0;i<q.length;i++)
                q[i] = -1;
            for(f=i=0;i<arr.length;i++){
                j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
                if(q[j] == -1)
                    l = q[j] = f;
                else{
                    l = q[j];
                    while(np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = arr[i];
                np[l][1] = -1;
            }
            for(l=q[i=j=0];i<0x100;i++)
                for(l=q[i];l!=-1;l=np[l][1])
                        arr[j++] = np[l][0];
        }
    }
 
    public static void main(String[] args){
        //int large = 10000; // for the array with 10000 elements
        //int large = 100000; // for the array with 100000 elements
        int large = 1000000; // for the array with 1000000 elements

        int arr[]= MessyArray.generateMessyArray(large);

        //int[] arr = new int[15];
        /*System.out.print("original: ");
        for(i=0;i<arr.length;i++){
            //arr[i] = (int)(Math.random() * 1024);
            System.out.print(arr[i] + " ");
        }*/

        long startTime = System.nanoTime(); // Start time
        radixSort(arr);// Calls the method that does the radix sort 
        long endTime = System.nanoTime();  //Finish time
        long duration = (endTime - startTime); // Calculate the duration in nanoseconds
        double seconds = duration / 1e9; // Convierte a segundos

        System.out.println("\nTiempo de ejecución (en segundos): " + seconds);

        /*System.out.print("\nsorted: ");
        for(i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");*/
    }
}