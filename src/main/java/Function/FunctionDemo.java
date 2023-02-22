package Function;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
//        -------------------------------------------------------------------------------
//        Function takes one input and returns output
//        -------------------------------------------------------------------------------
//                 i/p      o/p
        Function<Integer,Integer> func1 = num->num*2;

        System.out.println(func1.apply(10));  // o/p = 20

//        -------------------------------------------------------------------------------
//        Function has one static method
//        -------------------------------------------------------------------------------


//        /**
//         * Returns a function that always returns its input argument.
//         *
//         * @param <T> the type of the input and output objects to the function
//         * @return a function that always returns its input argument
//         */
//        static <T> Function<T, T> identity() {
//            return t -> t;
//        }

//     It basically returns its input. i.e  output  = input

        Function<String,String> identityFuntion  = Function.identity();

        System.out.println(identityFuntion.apply("Hi"));  // output is also Hi

//        -------------------------------------------------------------------------------
//        Function has two default method  =>  compose() , andThen()
//        -------------------------------------------------------------------------------

        Function<Integer,Integer> times2 = num->num*2;

        Function<Integer,Integer> squared = num->num*num;

        System.out.println(times2.compose(squared).apply(4));  // 32
        System.out.println(times2.andThen(squared).apply(4));  // 64

//        compose() method execute the caller last and parameter first . i.e. it first called the squared after that times2
//        i.e.   4*4 = 16 --->   16*2 = 32 (final o/p)

//        andThen() method execute the caller first and parameter last . i.e. it first called the times2 after that squared
//        i.e.   4*2 = 8 --->   8*8 = 64 (final o/p)




    }

}
