package StreamApiAndCollector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CollectorDemo {



    public static void main(String[] args) {



        Employee e1 =  new Employee(1l,"Rahul Sen", LocalDate.parse("05-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")),100,new Department(1l,"QA"));
        Employee e2 =  new Employee(2l,"Suresh Saha", LocalDate.parse("25-11-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),150,new Department(3l,"Java"));
        Employee e3 =  new Employee(3l,"Manish Das", LocalDate.parse("22-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")),120,new Department(2l,"React"));
        Employee e4 =  new Employee(4l,"Anil Chandra", LocalDate.parse("12-06-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),170,new Department(1l,"QA"));
        Employee e5 =  new Employee(5l,"Akhil Kumar", LocalDate.parse("02-10-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),190,new Department(3l,"Java"));
        Employee e6 =  new Employee(6l,"Bijay Dutta", LocalDate.parse("11-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")),210,new Department(2l,"React"));
        Employee e7 =  new Employee(7l,"Ajay Biswas", LocalDate.parse("11-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),185,new Department(1l,"QA"));
        Employee e8 =  new Employee(8l,"Mrinmoy Gupta", LocalDate.parse("21-11-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),250,new Department(3l,"Java"));
        Employee e9 =  new Employee(9l,"Arjun Bepari", LocalDate.parse("15-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")),290,new Department(2l,"React"));

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);
        employeeList.add(e8);
        employeeList.add(e9);


        Map<Employee,Integer> employeeMap = new HashMap<>();

        employeeMap.put(e1,10);
        employeeMap.put(e2,15);
        employeeMap.put(e3,12);
        employeeMap.put(e4,35);
        employeeMap.put(e5,49);
        employeeMap.put(e6,8);


        List<Integer> numberList = new ArrayList<>();
        numberList.add(23);
        numberList.add(12);
        numberList.add(11);
        numberList.add(34);
        numberList.add(76);
        numberList.add(9);
        numberList.add(45);
        numberList.add(19);

////////////////////////////////////////////
//                                        //
//              average                   //
//                                        //
////////////////////////////////////////////




//        public static <T> Collector<T, ?, Double> averagingDouble (ToDoubleFunction<? super T> mapper)
//        Returns a Collector that produces the arithmetic mean of a double-valued function applied to the input elements. If no elements are present, the result is 0.
//
//        The average returned can vary depending upon the order in which values are recorded, due to accumulated rounding error in addition of values of differing magnitudes. Values sorted by increasing absolute magnitude tend to yield more accurate results. If any recorded value is a NaN or the sum is at any point a NaN then the average will be NaN.
//
//        Parameters:
//<T>	   	the type of the input elements
////        mapper	   	a function extracting the property to be summed
//        Returns:  a Collector that produces the sum of a derived property
//
//        @implNote The double format can represent all consecutive integers in the range -253 to 253. If the pipeline has more than 253 values, the divisor in the average computation will saturate at 253, leading to additional numerical errors.
                                                                        //same as :  e->e
        Double averageDouble = numberList.stream().collect(Collectors.averagingDouble(Integer::intValue));

        System.out.println("averageDouble : "+averageDouble);


//        public static <T> Collector<T, ?, Double> averagingInt (ToIntFunction<? super T> mapper)
//        Returns a Collector that produces the arithmetic mean of an integer-valued function applied to the input elements. If no elements are present, the result is 0.
//
//        Parameters:
//<T>	   	the type of the input elements
//        mapper	   	a function extracting th
//        e property to be summed
//        Returns:  a Collector that produces the sum of a derived property

        Double averageInt =  numberList.stream().collect(Collectors.averagingInt(e->e));

        System.out.println("averageInt : "+averageInt);


        Double averageLong = numberList.stream().collect(Collectors.averagingLong(Integer::intValue));

        System.out.println("averageLong : "+averageLong);


////////////////////////////////////////////
//                                        //
//              CollectingAndThen         //
//                                        //
////////////////////////////////////////////




//        public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen (Collector<T, A, R> downstream, Function<R, RR> finisher)
//        Adapts a Collector to perform an additional finishing transformation. For example, one could adapt the toList() collector to always produce an immutable list with:
//
//
//        List<String> people
//                = people.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList));
//
//        Parameters:
//<T>	   	the type of the input elements
//                <A>	   	intermediate accumulation type of the downstream collector
//                <R>	   	result type of the downstream collector
//<RR>	   	result type of the resulting collector
//        downstream	   	a collector
//        finisher	   	a function to be applied to the final result of the downstream collector
//        Returns:  a collector which performs the action of the downstream collector, followed by an additional finishing step


//        it basically first collect to a collection and then do any operation on it

//        find the percentage of share for total salary of the employees whose salary >= 150, total cost of company = 5000

        Double percentageShare = employeeList.stream().filter(e -> e.getSalary() >= 150)
                                                        .collect(
                                                                Collectors.collectingAndThen(
                                                                        Collectors.summingInt(e -> e.getSalary()),
                                                                        totalSalay -> ( totalSalay.doubleValue()* 100) / 5000
                                                                ));
        System.out.println("percentageShare:  "+percentageShare);




////////////////////////////////////////////
//                                        //
//              Counting                  //
//                                        //
////////////////////////////////////////////


        //    public static <T> Collector<T, ?, Long> counting ()
//    Returns a Collector accepting elements of type T that counts the number of input elements. If no elements are present, the result is 0.
//
//    Parameters:
//    <T>	   	the type of the input elements
//    Returns:  a Collector that counts the input elements
//
//    @implSpec This produces a result equivalent to:
//
//
//    reducing(0L, e -> 1L, Long::sum)


//    no of employees whose joins in 2023


        Long noOfEmployeesJoinedIn2023 = employeeList.stream().filter(e -> e.getJoiningDate().getYear() == 2023).collect(Collectors.counting());

        System.out.println("noOfEmployeesJoinedIn2023:  "+noOfEmployeesJoinedIn2023);






////////////////////////////////////////////
//                                        //
//              Grouping By               //
//                                        //
////////////////////////////////////////////


//        public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy (Function<? super T, ? extends K> classifier)
//        Returns a Collector implementing a "group by" operation on input elements of type T, grouping elements according to a classification function, and returning the results in a Map.
//
//        The classification function maps elements to some key type K. The collector produces a Map<K, List<T>> whose keys are the values resulting from applying the classification function to the input elements, and whose corresponding values are Lists containing the input elements which map to the associated key under the classification function.
//
//                There are no guarantees on the type, mutability, serializability, or thread-safety of the Map or List objects returned.
//
//                Parameters:
//<T>	   	the type of the input elements
//                <K>	   	the type of the keys
//        classifier	   	the classifier function mapping input elements to keys
//        Returns:  a Collector implementing the group-by operation
//
//        See also:
//        groupingBy(Function, Collector), groupingBy(Function, Supplier, Collector), groupingByConcurrent(Function)
//
//        @implSpec This produces a result similar to:
//
//
//        groupingBy(classifier, toList());
//
//
//        @implNote The returned Collector is not concurrent. For parallel stream pipelines, the combiner function operates by merging the keys from one map into another, which can be an expensive operation. If preservation of the order in which elements appear in the resulting Map collector is not required, using groupingByConcurrent(Function) may offer better parallel performance.




//   find all employees groupBy department id


        Map<Long, List<Employee>> groupingResult = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment().getId()));

        System.out.println("groupingResult:  "+groupingResult);

//   find department wise highest salary

        Map<String, Optional<Employee>> departmentWiseHighestSalary = employeeList.stream()
                                                                                  .collect(
                                                                                            Collectors.groupingBy(
                                                                                                                   e -> e.getDepartment().getDepartmentName()  ,   Collectors.maxBy((emp1, emp2) -> emp1.getSalary() -emp2.getSalary())));


        System.out.println("departmentWiseHighestSalary:  "+departmentWiseHighestSalary);


        Map<String, Employee> secondHighestSalary = employeeList.stream().collect(
                                                                    Collectors.groupingBy(
                                                                                            e -> e.getDepartment().getDepartmentName() ,
                                                                                                                                        Collectors.collectingAndThen(Collectors.toList(),
                                                                                                                                                                                        list -> list.stream()
                                                                                                                                                                                                .sorted((emp1, emp2) -> emp1.getSalary() - emp2.getSalary())  // increasing sorting order
                                                                                                                                                                                                .skip(Math.max(0, list.size() - 2))  // for 3rd highest salary it should be 3
                                                                                                                                                                           .findFirst().get())));


        System.out.println("departmentWiseSecondHighestSalary:  "+secondHighestSalary);



////////////////////////////////////////////
//                                        //
//              Joining                   //
//                                        //
////////////////////////////////////////////





//        public static Collector<CharSequence, ?, String> joining ()
//        Returns a Collector that concatenates the input elements into a String, in encounter order.
//
//        Returns:  a Collector that concatenates the input elements into a String, in encounter order


        String allNumbersStringByJoining = numberList.stream().map(e -> e.toString()).collect(Collectors.joining(","));

        System.out.println("allNumbersStringByJoining: "+allNumbersStringByJoining);

//        give all the employees name by comma separated

        String allEmployeesName = employeeList.stream().map(e -> e.getName()).collect(Collectors.joining(" || ","<",">"));

        System.out.println("allEmployeesName:  "+allEmployeesName);




////////////////////////////////////////////
//                                        //
//              mapping                   //
//                                        //
////////////////////////////////////////////






//        public static <T, U, A, R> Collector<T, ?, R> mapping (Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
//        Adapts a Collector accepting elements of type U to one accepting elements of type T by applying a mapping function to each input element before accumulation.
//
//        Parameters:
//<T>	   	the type of the input elements
//                <U>	   	type of elements accepted by downstream collector
//                <A>	   	intermediate accumulation type of the downstream collector
//                <R>	   	result type of collector
//        mapper	   	a function to be applied to the input elements
//        downstream	   	a collector which will accept mapped values
//        Returns:  a collector which applies the mapping function to the input elements and provides the mapped results to the downstream collector
//
//        @apiNote The mapping() collectors are most useful when used in a multi-level reduction, such as downstream of a groupingBy or partitioningBy. For example, given a stream of Person, to accumulate the set of last names in each city:
//
//
//        Map<City, Set<String>> lastNamesByCity
//                = people.stream().collect(groupingBy(Person::getCity,
//                mapping(Person::getLastName, toSet())));






//      print the employee names group by alphabaticaly

        Map<Character, List<String>> alphabaticallyEmployeeNames = employeeList.stream()
                                                                               .collect(
                                                                                         Collectors.groupingBy(
                                                                                                                e -> e.getName().charAt(0), Collectors.mapping(
                                                                                                                                                                 e -> e.getName(), Collectors.toList())));

        System.out.println("alphabaticallyEmployeeNames:  "+alphabaticallyEmployeeNames);








////////////////////////////////////////////
//                                        //
//              maxBy                     //
//                                        //
////////////////////////////////////////////



//        public static <T> Collector<T, ?, Optional<T>> maxBy (Comparator<? super T> comparator)
//        Returns a Collector that produces the maximal element according to a given Comparator, described as an Optional<T>.
//
//        Parameters:
//<T>	   	the type of the input elements
//        comparator	   	a Comparator for comparing elements
//        Returns:  a Collector that produces the maximal value
//
//        @implSpec This produces a result equivalent to:
//
//
//        reducing(BinaryOperator.maxBy(comparator))


        Optional<Integer> maxNumberOptional = numberList.stream().collect(Collectors.maxBy((num1, num2) -> num1 - num2));

        System.out.println("max Number: "+maxNumberOptional.get());








////////////////////////////////////////////
//                                        //
//              minBy                     //
//                                        //
////////////////////////////////////////////




//        public static <T> Collector<T, ?, Optional<T>> minBy (Comparator<? super T> comparator)
//        Returns a Collector that produces the minimal element according to a given Comparator, described as an Optional<T>.
//
//        Parameters:
//<T>	   	the type of the input elements
//        comparator	   	a Comparator for comparing elements
//        Returns:  a Collector that produces the minimal value
//
//        @implSpec This produces a result equivalent to:
//
//
//        reducing(BinaryOperator.minBy(comparator))


        Optional<Integer> minNumberOptional = numberList.stream().collect(Collectors.minBy((num1, num2) -> num1 - num2));

        System.out.println("minNumberOptional: "+minNumberOptional.get());





////////////////////////////////////////////
//                                        //
//              partitionBy               //
//                                        //
////////////////////////////////////////////





//        public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy (Predicate<? super T> predicate)
//        Returns a Collector which partitions the input elements according to a Predicate, and organizes them into a Map<Boolean, List<T>>. There are no guarantees on the type, mutability, serializability, or thread-safety of the Map returned.
//
//        Parameters:
//<T>	   	the type of the input elements
//        predicate	   	a predicate used for classifying input elements
//        Returns:  a Collector implementing the partitioning operation
//
//        See also:
//        partitioningBy(Predicate, Collector)



//        partition the numbers based on even odd and sort each groups


        Map<Boolean, List<Integer>> evenNumberList = numberList.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));

        System.out.println("evenNumberList: "+evenNumberList);
//        partition the numbers based on even odd and sort each groups

        Map<Boolean, List<Integer>> evenNumberListWithSorting = numberList.stream()
                                                                           .collect(
                                                                                     Collectors.partitioningBy(e -> e % 2 == 0  ,  Collectors.collectingAndThen(
                                                                                                                                                                 Collectors.toList()  ,  list->list.stream()
                                                                                                                                                                                                   .sorted((num1,num2)->num2-num1)
                                                                                                                                                                                                   .collect(Collectors.toList()))));


        System.out.println("evenNumberListWithSorting: "+evenNumberListWithSorting);






////////////////////////////////////////////
//                                        //
//              reduce                    //
//                                        //
////////////////////////////////////////////




//        public static <T> Collector<T, ?, Optional<T>> reducing (BinaryOperator<T> op)
//        Returns a Collector which performs a reduction of its input elements under a specified BinaryOperator. The result is described as an Optional<T>.
//
//        Parameters:
//<T>	   	element type for the input and output of the reduction
//        op	   	a BinaryOperator<T> used to reduce the input elements
//        Returns:  a Collector which implements the reduction operation
//
//        See also:
//        reducing(Object, BinaryOperator), reducing(Object, Function, BinaryOperator)
//
//        @apiNote The reducing() collectors are most useful when used in a multi-level reduction, downstream of groupingBy or partitioningBy. To perform a simple reduction on a stream, use Stream.reduce(BinaryOperator) instead.
//
//                For example, given a stream of Person, to calculate tallest person in each city:
//
//
//        Comparator<Person> byHeight = Comparator.comparing(Person::getHeight);
//        Map<City, Person> tallestByCity
//                = people.stream().collect(groupingBy(Person::getCity, reducing(BinaryOperator.maxBy(byHeight))));


        Map<String, Optional<Employee>> departmentWiseMaxSalariedEmployee = employeeList.stream()
                                                                                        .collect(
                                                                                                    Collectors.groupingBy(    e -> e.getDepartment().getDepartmentName()   , Collectors.reducing(BinaryOperator.maxBy((emp1, emp2) -> emp1.getSalary() - emp2.getSalary()))));

        System.out.println( departmentWiseMaxSalariedEmployee);






////////////////////////////////////////////
//                                        //
//              summarizingDouble         //
//                                        //
////////////////////////////////////////////



//        public static <T> Collector<T, ?, DoubleSummaryStatistics> summarizingDouble (ToDoubleFunction<? super T> mapper)
//        Returns a Collector which applies an double-producing mapping function to each input element, and returns summary statistics for the resulting values.
//
//                Parameters:
//<T>	   	the type of the input elements
//        mapper	   	a mapping function to apply to each element
//        Returns:  a Collector implementing the summary-statistics reduction
//
//        See also:
//        summarizingLong(ToLongFunction), summarizingInt(ToIntFunction)
//        it gives output consisting max,min,sum,average etc

        IntSummaryStatistics intSummaryStatistics = numberList.stream().collect(Collectors.summarizingInt(e -> e));

        System.out.println("intSummaryStatistics: "+intSummaryStatistics);



////////////////////////////////////////////
//                                        //
//              summingInt                //
//                                        //
////////////////////////////////////////////


//        public static <T> Collector<T, ?, Integer> summingInt (ToIntFunction<? super T> mapper)
//        Returns a Collector that produces the sum of a integer-valued function applied to the input elements. If no elements are present, the result is 0.
//
//        Parameters:
//<T>	   	the type of the input elements
//        mapper	   	a function extracting the property to be summed
//        Returns:  a Collector that produces the sum of a derived property


        Integer sum = numberList.stream().collect(Collectors.summingInt(e -> e));

        System.out.println("sum : "+sum);

    }












}
