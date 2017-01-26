import java.util.Random;

abstract class Data implements Cloneable{
    Integer[][] probes;
    protected int numberOfProbesInArray;
    protected int probeArrayIndex;
    protected int multiplier;
    Random random;
    Data(){
        multiplier = 200000;
        probeArrayIndex = 10;
        random = new Random();
        probes = new Integer[probeArrayIndex][];
    }

    public int getMultiplier(){
        return multiplier;
    }

    public int getProbeArrayIndex(){
        return probeArrayIndex;
    }

    protected void showRandomized(){
//        System.out.println(this.toString());
//        for(Integer[] i: probes){
//            for(Integer j: i){
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class RandomData extends Data{
    RandomData(){
        super();
        for(int i = 0; i < probeArrayIndex; i++){
            numberOfProbesInArray= i * multiplier;
            probes[i] = new Integer[numberOfProbesInArray];
            for(int j = 0; j < numberOfProbesInArray; j++){
                probes[i][j] = random.nextInt(probeArrayIndex * 2);
            }
        }

        showRandomized();
    }

    @Override
    public String toString() {

        return "random data";
    }
}

class AscendingData extends Data{
    AscendingData(){
        super();
        for(int i = 0; i < probeArrayIndex; i++){
            numberOfProbesInArray = i * multiplier;
            probes[i] = new Integer[numberOfProbesInArray];
            for(int j = 0; j < numberOfProbesInArray; j++){
                probes[i][j] = j + random.nextInt(5);
            }
        }
        showRandomized();
    }

    @Override
    public String toString() {

        return "ascending data";
    }
}

class DescendingData extends Data{
    DescendingData() {
        super();
        for (int i = 0; i < probeArrayIndex; i++) {
            numberOfProbesInArray = i * multiplier;
            probes[i] = new Integer[numberOfProbesInArray];
            for (int j = 0; j < numberOfProbesInArray; j++) {
                probes[i][j] = numberOfProbesInArray - j + random.nextInt(5);
            }
        }
        showRandomized();
    }

    @Override
    public String toString() {

        return "descending data";
    }
}

class VShapedData extends Data{
    VShapedData() {
        super();
        for (int i = 0; i < probeArrayIndex; i++) {
            numberOfProbesInArray = i * multiplier;
            probes[i] = new Integer[numberOfProbesInArray];
            for (int j = 0; j < numberOfProbesInArray / 2; j++) {
                probes[i][j] = numberOfProbesInArray - j + random.nextInt(5);
            }
            for (int j = numberOfProbesInArray / 2; j < numberOfProbesInArray; j++) {
                probes[i][j] = j + random.nextInt(5);
            }
        }
        showRandomized();
    }

    @Override
    public String toString() {

        return "v-shaped data";
    }
}