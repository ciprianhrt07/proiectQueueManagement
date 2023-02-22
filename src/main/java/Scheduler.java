import java.util.ArrayList;

public class Scheduler {

    private final ArrayList<Server> servers;
    private final int maxNoServers;
    private final int maxTasksPerServer;
    private Strategy strategy;
    //private ArrayList<Thread> threads;


    public Scheduler(int maxNoServers,Strategy strategy)
    {
        //threads = new ArrayList<Thread>();
        //this.threads=new ArrayList<Thread>();
        this.servers=new ArrayList<Server>();
        this.maxNoServers=maxNoServers;
        this.maxTasksPerServer=0;
        this.strategy=strategy;

        for(int i=0;i<maxNoServers;i++)
        {
            servers.add(new Server());
            // Thread t =new Thread(servers.get(i));
            //  threads.add(t);
        }

    }

    public synchronized void changeStrategy(SelectionPolicy policy){

        if(policy == SelectionPolicy.SHORTEST_QUEUE)
        {
            strategy = new ConcreteStrategyLength();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME)
        {
            strategy = new ConcreteStrategyTime();
        }

    }

    //public ArrayList<Thread> getThreads() {
    //  return threads;
    //}

    public synchronized boolean dispatchTask(Task t)
    {
        return strategy.addTask(servers,t);
    }

    public synchronized ArrayList<Server> getServers()
    {
        return servers;
    }

    public synchronized String toString()
    {
        String str="";

        for(int i=0;i<servers.size();i++)
        {
            if(servers.get(i).toString().length()==0)
            {
                str = str + "Coada "+i+" este vida"+ "\n ";
            }else
                str = str + "Coada "+i+" are task-urile : "+servers.get(i).toString();
        }


        return str;
    }
}
