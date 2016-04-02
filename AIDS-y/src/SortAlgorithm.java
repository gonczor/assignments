abstract class SortAlgorithm {
    abstract void sort(Integer[] dataArray);
}

class InsertSort extends SortAlgorithm {
    @Override
    void sort(Integer[] dataArray){
        System.out.println("Len: " + dataArray.length);
        System.out.println(dataArray[0]);
        //System.out.println("Insert");
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