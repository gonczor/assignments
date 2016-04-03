public class Sorting {

    AlgorithmAnalyzer analyzer;
    HeapSort heapSort;
    InsertionSort insertionSort;
    MergeSort mergeSort;
    QuickSort quickSort;
    RandomData randomData;
    AscendingData ascendingData;
    DescendingData descendingData;
    VShapedData vShapedData;

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        sorting.initialize();
        try{
            sorting.analyzer.analyze(sorting.heapSort);
            sorting.analyzer.analyze(sorting.insertionSort);
            sorting.analyzer.analyze(sorting.mergeSort);
            sorting.analyzer.analyze(sorting.quickSort);
        }
        catch (CloneNotSupportedException e){
            e.getMessage();
        }

    }

    void initialize(){
        heapSort = new HeapSort();
        insertionSort = new InsertionSort();
        mergeSort = new MergeSort();
        quickSort = new QuickSort();
        randomData = new RandomData();
        ascendingData = new AscendingData();
        descendingData = new DescendingData();
        vShapedData = new VShapedData();
        analyzer = new AlgorithmAnalyzer(ascendingData, descendingData, randomData, vShapedData);
    }
}
