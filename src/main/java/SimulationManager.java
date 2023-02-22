import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulationManager implements Runnable {

    public final int timeLimit;
    public final int maxProcessTime;
    public final int minProcessTime;
    public final int numberOfServers;
    public final int numberOfClients;
    public final int minServiceTime;
    public final int maxServiceTime;
    public static File file = new File("out.txt");
    public static FileWriter fileWriter;
    public static File fileTest1 = new File("test1.txt");
    public static FileWriter fileTest1FileWriter;
    public static File fileTest2 = new File("test2txt");
    public static FileWriter fileTest2FileWriter ;
    public static File fileTest3 = new File("test3.txt");
    public static FileWriter fileTest3FileWriter ;
    public static int test1 =0;
    public static int test2 =0;
    public static int test3 = 0;


    static {
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static {
        try {
            fileTest1FileWriter = new FileWriter(fileTest1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            fileTest2FileWriter = new FileWriter(fileTest2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            fileTest3FileWriter = new FileWriter(fileTest3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PrintWriter printWriter = new PrintWriter(fileWriter);
    public static PrintWriter printWriter1 = new PrintWriter(fileTest1FileWriter);
    public static PrintWriter printWriter2 = new PrintWriter(fileTest2FileWriter);
    public static PrintWriter printWriter3= new PrintWriter(fileTest3FileWriter);


    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    public Scheduler scheduler;

    private static SimulationFrame frame = new SimulationFrame();

    public static SimulationFrame getFrame() {
        return frame;
    }

    public static void setFrame(SimulationFrame frame) {
        SimulationManager.frame = frame;
    }

    private List<Task> generatedTasks = Collections.synchronizedList(new ArrayList<>());

    private List<Thread> threadList = new ArrayList<>();

    public static int averageWTime;

    public static int averageSTime;

    public static int peakHour;


    public SimulationManager(int timeLimit, int maxProcessTime, int minProcessTime, int maxServiceTime, int minServiceTime, int numberOfClients, int numberOfServers) throws IOException {

        // generatedTasks= (ArrayList<Task>) Collections.synchronizedCollection(new ArrayList<Task>());

        this.timeLimit = timeLimit;
        this.maxServiceTime = maxServiceTime;
        this.maxProcessTime = maxProcessTime;
        this.minServiceTime = minServiceTime;
        this.minProcessTime = minProcessTime;
        this.numberOfServers = numberOfServers;
        this.numberOfClients = numberOfClients;

        averageWTime = 0;
        averageSTime = 0;
        peakHour = 0;

        generatedTasks = Collections.synchronizedList(generatedTasks);

        ConcreteStrategyTime concreteStrategyTime = new ConcreteStrategyTime();

        scheduler = new Scheduler(numberOfServers,concreteStrategyTime);

        generateNRandomTasks();

        for (int i = 0; i < scheduler.getServers().size(); i++) {
            threadList.add(new Thread(scheduler.getServers().get(i)));
        }

        // System.out.println(scheduler.getServers().size());

        // System.out.println(threadList.size());
    }

    public void generateNRandomTasks() {



            for (int i = 0; i < numberOfClients; i++) {
                //int random = (int)(Math.random()(maxProcessTime-minProcessTime+1)+minProcessTime);
                int randomArrivalTime = (int) (Math.random() * (maxProcessTime - minProcessTime + 1) + minProcessTime);
                //int randomID = (int)(Math.random()*(numberOfClients)+1);
                int randomID = i + 1;
                int randomServiceTime = (int) (Math.random() * (maxServiceTime - minServiceTime + 1) + minServiceTime);

                // System.out.println(randomID+" "+randomArrivalTime+" "+randomServiceTime);
                Task task = new Task(randomID, randomArrivalTime, randomServiceTime);

                this.generatedTasks.add(task);

            }

            Collections.sort(generatedTasks);

        printWriter.println("Task-urile generate sunt: ");
        if(test1==1)
            printWriter1.println("Task-urile generate sunt: ");
        if(test2==1)
            printWriter2.println("Task-urile generate sunt: ");
        if(test3==1)
            printWriter3.println("Task-urile generate sunt: ");

        for (int i = 0; i <= generatedTasks.size() - 1; i++) {
                System.out.println(generatedTasks.get(i).toString());
            printWriter.println(generatedTasks.get(i).toString());
        }


        }



    public int getTimeLimit() {
        return timeLimit;
    }

    public List<Task> getGeneratedTasks() {
        return generatedTasks;
    }


    @Override
    public void run() {

        int max = -1;
        int currentTime = 0;
        for (int i = 0; i < scheduler.getServers().size(); i++) {

            threadList.get(i).setName("Queue " + i + " : ");
            threadList.get(i).start();
        }
        while (currentTime <= timeLimit) {


            boolean ok = false;
            int pas = 0;

            List<Integer> copie = Collections.synchronizedList(new ArrayList<>());
            List<Task> copieGenerated = Collections.synchronizedList(new ArrayList<>());

            System.out.println(Thread.currentThread().getName() + " says " + "La pasul :" + currentTime);
            printWriter.println(Thread.currentThread().getName() + " says " + "La pasul :" + currentTime);

            if(test1==1)
                printWriter1.println(Thread.currentThread().getName() + " says " + "La pasul :" + currentTime);
            if(test2==1)
                printWriter1.println(Thread.currentThread().getName() + " says " + "La pasul :" + currentTime);
            if(test3==1)
                printWriter1.println(Thread.currentThread().getName() + " says " + "La pasul :" + currentTime);

            frame.getTextAfisare().setText("La pasul :  "+currentTime+"\n");

            int i = 0;

            if (generatedTasks.size() > 0)
                while (i < generatedTasks.size() && currentTime == generatedTasks.get(i).getArrivalTime()) {
                    Task task = new Task(generatedTasks.get(i).getID(), generatedTasks.get(i).getArrivalTime(), generatedTasks.get(i).getServiceTime());

                    ok = scheduler.dispatchTask(task);

                    if (ok == true) {
                        copie.add(i);
                        averageWTime+=currentTime;
                        averageSTime+=currentTime+ task.getServiceTime();
                    }

                    i++;
                }
/*
            System.out.println(scheduler.getServers().get(0).getWaitingPerioad());
            System.out.println(scheduler.getServers().get(1).getWaitingPerioad());*/

            // System.out.println(scheduler.toString());
            int loc = 0;

            for (int j = 0; j < generatedTasks.size(); j++)
                if (copie.contains(j) == false)
                    copieGenerated.add(new Task(generatedTasks.get(j).getID(), generatedTasks.get(j).getArrivalTime(), generatedTasks.get(j).getServiceTime()));

            generatedTasks = copieGenerated;

            //System.out.println(generatedTasks.toString());

            int counter = 0;

            for (int j = 0; j < scheduler.getServers().size(); j++) {
                counter += scheduler.getServers().get(j).getTasks().size();

                if(counter>max)
                {
                    max = counter;
                    peakHour =  currentTime;
                }
            }

            if (currentTime  > timeLimit) {
                for (int j = 0; j < threadList.size(); j++)
                    threadList.get(j).stop();
            }

            for(Server server : scheduler.getServers()){
                synchronized (server) {
                    server.notify();
                }
            }

            ++currentTime;
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println(" Ora de varf a fost : "+peakHour);
        printWriter.println(" Ora de varf a fost : "+peakHour);
        printWriter.println(String.format(" Average waiting time : " + (double) (averageWTime / numberOfClients)));
        System.out.println(String.format(" Average waiting time : " + (double) (averageWTime / numberOfClients)));
        printWriter.println(String.format(" Average service time : " + (double) (averageSTime / numberOfClients)));
        System.out.println(String.format(" Average service time : " + (double) (averageSTime / numberOfClients)));
        printWriter.close();

        if(test1==1) {
            printWriter1.println(" Ora de varf a fost : " + peakHour);
            printWriter1.println(String.format(" Average waiting time : " + (double) (averageWTime / numberOfClients)));
            printWriter1.println(String.format(" Average service time : " + (double) (averageSTime / numberOfClients)));
            printWriter1.close();
        }

        if(test2==1) {
            printWriter2.println(" Ora de varf a fost : " + peakHour);
            printWriter2.println(String.format(" Average waiting time : " + (double) (averageWTime / numberOfClients)));
            printWriter2.println(String.format(" Average service time : " + (double) (averageSTime / numberOfClients)));
            printWriter2.close();
        }

        if(test3==1) {
            printWriter3.println(" Ora de varf a fost : " + peakHour);
            printWriter3.println(String.format(" Average waiting time : " + (double) (averageWTime / numberOfClients)));
            printWriter3.println(String.format(" Average service time : " + (double) (averageSTime / numberOfClients)));
            printWriter3.close();
        }

    }


    public static void main(String[] args) throws IOException, InterruptedException {

        frame.getButonTest1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    test1 = 1;

                    frame.getButonStart().setEnabled(false);
                    frame.getButonTest1().setEnabled(false);
                    frame.getButonTest2().setEnabled(false);
                    frame.getButonTest3().setEnabled(false);

                SimulationManager simulationManager = null;
                try {
                    simulationManager = new SimulationManager(60, 30, 2, 4, 2, 4, 2);

                    Thread t = new Thread(simulationManager);
                    t.setName("Main thread");
                    t.start();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });

        frame.getButonTest2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                test2 = 1;

                frame.getButonStart().setEnabled(false);
                frame.getButonTest1().setEnabled(false);
                frame.getButonTest2().setEnabled(false);
                frame.getButonTest3().setEnabled(false);

                SimulationManager simulationManager = null;
                try {
                    simulationManager = new SimulationManager(60, 40, 2, 7, 1, 50, 5);

                    Thread t = new Thread(simulationManager);
                    t.setName("Main thread");
                    t.start();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });

        frame.getButonTest3().addActionListener(e -> {

            test3= 1;

            frame.getButonStart().setEnabled(false);
            frame.getButonTest1().setEnabled(false);
            frame.getButonTest2().setEnabled(false);
            frame.getButonTest3().setEnabled(false);

            SimulationManager simulationManager = null;
            try {
                simulationManager = new SimulationManager(200, 100, 10, 9, 3, 1000, 20);

                Thread t = new Thread(simulationManager);
                t.setName("Main thread");
                t.start();

            } catch (IOException ex) {
                ex.printStackTrace();
            }


        });


        //t.sleep(100);
        frame.getButonStart().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    int timeLimit = Integer.parseInt(frame.getTimpMaximdeSimulare().getText().toString());
                    int timpMinimdeProcesare = Integer.parseInt(frame.getTimpMinimdeProcesare().getText().toString());
                    int timpMaximdeProcesare = Integer.parseInt(frame.getTimpMaximdeProcesare().getText().toString());
                    int timpMinimdeService = Integer.parseInt(frame.getTimpMinimdeService().getText().toString());
                    int timpMaximdeService = Integer.parseInt(frame.getTextField_1().getText().toString());
                    int numarServere = Integer.parseInt(frame.getNumarServere().getText().toString());
                    int numarClienti = Integer.parseInt(frame.getNumarClienti().getText().toString());

                  /*  System.out.println(timeLimit+" "+timpMinimdeProcesare+" "
                            +timpMinimdeProcesare+" "+timpMaximdeProcesare+" "+timpMaximdeService+" "
                            +timpMinimdeService+" "+timpMaximdeService+" "+numarServere+" "+numarClienti
                    );
                */
                    SimulationManager simulationManager = new SimulationManager(timeLimit, timpMaximdeProcesare, timpMinimdeProcesare, timpMaximdeService, timpMinimdeService, numarClienti, numarServere);
                    Thread t = new Thread(simulationManager);
                    t.setName("Main thread");
                    t.start();

                    frame.getButonStart().setEnabled(false);
                    frame.getButonTest1().setEnabled(false);
                    frame.getButonTest2().setEnabled(false);
                    frame.getButonTest3().setEnabled(false);


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame.getFrame(), "Date invalide");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


                //System.out.println(frame.get);
            }
        });

        frame.getFrame().setVisible(true);

    }
}
