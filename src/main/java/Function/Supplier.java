package Function;

import java.util.function.DoubleSupplier;

public class Supplier {



    public static void main(String[] args) {

        // This will only return does not take any input
        java.util.function.Supplier<String> supplierRef = ()-> "From supplier";

        System.out.println( supplierRef.get());


        // Similarly we have some special supplier which returns specific datatype
        // like BooleanSupplier , IntSupplier, LongSupplier, DoubleSupplier

        DoubleSupplier doubleSupplier = ()->Math.random();

        System.out.println(doubleSupplier.getAsDouble());


    }
}
