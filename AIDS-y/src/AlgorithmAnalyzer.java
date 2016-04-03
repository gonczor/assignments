public class AlgorithmAnalyzer {
    long startTime;
    long elapsedTime;

    //In order to be able to use same data multiple times a copy to remember it is created.
    //Test are conducted on *DraftCopy cloned each time in prepare() method.
    AscendingData ascendingDataCopy, ascendingDataDraftCopy;
    DescendingData descendingDataCopy, descendingDataDraftCopy;
    RandomData randomDataCopy, randomDataDraftCopy;
    VShapedData vShapedDataCopy, vShapedDataDraftCopy;

    //I prefer to create new instances of data classes in Analyzer in order to
    //make prepare() method easier to comprehend. I think it would be misleading to
    //give it all the data types. It should only clone them each time it is called.
    AlgorithmAnalyzer(AscendingData ascendingData,
                      DescendingData descendingData,
                      RandomData randomData,
                      VShapedData vShapedData){
        this.ascendingDataCopy = ascendingData;
        this.descendingDataCopy = descendingData;
        this.randomDataCopy = randomData;
        this.vShapedDataCopy = vShapedData;

    }

    public void analyze (SortAlgorithm sortAlgorithm) throws CloneNotSupportedException{
        this.prepareData();
        for(int i = 1; i < 10; i++){
            this.getStartTimeStamp();
            sortAlgorithm.sort(ascendingDataCopy.probes[i]);
            this.getStopTimeStamp();
            this.saveDataToFile();
        }
    }

    private void prepareData() throws CloneNotSupportedException{
        ascendingDataDraftCopy = (AscendingData) ascendingDataCopy.clone();
        descendingDataDraftCopy = (DescendingData) descendingDataCopy.clone();
        randomDataDraftCopy = (RandomData) randomDataCopy.clone();
        vShapedDataDraftCopy = (VShapedData) vShapedDataCopy.clone();

    }

    private void getStartTimeStamp(){

        startTime = System.nanoTime();
    }

    private void getStopTimeStamp(){

        elapsedTime = System.nanoTime() - startTime;
    }

    private void saveDataToFile(){

    }
}
