package Function;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
//        -----------------------------------------------------------------------------------------------------------
//        Consumer accept input but did not return anything  the abstarct method is accept()
//      -----------------------------------------------------------------------------------------------------------
        Consumer<Integer> c = num-> {
            if(num>10)
                System.out.println("Greater Than 10");
            else {
                System.out.println("less than 10");
            }
        };

        c.accept(15);  // Greater Than 10

//      -----------------------------------------------------------------------------------------------------------
//        Consumer Has only one default method => andThen()
//      -----------------------------------------------------------------------------------------------------------
//        method definition
//        default Consumer<T> andThen(Consumer<? super T> after) {
//            Objects.requireNonNull(after);
//            return (T t) -> { accept(t); after.accept(t); };
//        }

//        andThen() takes another Consumer and return a Consumer that basically call two consumer function
//        one is the before and then after

        Consumer<Integer> consumer1 = num-> System.out.println("Print by consumer 1 "+num);

        Consumer<Integer> consumer2 = num-> System.out.println("Print by consumer 2 "+num);

//        consumer1.andThen(consumer2).accept(10);

        List<Integer> numList = List.of(1,5,2,11,45,24,19,12,19);

        numList.forEach(consumer1.andThen(consumer2));

//        output
//        Print by consumer 1 1
//        Print by consumer 2 1
//        Print by consumer 1 5
//        Print by consumer 2 5
//        Print by consumer 1 2
//        Print by consumer 2 2
//        Print by consumer 1 11
//        Print by consumer 2 11
//        Print by consumer 1 45
//        Print by consumer 2 45
//        Print by consumer 1 24
//        Print by consumer 2 24
//        Print by consumer 1 19
//        Print by consumer 2 19
//        Print by consumer 1 12
//        Print by consumer 2 12
//        Print by consumer 1 19
//        Print by consumer 2 19



//        We have some special consumer that takes specific inputs

//        like IntConsumer,LongConsuer,DoubleConsumer
    }
}
