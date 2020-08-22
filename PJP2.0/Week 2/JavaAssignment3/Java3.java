import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Arrays;

public class Java3 {
    // country/city->gender : income
    private HashMap<String, HashMap<String, Double>> avgIncomes;
    private HashMap<String, Double> conversionRates;

    public Java3() {
        this.avgIncomes = new HashMap<String, HashMap<String, Double>>();
        this.conversionRates = new HashMap<String, Double>();
        this.conversionRates.put("INR", 66.0);
        this.conversionRates.put("GBP", 0.67);
        this.conversionRates.put("SGD", 1.5);
        this.conversionRates.put("HKD", 8.0);
    }

    public static void main(String[] args) {
        Java3 ob = new Java3();
        ob.solve();
        ob.report();
    }

    public void report() {
        String[] regions = this.avgIncomes.keySet().toArray(new String[this.avgIncomes.size()]);
        Arrays.sort(regions);

        for (String region : regions) {
            for (String gender : new String[]{"F", "M"}) {
                System.out.println(region + "," + gender + "," + this.avgIncomes.get(region).get(gender));
            }
        }
    }

    public void solve() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("income.csv"));

            String[] record;
            String line = br.readLine();
            while (line != null) {
                record = line.split(",");

                String topKey = record[0];
                if (!record[1].equals("")) {
                    topKey = record[1];
                }

                if (!this.avgIncomes.containsKey(topKey))
                    this.avgIncomes.put(topKey, new HashMap<String, Double>());

                this.avgIncomes.get(topKey).put(record[2], this.convertToUSD(record[4], record[3]));
                line = br.readLine();
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private Double convertToUSD(String value, String currency) throws Exception {
        Double val = Double.parseDouble(value);
        if (!currency.equals("USD")) {
            val = val/this.conversionRates.get(currency);
        }
        return val;
    }
}