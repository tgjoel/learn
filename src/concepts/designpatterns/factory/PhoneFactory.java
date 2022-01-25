package concepts.designpatterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class PhoneFactory {

    static Map<String, Supplier<Phone>> supplierMap = new HashMap<>();
    static {
        supplierMap.put("apple", IPhone::new);
        supplierMap.put("google", AndroidPhone::new);
        supplierMap.put("microsoft", WindowsPhone::new);
    }

    public static Phone getPhone(String s) {
//        switch (s) {
//            case "apple" : return new IPhone();
//            case "google" : return  new AndroidPhone();
//            case "microsoft" : return new WindowsPhone();
//        }
//        return null;
        // improved way
        Supplier<Phone> phoneSupplier = supplierMap.get(s);
        return Objects.nonNull(phoneSupplier) ? phoneSupplier.get() : null;
    }
}
