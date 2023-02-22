package Function;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {

    public static void main(String[] args) {

//        ----------------------------------------------------------
//        Pedicate wil take one input and return boolean. the abstract method is test()
//        ----------------------------------------------------------
        Predicate<Integer> isOdd = num-> num%2==0;

        System.out.println(isOdd.test(5));


//        ----------------------------------------------------------
//        Pedicate has Two static method  =>   isEqual()   ,  not()
//        ----------------------------------------------------------
//        Pedicate<T> isEqual(Object targetRef)

//        isEqual method returns a predicate that tests if two arguments are equal accornding to Objects.equals(Object obj1,Object obj2)
//          basically it returns a predicate which has a lamda function that comapre two object using Objects.equals(Object obj1,Object obj2)

            Predicate<Integer> p = Predicate.isEqual(5);
            System.out.println(p.test(5)); // true


//        not() takes Predicate as argument and then call the negate() method by this input predicate

//        ----------------------------------------------------------
//        Pedicate has three static method  => or , and , negate
//        ----------------------------------------------------------

//      negate() will not take any Predicate as argument like and() , or().   it basically inverse the existing predicate

        Predicate<Integer> condition1 = num->num>=10;
        Predicate<Integer> condition2 = num->num<=20;

        System.out.println(condition1.and(condition2).test(5)); //false

        System.out.println(condition1.or(condition2).test(35)); // true
        System.out.println(condition1.or(condition2).negate().test(15)); // .negate() basically inverse the result // false

        List<Integer> numList = List.of(1,5,2,11,45,24,19,12,19);

        List<Integer> filter = numList.stream().filter(condition1.and(condition2)).collect(Collectors.toList());


        List<Integer> sortedFilter = numList.stream().filter(condition1.and(condition2)).sorted((x,y)->y-x).collect(Collectors.toList());

        System.out.println(sortedFilter); // [19, 19, 12, 11]

//         There are also some special Prediacte which take specific defined input
//       ex: IntPredicate, LongPredicate , DoublePredicate



    }
}
