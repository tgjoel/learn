package coding.generalprograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortWeekDays {
    /* Need to print the days in sorted order Sunday being first and Saturday being the last day
        >>> List may or may not have all the days. */

    public static void main(String[] args) {
        List<String> input1 = Arrays.asList("SUNDAY", "FRIDAY", "WEDNESDAY", "SATURDAY", "MONDAY", "THURSDAY", "TUESDAY");
        List<String> input2 = Arrays.asList("FRIDAY", "WEDNESDAY", "SATURDAY", "MONDAY", "THURSDAY");
        new SortWeekDays().sortUsingComparator(input1);
        new SortWeekDays().sortUsingEnum(input2);
    }

    private void sortUsingEnum(List<String> input) {
        input = input.stream().map(Weekdays::valueOf) // converting the input list to enum
                .sorted(Comparator.naturalOrder()) // sorting using the enum
                .map(Weekdays::name)  // converting back the enum to list
                .collect(Collectors.toList());
        System.out.println(input);

    }

    private void sortUsingComparator(List<String> input) {
        input.sort(new WeekdayComparator());
        System.out.println(input);
    }


    enum Weekdays {
        SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
        private int i;

        Weekdays(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }
    }
}

class WeekdayComparator implements Comparator<String> {

    Map<String, Integer> weekMap;

    public WeekdayComparator() {
        this.weekMap = new HashMap<>();
        weekMap.put("SUNDAY", 1);
        weekMap.put("MONDAY", 2);
        weekMap.put("TUESDAY", 3);
        weekMap.put("WEDNESDAY", 4);
        weekMap.put("THURSDAY", 5);
        weekMap.put("FRIDAY", 6);
        weekMap.put("SATURDAY", 7);
    }

    @Override
    public int compare(String o1, String o2) {
        return weekMap.get(o1).compareTo(weekMap.get(o2));
    }
}
