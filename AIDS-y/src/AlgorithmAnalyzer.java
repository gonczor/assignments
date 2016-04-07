import java.io.FileOutputStream;
import java.io.IOException;

public class AlgorithmAnalyzer {
    private long startTime;
    private long elapsedTime;
    FileOutputStream file;

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

    public void analyze (SortAlgorithm sortAlgorithm)
            throws CloneNotSupportedException, IOException{
        int numberOfAnalyzesPerDataProbe = 3;
        for(int checkRun = 0; checkRun < numberOfAnalyzesPerDataProbe; checkRun++) {
            prepare(sortAlgorithm, checkRun);
            analyzeAscending(sortAlgorithm);
            analyzeDescending(sortAlgorithm);
            analyzeVShaped(sortAlgorithm);
            analyzeRandom(sortAlgorithm);
        }
    }

    private void prepare(SortAlgorithm sortAlgorithm, int run)
            throws CloneNotSupportedException, IOException{
        prepareFile(sortAlgorithm, run);
        prepareData();
    }

    private void prepareFile(SortAlgorithm sortAlgorithm, int run)
            throws IOException{
        file = new FileOutputStream(sortAlgorithm.toString() + " run: " + String.valueOf(run) + ".data");
        String messageToSaveString = sortAlgorithm.toString() + "\n";
        byte[] messageToSaveBytes = messageToSaveString.getBytes();
        file.write(messageToSaveBytes);

    }

    private void prepareData() throws CloneNotSupportedException{
        ascendingDataDraftCopy = (AscendingData) ascendingDataCopy.clone();
        descendingDataDraftCopy = (DescendingData) descendingDataCopy.clone();
        randomDataDraftCopy = (RandomData) randomDataCopy.clone();
        vShapedDataDraftCopy = (VShapedData) vShapedDataCopy.clone();

    }

    private void analyzeAscending(SortAlgorithm sortAlgorithm)
            throws IOException{
            for(int probeSize = 1; probeSize < ascendingDataDraftCopy.getProbeArrayIndex(); probeSize++){
                getStartTimeStamp();
                sortAlgorithm.sort(ascendingDataDraftCopy.probes[probeSize]);
                getStopTimeStamp();
                saveDataToFile(probeSize, "ascending");
            }
    }

    private void analyzeDescending(SortAlgorithm sortAlgorithm)
            throws IOException{
        for(int probeSize = 1; probeSize < descendingDataDraftCopy.getProbeArrayIndex(); probeSize++){
            getStartTimeStamp();
            sortAlgorithm.sort(descendingDataDraftCopy.probes[probeSize]);
            getStopTimeStamp();
            saveDataToFile(probeSize,"descending" );
        }
    }

    private void analyzeVShaped(SortAlgorithm sortAlgorithm)
            throws IOException{
        for(int probeSize = 1; probeSize < vShapedDataDraftCopy.getProbeArrayIndex(); probeSize++){
            getStartTimeStamp();
            sortAlgorithm.sort(vShapedDataCopy.probes[probeSize]);
            getStopTimeStamp();
            saveDataToFile(probeSize, "v-shaped");
        }
    }

    private void analyzeRandom(SortAlgorithm sortAlgorithm)
            throws IOException{
        for(int probeSize = 1; probeSize < randomDataDraftCopy.getProbeArrayIndex(); probeSize++){
            getStartTimeStamp();
            sortAlgorithm.sort(randomDataDraftCopy.probes[probeSize]);
            getStopTimeStamp();
            saveDataToFile(probeSize, "random");
        }
    }


    private void getStartTimeStamp(){

        startTime = System.nanoTime();
    }

    private void getStopTimeStamp(){

        elapsedTime = System.nanoTime() - startTime;
    }

    private void saveDataToFile(int probeSize, String dataType)
            throws IOException{
        String messageToSaveString = "Data type: " + dataType +
                "\tsize: " + String.valueOf(probeSize) + " mln" +
                "\ttime:" + String.valueOf(elapsedTime) + "\n";

        byte[] messageToSaveBytes = messageToSaveString.getBytes();
        file.write(messageToSaveBytes);
    }
}
