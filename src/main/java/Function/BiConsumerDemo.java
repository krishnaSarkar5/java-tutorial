package Function;

import java.util.function.BiConsumer;

public class BiConsumerDemo {

    public static void main(String[] args) {


//        ----------------------------------------------------------------------------------------------
//        BiConsumer takes two input and does not return anything
//        it has one abstract method => accept() and one static method andThen()
//        ----------------------------------------------------------------------------------------------

            BiConsumer<Integer,Integer> biConsumer = (a,b)-> System.out.println("The sum of two inputs are "+(a+b));

            biConsumer.accept(10,2);

//            andThen() method works same as Consumer andThen()
//        There are also other types of BiConsumer that takes special Inputs


//        ObjIntConsumer = > it takes two input ----  Object,Integer
//        ObjLongConsumer = > it takes two input ----  Object,Long
//        ObjDoubleConsumer = > it takes two input ----  Object,double




    }
}
