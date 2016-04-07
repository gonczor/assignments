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
    @Override
    void sort(Integer[] dataArray) {
        //System.out.println("Quick");
    }

    @Override
    public String toString() {

        return "quick sort";
    }
}

class HeapSort extends SortAlgorithm {
    @Override
    void sort(Integer[] dataArray) {
        //System.out.println("Heap");
    }

    @Override
    public String toString() {

        return "heap sort";
    }
}