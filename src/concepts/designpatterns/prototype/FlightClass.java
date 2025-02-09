package concepts.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class FlightClass implements Cloneable {
    private List<String> defaultFlightList;

    public FlightClass() {
        this.defaultFlightList = new ArrayList<>();
    }

    public FlightClass(List<String> defaultFlightList) {
        this.defaultFlightList = defaultFlightList;
    }

    public List<String> getDefaultFlightList() {
        return defaultFlightList;
    }

    public void setDefaultFlightList(List<String> defaultFlightList) {
        this.defaultFlightList = defaultFlightList;
    }

    public void loadDefaultFlightList() {
        defaultFlightList.add("Indian Airways");
        defaultFlightList.add("Fly Dubai");
        defaultFlightList.add("Pan America");
        defaultFlightList.add("Jet Airways");
        defaultFlightList.add("Indigo");
    }

    @Override
    protected Object clone() {
        List<String> tmp = new ArrayList<>();
        for (String flight: getDefaultFlightList()) {
            tmp.add(flight);
        }
        return new FlightClass(tmp);
    }
}
