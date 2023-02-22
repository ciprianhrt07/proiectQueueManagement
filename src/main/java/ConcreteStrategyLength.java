import java.util.ArrayList;

public class ConcreteStrategyLength implements Strategy{
    @Override
    public synchronized boolean addTask(ArrayList<Server> servers, Task task) {

        int min=10000;
        int index=0;

        for(int i=0;i<servers.size();i++)
        {
            if(servers.get(i).getTasks().size()<min)
            {
                index=i;
                min=servers.get(i).getTasks().size();
            }
        }


            servers.get(index).addTask(task);
            return true;
    }
}
