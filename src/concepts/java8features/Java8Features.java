package concepts.java8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Features {

    public static void main(String[] args) {

        //Predicate:
        System.out.println("Predicate");
        List<Integer> integerList = Arrays.asList(112, 22, 34, 41, 51, 1, 522, 34, 65, 9);
        Predicate<Integer> p1 = x -> x > 10;
        Predicate<Integer> p2 = x -> x < 400;
        Predicate<AClass> aClassPredicate = x-> x.id > 100;
        List<Integer> filtered = integerList.stream().filter(p1.and(p2)).collect(Collectors.toList());
        filtered.sort(Integer::compareTo);
        filtered.forEach(x -> System.out.print(" " + x));


        System.out.println();
        System.out.println("BiPredicate");

        //BiPredicate
        BiPredicate<Integer, Integer> p3 = (x, y) -> x > 10 && y < 400;
        filtered = integerList.stream().filter(x -> p3.test(x, x)).collect(Collectors.toList());
        filtered.forEach(x -> System.out.print(" " + x));

        System.out.println();
        System.out.println("Functional interface");
        //adding two numbers using functional interface
        CalculateInterface calculateInterface = (x,y) -> x+y;   // OR: Integer::sum
        int ans = calculateInterface.calculate(10,20);
        System.out.print(ans + "  ");
        calculateInterface = Integer::max;
        ans = calculateInterface.calculate(10,20);
        System.out.println(ans);

        System.out.println("Creating map of numbers repeating");
        List<Integer> integerList1 = Arrays.asList(11, 22, 34, 11, 51, 11, 22, 34, 22, 51, 34, 11, 51);
        Map<Integer, Long> integerMap = integerList1.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
        //Can use Function.identity() instead of x->x;
        System.out.println(integerMap);

        integerMap.forEach((k,v) -> {
            System.out.println("Key:" + k);
            System.out.println("Value:" + v);
        });

        //comparing based on two condition.
        List<AClass> aclassList = Arrays.asList(new AClass(1, "ewew"), new AClass(12, "eregfg"),
                new AClass(454, "QAsgsfdgZ"), new AClass(644, "hgdhghdx"));
        aclassList.sort(Comparator.comparingInt(AClass::getId).thenComparing(AClass::getName));
        System.gc();
    }
}

@FunctionalInterface
interface CalculateInterface {
    int calculate(int i, int j);
}

class AClass {
    Integer id;
    String name;


    public AClass(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
