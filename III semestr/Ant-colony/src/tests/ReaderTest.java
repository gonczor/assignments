package tests;

import instance.Reader;
import machine.Maintenance;
import machine.Task;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReaderTest {

    @org.junit.Test
    public void readTasks() throws Exception {
        ArrayList<Task> tasks = Reader.readTasks("src/tests/testdata/test_read.txt");
        assertEquals(tasks.size(), 1);
        assertEquals(tasks.get(0).getOperation1().getDuration(), 67);
        assertEquals(tasks.get(0).getOperation2().getDuration(), 62);
        assertEquals(tasks.get(0).getOperation1().getMachineNumber(), 1);
        assertEquals(tasks.get(0).getOperation2().getMachineNumber(), 2);
    }

    @org.junit.Test
    public void readMaintences() throws Exception {
        ArrayList<Maintenance> maintenances= Reader.readMaintences("src/tests/testdata/test_read.txt");
        assertEquals(maintenances.size(), 1);
        assertEquals(maintenances.get(0).getId(), 0);
        assertEquals(maintenances.get(0).getMachineNumber(), 1);
        assertEquals(maintenances.get(0).getDuration(), 145);
        assertEquals(maintenances.get(0).getStartTime(), 1112);
    }

}