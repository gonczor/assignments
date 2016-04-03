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
    @Override
    void sort(Integer[] dataArray) {
        //System.out.println("Merge");
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