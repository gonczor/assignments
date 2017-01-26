package settings;

public class Settings {
    public static String readInstancesFileName = "read.txt";
    public static String writeResultToFileName = "writeResult.txt";
    public static int numberOfTasks = 50;
    public static int maxExecTime = 200;            // tasks exec time
    public static int maxMaintenanceTime = 300;
    // Number of iterations after which phermone matrix will be reset.
    public static final int maximumIterationsForImprovment = 5000;
    // jaką część z wylosowanego prawdopodobieństwa musi minimum zawierać zadanie do przypisania
    public static double alphaProbability = 1.0;
    // How much current worse from best solution to use it to update phermone matrix
    public static double gammaParameter = 1.1;
    // Phermone matrix improvement factor used together with iteration number
    public static double extraPheromonePerIteration = 0.000001;
    // minimal value in phermone matrix below which phermone level won't be lowered
    public static double minPheromoneInPheromoneMatrix = 0.0001;
    /**
     * Amount of phermone that is left after each iteration of algorithm
     */
    public static final double phermoneVaporizationRate = 0.5;
    /**
     * The number of ants that run each time.
     * This equals to th number of latest created solutions taken into consideration when counting algorithm
     * improvement rate.
     */
    public static final int numberOfAntsPerIteration = 10;
    public static final int timerRunningTime = 60;
}
