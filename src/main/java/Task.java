import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Comparable{


    private  int ID;               // >=1 <=n
    private  int arrivalTime;      // >= minArrivalTime <=maxArrivalTime
    private  AtomicInteger serviceTime = new AtomicInteger(0);      // >= minServiceTime <=maxServiceTime
    private  AtomicInteger  averageWaitingTime;
    private  AtomicInteger  averageServiceTime;

    public  Task(int ID,int arrivalTime,int serviceTime)
    {
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime.set(serviceTime);
        this.averageServiceTime = new AtomicInteger(0);
        this.averageWaitingTime = new AtomicInteger(0);
    }

    public synchronized int getID() {
        return ID;
    }

    //public void setID(int ID) {
    //    this.ID = ID;
    //}

    public synchronized  int getArrivalTime() {
        return arrivalTime;
    }

    // public void setArrivalTime(int arrivalTime) {
    //     this.arrivalTime = arrivalTime;
    // }

    public synchronized  int getServiceTime() {
        return serviceTime.intValue();
    }

    //public void setServiceTime(int serviceTime) {
    //    this.serviceTime = serviceTime;
    //}

    @Override
    public synchronized  String toString() {
        return "Task{" +
                "ID=" + ID +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }

    @Override
    public synchronized int compareTo(Object o) {

        Task t = (Task) o;

        int ok=0;

        if(this.arrivalTime>t.getArrivalTime())
            ok=1;
        else
        if(this.arrivalTime==t.getArrivalTime())
        {
                if(this.serviceTime.intValue()>t.getServiceTime())
                    ok=1;
                else
                if(this.serviceTime.intValue()<t.getServiceTime())
                    ok=-1;

        }else
            ok=-1;

        return ok;

    }

    public AtomicInteger getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public void setAverageWaitingTime(AtomicInteger averageWaitingTime) {
        this.averageWaitingTime = averageWaitingTime;
    }

    public AtomicInteger getAverageServiceTime() {
        return averageServiceTime;
    }

    public void setAverageServiceTime(AtomicInteger averageServiceTime) {
        this.averageServiceTime = averageServiceTime;
    }

    public synchronized String toString(AtomicInteger waitingPerioad) {

        return "Task{" +
                "ID=" + ID +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + waitingPerioad +
                ", averageWaitingTime=" + averageWaitingTime +
                ", averageServiceTime=" + averageServiceTime +
                '}';

    }


    public void setServiceTime(int serviceTime) {
        this.serviceTime.set(serviceTime);
    }
}

