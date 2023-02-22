package StreamApiAndCollector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamApiDemo {


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









//        public abstract boolean allMatch (Predicate<? super T> predicate)
//        Returns whether all elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then true is returned and the predicate is not evaluated.
//
//        This is a short-circuiting terminal operation.
//
//        Parameters:
//        predicate	   	a non-interfering, stateless predicate to apply to elements of this stream
//        Returns:  true if either all elements of the stream match the provided predicate or the stream is empty, otherwise false
//
//        @apiNote This method evaluates the universal quantification of the predicate over the elements of the stream (for all x P(x)). If the stream is empty, the quantification is said to be vacuously satisfied and is always true (regardless of P(x)).


        boolean allMatchResult1 = numberList.stream().allMatch(n -> n >= 9);  // here all the elements in the list n>=9 satisfy so it gives true. but if we give n>=10 then it will give false

        System.out.println(allMatchResult1);

//        check weather all the employees has salary >= 100
        boolean allMatchResult2 = employeeMap.entrySet().stream().allMatch(e -> e.getKey().getSalary() >= 100);

        System.out.println(allMatchResult2);









//        public abstract boolean anyMatch (Predicate<? super T> predicate)
//        Returns whether any elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then false is returned and the predicate is not evaluated.
//
//        This is a short-circuiting terminal operation.
//
//        Parameters:
//        predicate	   	a non-interfering, stateless predicate to apply to elements of this stream
//        Returns:  true if any elements of the stream match the provided predicate, otherwise false
//
//        @apiNote This method evaluates the existential quantification of the predicate over the elements of the stream (for some x P(x)).


        boolean anyMatchResult1 = numberList.stream().anyMatch(e -> e < 10);

        System.out.println("anyMatchResult1 :"+anyMatchResult1);

        boolean anyMatchResult2 = employeeMap.entrySet().stream().anyMatch(e -> e.getKey().getSalary() == 100);

        System.out.println("anyMatchResult2 :"+anyMatchResult2);

    }
}
