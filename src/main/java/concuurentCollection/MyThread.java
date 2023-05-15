package concuurentCollection;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyThread implements Runnable{



    static ConcurrentHashMap<Integer,String> chm = new ConcurrentHashMap<>();


    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Child thread is updating");
        chm.put(103,"C");
    }

    public static void main(String[] args) {

        chm.put(101,"A");
        chm.put(102,"B");
        Thread t = new Thread(new MyThread());
        t.start();

        Set<Integer> keys = chm.keySet();

        Iterator<Integer> iterator = keys.iterator();

        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println("Main thread is iterating Map and current entry is : "+key+" "+ chm.get(key));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(chm);

    }

    // o/p => Main thread is iterating Map and current entry is : 104 A
    //Child thread is updating
    //Main thread is iterating Map and current entry is : 105 B
    //{103=C, 104=A, 105=B}
}
