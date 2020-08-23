import java.util.Comparator;

public class CustomComp implements Comparator<Income> {

    @Override
    public int compare(Income a, Income b) {
        String topKeyA = a.getCountry();
        if (topKeyA.equals(""))
            topKeyA = a.getCity();

        String topKeyB = b.getCountry();
        if (topKeyB.equals(""))
            topKeyB = b.getCity();

        if (topKeyA.equals(topKeyB)) {
            if (a.getGender().equals(b.getGender())) {
                return a.getAmountUSD().compareTo(b.getAmountUSD());
            }
            return a.getGender().compareTo(b.getGender());
        }
        return topKeyA.compareTo(topKeyB);
    }
}