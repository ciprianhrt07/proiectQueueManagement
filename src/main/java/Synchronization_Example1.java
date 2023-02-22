//comunicarea dintre thread-uri
/*
     Methods:
      1. wait
      2. notify
      3. notifyAll

      -> toate trebuie apelate dintr-o metoda sincronizata,sau bloc sincronizat





*/
















/*
      synchronized static retun_type method_name(parameters)
      {
        //code
      }

  */
 //OR
 /*
    synchronized static return_type method_name(class_name.class)
    {
     //code
    }

  */

 //program without Static Synchronization

 /*  Observatii :

    1. cand o metoda nu este sincronizata si pe ea au loc operatiuni
       facute de mai multe thread-uri , ordinea efectuarii este random

    2. o solutie la problema de sus este sa se adauge in fata metodei
       key-word-ul synchronized care va face ca thread-urile sa aiba
       acces la metoda in mod separat astfel incat daca primult thread
       vrea sa determine cat e 5 la a 5-a , thread-ul 2 care vrea sa calculeze
       cat e 8 la a 8-a sa stea in sleep

    3. o alta metoda de sincronizare este un block de sincronicare:
       se pune synchronized (this){
         --codul ce se va efectua  de catre ambele thread-uri
       }


  */

/*

class Power {


    //metoda nu este sincronizata daca nu are synchronized in fata
 synchronized  void printPower(int n)
    {
        int temp = 1;

        for(int i=1;i<=5;i++)
        {
            System.out.println(Thread.currentThread().getName() + ":- " +n + "^"+ i + " value: " + n*temp);

            temp = n*temp;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }

    }

}

 class Thread2 extends Thread{

    Power p;

    Thread2(Power p){

        this.p = p;

    }

    public void run()
    {
        p.printPower(8);
    }

 }


 class Thread1 extends Thread{

     Power p;

     Thread1(Power p){

         this.p = p;

     }

     public void run()
     {
         p.printPower(5);
     }

 }


 public class Synchronization_Example1{

    public static void main(String[] args)
    {
        Power obj = new Power();   //create only one power object

        Thread1 thread1 = new Thread1(obj);

        Thread2 thread2 = new Thread2(obj);

        thread2.setName("Thread2");
        thread1.setName("Thread1");

        thread1.start();


        thread2.start();


    }

 }

  3) synchronized (this) {
           int temp = 1;

           for (int i = 1; i <= 5; i++) {
               System.out.println(Thread.currentThread().getName() + ":- " + n + "^" + i + " value: " + n * temp);

               temp = n * temp;

               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   System.out.println(e);
               }

           }


 */