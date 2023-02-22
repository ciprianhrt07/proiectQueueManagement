import com.sun.security.jgss.GSSUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteStrategyTimeTest {

    @Test
    void addTask() {


        ArrayList<Server> servers = new ArrayList<Server>();

        Task t1 = new Task(1,2,4);
        Task t2 = new Task(2,2,3);
        Task t3 = new Task(3,3,9);
        Task t4 = new Task(4,4,3);

        ConcreteStrategyTime strategyTime = new ConcreteStrategyTime();

        servers.add(new Server());
        servers.add(new Server());
        servers.add(new Server());

        strategyTime.addTask(servers,t1);
        strategyTime.addTask(servers,t2);
        strategyTime.addTask(servers,t3);
        strategyTime.addTask(servers,t4);

        //System.out.println(servers.toString());

      /*  for(int i=0;i<servers.size();i++)
        {

            System.out.println("Queue "+i+" : ");

            if(servers.get(i).getTasks().size()==0)
            {
                System.out.println("is empty");
            }else
                System.out.println(servers.get(i).toString());
        }

       */

       // assertTrue(model.getRezultat().toString().equals("+22*X^32+4*X^11+14*X^5+13*X^2"));

        assertTrue( servers.get(0).toString().equals("Task{ID=1, arrivalTime=2, serviceTime=4}\n" +"Task{ID=4, arrivalTime=4, serviceTime=3}\n")&&
                            servers.get(1).toString().equals("Task{ID=2, arrivalTime=2, serviceTime=3}\n")&&
                            servers.get(2).toString().equals("Task{ID=3, arrivalTime=3, serviceTime=9}\n")
                  ) ;


    }
}


/*

import java.util.ArrayList;
        import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteStrategyTime implements Strategy{

    @Override
    public synchronized boolean addTask(ArrayList<Server> servers, Task task) {
        int min=10000;
        int index=0;

        for(int i=0;i<servers.size();i++)
        {
            int aux = servers.get(i).getWaitingPerioad().get();
            if(aux<min)
            {
                index=i;
                min=servers.get(i).getTasks().size();
            }
        }

        servers.get(index).addTask(task);
        return true;
    }
}
*/
