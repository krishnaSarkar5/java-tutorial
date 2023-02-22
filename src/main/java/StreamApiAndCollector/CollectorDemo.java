package StreamApiAndCollector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorDemo {



    public static void main(String[] args) {



        Employee e1 =  new Employee(1l,"Rahul Sen", LocalDate.parse("05-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")),100,new Department(1l,"QA"));
        Employee e2 =  new Employee(2l,"Suresh Saha", LocalDate.parse("25-11-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),150,new Department(3l,"Java"));
        Employee e3 =  new Employee(3l,"Manish Das", LocalDate.parse("22-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")),120,new Department(2l,"React"));
        Employee e4 =  new Employee(4l,"Anil Chandra", LocalDate.parse("12-06-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),170,new Department(1l,"QA"));
        Employee e5 =  new Employee(5l,"Akhil Kumar", LocalDate.parse("02-10-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),170,new Department(3l,"Java"));
        Employee e6 =  new Employee(6l,"Bijay Dutta", LocalDate.parse("11-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")),170,new Department(2l,"React"));


        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);


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
        Double average = numberList.stream().collect(Collectors.averagingDouble(Integer::intValue));

        System.out.println("averaging : "+average);

    }
}
