abstract class SortAlgorithm {
    abstract void sort(Integer[] dataArray);

}

class InsertionSort extends SortAlgorithm {
    @Override
    void sort(Integer[] dataArray){

        if(dataArray.length < 2)
            return;
        int x, j;
        for(int i = 1; i < dataArray.length; i++){
            x = dataArray[i];
            j = i;
            while (x < dataArray[j-1]){
                dataArray[j] = dataArray[j-1];
                j -= 1;
                if(j == 0)
                    break;
            }
            dataArray[j] = x;
        }
    }

    @Override
    public String toString() {

        return "insert sort";
    }
}

class MergeSort extends SortAlgorithm {
    //Algorithm based on: http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
    Integer[] helperArray;
    Integer[] dataArray;
    int lowIndex, highIndex, middleIndex;
    @Override
    void sort(Integer[] dataArray) {
        this.dataArray = dataArray;
        prepare(dataArray);
        mergeSort(lowIndex, highIndex);
    }

    private void prepare(Integer[] dataArray){
        lowIndex = 0;
        highIndex = dataArray.length - 1;
        helperArray = new Integer[dataArray.length];
    }

    private void mergeSort(int lowIndex, int highIndex){
        if(lowIndex < highIndex){
            middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            mergeSort(lowIndex, middleIndex);
            mergeSort(middleIndex + 1, highIndex);
            merge(lowIndex, highIndex, middleIndex);
        }
    }

    private void merge(int lowIndex, int highIndex, int middleIndex){
        for(int i = lowIndex; i <= highIndex; i++)
            helperArray[i] = dataArray[i];

        int i = lowIndex;
        int j = middleIndex + 1;
        int k = lowIndex;

        while (i <= middleIndex && j <= highIndex){
            if(helperArray[i] <= helperArray[j]){
                dataArray[k] = helperArray[i];
                i++;
            } else {
                dataArray[k] = helperArray[j];
                j++;
            }
            k++;
        }
        while(i <= middleIndex)
            dataArray[k++] = helperArray[i++];
    }

    @Override
    public String toString() {

        return "merge sort";
    }
}

class QuickSort extends SortAlgorithm {

    Integer[] dataArray;
    @Override
    void sort(Integer[] dataArray) {
        this.dataArray = dataArray;
        quickSort(0, dataArray.length-1);
    }

    private void quickSort(int lowIndex, int highIndex){
        //little optimization while choosing pivot
        int lowLocal = lowIndex, highLocal = highIndex;
        int pivot = dataArray[highIndex];
        while(lowLocal < highLocal){
            while(dataArray[lowLocal] < pivot)
                lowLocal++;
            while (dataArray[highIndex] > pivot)
                highLocal++;
            if(lowLocal <= highLocal){
                swapElements(lowLocal, highLocal);
                lowLocal++;
                highLocal--;
            }
        }

        if(lowIndex < highLocal)
            quickSort(lowIndex, highLocal);
        if(lowLocal < highIndex)
            quickSort(lowLocal, highIndex);
    }

    private void swapElements(int i, int j){
        int temp = dataArray[i];
        dataArray[i] = dataArray[j];
        dataArray[j] = temp;
    }

    @Override
    public String toString() {

        return "quick sort";
    }
}

class HeapSort extends SortAlgorithm {
    Integer[] dataArray;
    int largest, arraySize;
    @Override
    void sort(Integer[] dataArray) {
        this.dataArray = dataArray;
        arraySize = dataArray.length - 1;
        makeHeap();
        for(int i = arraySize; i > 0; i--){
            swap(0, i);
            arraySize = arraySize -1;
            maxHeap(0);
        }
        show();
    }

    private void makeHeap(){
        for(int i = arraySize/2; i>=0;i--){
            maxHeap(i);
        }
    }

    private void maxHeap(int index){
        int left = 2 * index;
        int right = 2 * index + 1;
        int max = index;
        if(left <= arraySize && dataArray[left] >= dataArray[index])
            max = left;
        if(right <= arraySize && dataArray[right] > dataArray[max])
            max = right;

        if(max != index){
            swap(index, max);
            maxHeap(max);
        }
//        if(left <= arraySize && dataArray[left] > dataArray[index]){
//            largest = left;
//        } else {
//            largest = index;
//        }
//
//        if(right <= arraySize && dataArray[right] > dataArray[largest]){
//            largest = right;
//        }
//
//        if(largest != index){
//            swap(index, largest);
//            maxHeap(largest);
//        }
    }

    private void swap(int i, int j){
        int temp = dataArray[i];
        dataArray[i] = dataArray[j];
        dataArray[j] = temp;
    }

    private void show(){
        for (int i: dataArray) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    @Override
    public String toString() {

        return "heap sort";
    }
}