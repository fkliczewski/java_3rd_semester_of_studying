#include <iostream>
#include <chrono>
using namespace std;
using namespace std::chrono;

void bombel(int table[], int n);
void kopiecSort(int tableToSort[], int n);
void utworzMaxKopiec(int table[], int heapSize, int parentIndex);
void reverse_array(int arrayToReverse[], int tabSize);
void quickSort(int A[],int p,int r);
int partition(int A[], int p, int r);

int main() {
    int zakres = 1000;
    int wielkosc_tablicy=100000;

    int hugeTable[wielkosc_tablicy];
    int hugeTable2[wielkosc_tablicy];
    int hugeTable3[wielkosc_tablicy];


    for(int i=0;i<wielkosc_tablicy;i++){
        hugeTable[i] = (rand() % zakres);
    }

    for (int i=0; i<wielkosc_tablicy; i++) {
        hugeTable2[i] = hugeTable[i];
    }
    for (int i=0; i<wielkosc_tablicy; i++) {
        hugeTable3[i] = hugeTable[i];
    }
    auto start = high_resolution_clock::now();
    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);

    start = high_resolution_clock::now();
    bombel(hugeTable, wielkosc_tablicy);
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;

    start = high_resolution_clock::now();
    bombel(hugeTable, wielkosc_tablicy);
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;

    reverse_array(hugeTable, wielkosc_tablicy);

    start = high_resolution_clock::now();
    bombel(hugeTable, wielkosc_tablicy);
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;

    //kopiec

    start = high_resolution_clock::now();
    kopiecSort(hugeTable2, wielkosc_tablicy);
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;

    start = high_resolution_clock::now();
    kopiecSort(hugeTable2, wielkosc_tablicy);
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;

    reverse_array(hugeTable2, wielkosc_tablicy);

    start = high_resolution_clock::now();
    kopiecSort(hugeTable2, wielkosc_tablicy);
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;

    //quicksort

    start = high_resolution_clock::now();
    quickSort(hugeTable3, 0,wielkosc_tablicy-1);
    std::cout << "qs_done" << std::endl;
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;

    start = high_resolution_clock::now();
    quickSort(hugeTable3, 0,wielkosc_tablicy-1);
    std::cout << "qs_done" << std::endl;
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;

    reverse_array(hugeTable3, wielkosc_tablicy);

    start = high_resolution_clock::now();
    quickSort(hugeTable3, 0,wielkosc_tablicy-1);
    std::cout << "qs_done" << std::endl;
    stop = high_resolution_clock::now();
    duration = duration_cast<microseconds>(stop - start);
    cout << "Czas: " << duration.count() << " microseconds" << endl;


    return 0;
}

void bombel(int table[], int n){
    for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (table[j] > table[j + 1]) {
                int temp = table[j];
                table[j] = table[j + 1];
                table[j + 1] = temp;
            }
    std::cout << "bombel_done" << std::endl;

}

void kopiecSort(int tableToSort[], int n){

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
    std::cout << "kopiec_done" << std::endl;
}
void utworzMaxKopiec(int table[], int heapSize, int parentIndex){
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
void quickSort(int A[],int p,int r){
    if(p<r){
        int q = partition(A,p,r);
        quickSort(A,p,q-1);
        quickSort(A,q+1,r);

    }
}

int partition(int A[], int p, int r){

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

void reverse_array(int arrayToReverse[], int tabSize){
    int reversedTable[tabSize];

    int counter=0;
    for(int i=tabSize-1; i>=0; i--){
        reversedTable[counter]=arrayToReverse[i];
        counter=counter+1;
    }
}

