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
                min=servers.get(i).getWaitingPerioad().get();
            }
        }

        servers.get(index).addTask(task);

        SimulationManager.printWriter.println("Task-ul "+task.toString()+" a fost adaugat la coada "+index);

        return true;
    }
}
