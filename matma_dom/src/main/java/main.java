import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class main {
    public static void main(String[] args) {

        Random random = new Random();
        int zakres = 1000;
        int wielkosc_tablicy=10000;

        int hugeTable[] = new int[wielkosc_tablicy];

        for(int i=0;i<wielkosc_tablicy;i++){
            hugeTable[i]=random.nextInt(zakres);
        }

        int[] hugeTable2 = hugeTable.clone();
        int[] hugeTable3 = hugeTable.clone();

        LocalDateTime start;
        LocalDateTime end;

/*        //bombelkowe nieposortowana
        start = LocalDateTime.now();
        bombel_sort(hugeTable);
        end = LocalDateTime.now();
        show_time(start, end);

        //bombelkowe posortowana
        start = LocalDateTime.now();
        bombel_sort(hugeTable);
        end = LocalDateTime.now();
        show_time(start, end);

        hugeTable = reverse_array(hugeTable, wielkosc_tablicy);

        //bombelkowe odwrocona
        start = LocalDateTime.now();
        bombel_sort(hugeTable);
        end = LocalDateTime.now();
        show_time(start, end);*/
////////////////////////////////////////////////

/*        //kopiec nieposortowana
        start = LocalDateTime.now();
        kopiec_sort(hugeTable2);
        end = LocalDateTime.now();
        show_time(start, end);

        //kopiec posortowany
        start = LocalDateTime.now();
        kopiec_sort(hugeTable2);
        end = LocalDateTime.now();
        show_time(start, end);

        hugeTable2 = reverse_array(hugeTable2, wielkosc_tablicy);

        //kopiec odwrocony
        start = LocalDateTime.now();
        kopiec_sort(hugeTable2);
        end = LocalDateTime.now();
        show_time(start, end);*/

        //////////////////////////////////

        //qs nieposrtowany
        start = LocalDateTime.now();
        quickSort(hugeTable3,0,wielkosc_tablicy-1);
        end = LocalDateTime.now();
        show_time(start, end);

        //qs posortowany
        start = LocalDateTime.now();
        quickSort(hugeTable3,0,wielkosc_tablicy-1);
        end = LocalDateTime.now();
        show_time(start, end);

        hugeTable3 = reverse_array(hugeTable3, wielkosc_tablicy);

        //qs odwrocona
        start = LocalDateTime.now();
        quickSort(hugeTable3,0,wielkosc_tablicy-1);
        end = LocalDateTime.now();
        show_time(start, end);
    }


    private static void show_time(LocalDateTime start, LocalDateTime end){
        int time = (int) ChronoUnit.MILLIS.between(start, end);
        String stringTime = Integer.toString(time);
        System.out.println(time);
    }
    private static int[] reverse_array(int[] arrayToReverse, int tabSize){
        int reversedTable[] = new int[tabSize];

        int counter=0;
        for(int i=tabSize-1; i>=0; i--){
            reversedTable[counter]=arrayToReverse[i];
            counter=counter+1;
        }
        return reversedTable;
    }
    private static void bombel_sort(int[] table){

        int n = table.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (table[j] > table[j + 1]) {
                    int temp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = temp;
                }
        System.out.println("bombel_done");
    }

    public static int[] kopiec_sort(int[]tableToSort){
        int n = tableToSort.length;

        //pierwsze zrobienie max kopca od ostatniego rodzica n/2-1
        for(int i = n / 2 - 1; i >= 0; i--){
            utworzMaxKopiec(tableToSort, n, i);
        }
        //wlasciwe juz sortowanie
        for(int i = n - 1; i > 0; i--){
            //zamiana pol pierwszego z ostatnim
            int temp = tableToSort[0];
            tableToSort[0]=tableToSort[i];
            tableToSort[i]=temp;

            n--;
            utworzMaxKopiec(tableToSort, n, 0);
        }
        System.out.println("kopiec done");
        return tableToSort;
    }

    private static void utworzMaxKopiec(int[]table, int heapSize, int parentIndex){
        int maxIndex = parentIndex;
        int leftChild = parentIndex * 2 + 1;
        int rightChild = parentIndex * 2 + 2;

        if(leftChild < heapSize && table[leftChild] > table[maxIndex]){
            maxIndex = leftChild;
        }
        if(rightChild < heapSize && table[rightChild] > table[maxIndex]){
            maxIndex = rightChild;
        }
        if(maxIndex != parentIndex){
            //zamana dziecka z rodzicem
            int temp = table[maxIndex];
            table[maxIndex]=table[parentIndex];
            table[parentIndex]=temp;

            utworzMaxKopiec(table, heapSize, maxIndex);
        }
    }

    private static void quickSort(int[] A,int p,int r){
        if(p<r){
            int q = partition(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);

        }
    }

    public static int partition(int[] A, int p, int r){

        int pivot=A[r];
        int smaller=p;
        for(int j=p;j<r;j++){
            if(A[j]<=pivot){
                int temp = A[smaller];
                A[smaller]=A[j];
                A[j]=temp;

                smaller++;
            }
        }
        int temp = A[smaller];
        A[smaller]=A[r];
        A[r]=temp;
        return smaller;
    }
}
