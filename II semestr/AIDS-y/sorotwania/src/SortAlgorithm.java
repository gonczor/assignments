abstract class SortAlgorithm {
    Integer[] dataArray;
    abstract void sort(Integer[] dataArray);

    protected void showSorted(){
        if(dataArray.length < 2)
            System.out.println(this.toString());

        for(Integer i: dataArray){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    protected void showMemoryUsage(){
        System.out.println(this.toString() + " using: " + Runtime.getRuntime().totalMemory());
    }
}

class InsertionSort extends SortAlgorithm {
    @Override
    void sort(Integer[] dataArray){
        this.dataArray = dataArray;
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
            //showMemoryUsage();
        }

        //showSorted();
    }

    @Override
    public String toString() {

        return "insert sort";
    }
}

class MergeSort extends SortAlgorithm {
    Integer[] helperArray;
    int lowIndex, highIndex;
    @Override
    void sort(Integer[] dataArray) {
        this.dataArray = dataArray;
        prepare(dataArray);
        mergeSort(lowIndex, highIndex);

        showSorted();
    }

    private void prepare(Integer[] dataArray){
        lowIndex = 0;
        highIndex = dataArray.length - 1;
        helperArray = new Integer[dataArray.length];
    }

    private void mergeSort(int lowIndex, int highIndex){

        if(lowIndex < highIndex){
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2; //tu byl bug
            mergeSort(lowIndex, middleIndex);
            mergeSort(middleIndex + 1, highIndex);
            merge(lowIndex, middleIndex, highIndex);
        }
    }


    private void merge(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            helperArray[i] = dataArray[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (helperArray[i] < helperArray[j]) {
                dataArray[k] = helperArray[i];
                i++;
            } else {
                dataArray[k] = helperArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            dataArray[k++] = helperArray[i++];
//            k++; tak bedzie inaczej dzialac
//            i++;
        }
        while (j <= higherIndex) {
            dataArray[k++] = helperArray[j++];
        }

    }

    @Override
    public String toString() {

        return "merge sort";
    }
}

class QuickSort extends SortAlgorithm {

    @Override
    void sort(Integer[] dataArray) {
        this.dataArray = dataArray;
        quickSort(0, dataArray.length-1);
        //showSorted();
    }

    private void quickSort(int lowIndex, int highIndex){
        //little optimization while choosing pivot
        int lowLocal = lowIndex, highLocal = highIndex;
        int pivot = getPivot(lowIndex, highIndex);
        while(lowLocal < highLocal){
            while(dataArray[lowLocal] < pivot) {
                lowLocal++;
            }
            while (dataArray[highLocal] > pivot) {
                highLocal--;
            }
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
        //showMemoryUsage();
    }

    private int getPivot(int low, int high){
        int mid = low + (high - low) / 2;
        if ((dataArray[low] <= dataArray[mid] && dataArray[mid] <= dataArray[high]) ||
                (dataArray[low] >= dataArray[mid] && dataArray[mid] >= dataArray[high]))
            return dataArray[mid];
        if((dataArray[mid] <= dataArray[low] && dataArray[low] <= dataArray[high]) ||
                (dataArray[mid] >= dataArray[low] && dataArray[low] >= dataArray[high]))
            return dataArray[low];
        else
            return dataArray[high];
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
    int arraySize;
    //Integer[] dataArray;
    @Override
    void sort(Integer[] dataArray) {
        this.dataArray = dataArray;
        arraySize = dataArray.length - 1;
        makeHeap();
        for(int i = arraySize; i > 0; i--){
            swap(0, i);
            arraySize--;// = arraySize -1;
            repairHeap(0);
            //showMemoryUsage();
        }
        showSorted();
    }

    private void makeHeap(){
        for(int i = arraySize/2; i>=0;i--){
            repairHeap(i);
        }
    }

    private void repairHeap(int index){
        int left = 2 * index;
        int right = 2 * index + 1;
        int max = index;
        if(left <= arraySize && dataArray[left] >= dataArray[max])
            max = left;
        if(right <= arraySize && dataArray[right] > dataArray[max])
            max = right;

        if(max != index){
            swap(index, max);
            repairHeap(max);
        }
    }

    private void swap(int i, int j){
        int temp = dataArray[i];
        dataArray[i] = dataArray[j];
        dataArray[j] = temp;
    }

    @Override
    public String toString() {

        return "heap sort";
    }
}