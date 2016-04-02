import java.util.Random;

abstract class Data implements Cloneable{
    Integer[][] probes;
    Random random;
    Data(){
        random = new Random();
        probes = new Integer[10][];
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class RandomData extends Data{
    RandomData(){
        super();
        int numberOfElements;
        for(int i = 0; i < 10; i++){
            numberOfElements = i * 10;
            probes[i] = new Integer[numberOfElements];
            for(int j = 0; j < numberOfElements; j++){
                probes[i][j] = random.nextInt(Integer.MAX_VALUE);
            }
        }
    }

    @Override
    public String toString() {
        return "random data";
    }
}

class AscendingData extends Data{
    AscendingData(){
        super();
        int numberOfElements;
        for(int i = 0; i < 10; i++){
            numberOfElements = i;
            probes[i] = new Integer[numberOfElements];
            for(int j = 0; j < numberOfElements; j++){
                probes[i][j] = j + random.nextInt(5);
            }
        }
        for(int i = 0; i < 10; i++){
            numberOfElements = i;
            for(int j = 0; j < numberOfElements; j++){
                System.out.print(probes[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "ascending data";
    }
}

class DescendingData extends Data{
    DescendingData() {
        super();
        int numberOfElements;
        for (int i = 0; i < 10; i++) {
            numberOfElements = i;
            probes[i] = new Integer[numberOfElements];
            for (int j = 0; j < numberOfElements; j++) {
                probes[i][j] = numberOfElements - j + random.nextInt(5);
            }
        }
    }

    @Override
    public String toString() {
        return "descending data";
    }
}

class VShapedData extends Data{
    VShapedData() {
        super();
        int numberOfElements;
        for (int i = 0; i < 10; i++) {
            numberOfElements = i;
            probes[i] = new Integer[numberOfElements];
            for (int j = 0; j < numberOfElements / 2; j++) {
                probes[i][j] = numberOfElements - j + random.nextInt(5);
            }
            for (int j = numberOfElements / 2; j < numberOfElements; j++) {
                probes[i][j] = j + random.nextInt(5);
            }
        }
    }

    @Override
    public String toString() {
        return "v-shaped data";
    }
}