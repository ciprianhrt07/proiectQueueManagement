import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteStrategyLengthTest {

    @Test
    void addTask() {

        ArrayList<Server> servers = new ArrayList<Server>();

        Task t1 = new Task(1,2,4);
        Task t2 = new Task(2,2,3);
        Task t3 = new Task(3,3,9);
        Task t4 = new Task(4,4,3);
        Task t5 = new Task(5,5,8);
        Task t6 = new Task(6,1,7);

        ConcreteStrategyLength strategyLength = new ConcreteStrategyLength();

        servers.add(new Server());
        servers.add(new Server());

        strategyLength.addTask(servers,t1);
        strategyLength.addTask(servers,t2);
        strategyLength.addTask(servers,t3);
        strategyLength.addTask(servers,t4);
        strategyLength.addTask(servers,t5);
        strategyLength.addTask(servers,t6);


        assertTrue( servers.get(0).toString().equals("Task{ID=1, arrivalTime=2, serviceTime=4}\n" +
                "Task{ID=3, arrivalTime=3, serviceTime=9}\n" +
                "Task{ID=5, arrivalTime=5, serviceTime=8}\n")&&
                servers.get(1).toString().equals("Task{ID=2, arrivalTime=2, serviceTime=3}\n" +
                        "Task{ID=4, arrivalTime=4, serviceTime=3}\n" +
                        "Task{ID=6, arrivalTime=1, serviceTime=7}\n")
                 ) ;


    }
}

