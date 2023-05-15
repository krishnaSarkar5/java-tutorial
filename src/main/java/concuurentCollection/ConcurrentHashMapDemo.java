package concuurentCollection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {


    public static void main(String[] args) {


        ConcurrentHashMap<Integer,String> chm = new ConcurrentHashMap<>();

        chm.put(101,"A");
        chm.put(102,"B");
        chm.put(103,"C");
        chm.put(104,"F");// this  put methods are from map interface so there are same like in map
        chm.put(104,"G");   // it will replace the last value of 104 key
        chm.putIfAbsent(108,"D"); // this entry will be added in chm as 108 key is not present
        chm.putIfAbsent(101,"D"); // as key 101 already present do it will bot be added in chm
        chm.remove(101,"D"); // successfully removed as given key and corresponding value is matched
        chm.replace(102,"B","E"); // successfully replaced as given key and corresponding old value is matched
        chm.replace(103,"M"); // this  replace  methods are from map interface so there are same like in map
        System.out.println(chm);


        //o/p =>  {101=A, 102=E, 103=M, 104=G, 108=D}

    }
}
