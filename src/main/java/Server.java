import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPerioad;


    public Server() {
        this.tasks = new LinkedBlockingQueue<Task>();
        this.waitingPerioad = new AtomicInteger(0);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        this.waitingPerioad.addAndGet(task.getServiceTime());
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (true) {

            afisare();

            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public  void afisare() {

       synchronized (this) {
           String numeThread = Thread.currentThread().getName();

        System.out.println("Thread: " + numeThread + "is going to do:" + tasks.peek()+" and waiting perioad is "+this.waitingPerioad);

        SimulationManager.printWriter.println("Thread: " + numeThread + "is going to do:" + tasks.peek()+" and waiting perioad is "+this.waitingPerioad);

        String string = numeThread + " va servi "+ this.tasks.size() + " si timpul de asteptare este: "+this.waitingPerioad+"\n";

        String anterior = SimulationManager.getFrame().getTextAfisare().getText();

        SimulationManager.getFrame().setTextAfisare(anterior+"\n"+string);
       }
        Task task = tasks.peek();

        if (task != null) {
            task.setServiceTime(task.getServiceTime() - 1);
            this.waitingPerioad.decrementAndGet();
            if (task.getServiceTime() == 0)
                tasks.remove(task);

        }


        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public List<Task> getTasks() {

        // return (Task[]) this.tasks.toArray();
        // taskuri = (Task[]) this.tasks.toArray();

        return tasks.stream().toList();
    }

    public AtomicInteger getWaitingPerioad() {
        return waitingPerioad;
    }

    @Override
    public String toString() {

        List<Task> rezultatCurent = getTasks();
        String str = "";
        for (int i = 0; i < tasks.size(); i++) {
            str = str + rezultatCurent.get(i).toString() + "\n";

        }

        return str;

    }
}
