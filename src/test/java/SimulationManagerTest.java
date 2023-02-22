import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationManagerTest {

    @Test
    void run() throws IOException {

        List<Task> generatedTasks=new ArrayList<Task>();
        generatedTasks.add(new Task(1,2,2));
        generatedTasks.add(new Task(2,3,3));
        generatedTasks.add(new Task(3,4,3));
        generatedTasks.add(new Task(4,10,2));

        SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

        ConcreteStrategyTime concreteStrategyTime = new ConcreteStrategyTime();

        SimulationManager simulationManager = new SimulationManager(15,2,10,2,10,4,2);

        simulationManager.scheduler=new Scheduler(2,concreteStrategyTime);

        Thread t = new Thread(simulationManager);

        t.setName("Main thread");

        t.start();

    }


}
/*
         generatedTasks.add(new Task(1,2,2));
         generatedTasks.add(new Task(2,3,3));
         generatedTasks.add(new Task(3,4,3));
         generatedTasks.add(new Task(4,10,2));


 */