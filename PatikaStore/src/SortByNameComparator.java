import java.util.Comparator;

public class SortByNameComparator implements Comparator<PatikaStore> {

    @Override
    public int compare(PatikaStore o1, PatikaStore o2) {
        return o1.getBrandName().compareTo(o2.getBrandName());
    }
}
