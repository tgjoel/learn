package coding.generalprograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestHashCodeAndEquals {

    public static void main(String[] args) {

        Map<EmployeeHash, String> map = new HashMap<>();
        EmployeeHash emp1 = new EmployeeHash(1);
        EmployeeHash emp2 = new EmployeeHash(1);
        map.put(emp1, "hi");
        map.put(emp2,"hi");
        System.out.println("Map Size: " + map.size());
        System.out.println(map.values());

        /*
        The map size will be 2 if the both the hashcode and the equals are not overridden.
        If either one is not then will cause the duplication of the entry.
         */

    }
}

class EmployeeHash {
    int id;

    public EmployeeHash(int id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EmployeeHash that = (EmployeeHash) o;
//        return id == that.id;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
