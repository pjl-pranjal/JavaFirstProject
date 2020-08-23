import java.util.HashMap;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class BO {
    private HashMap<String, UnaryOperator<Double>> rates;

    public BO() {
        this.rates = new HashMap<String, UnaryOperator<Double>>();
        this.rates.put("inr", d -> d / 66.0);
        this.rates.put("gbp", d -> d / 0.67);
        this.rates.put("sgd", d -> d / 1.5);
        this.rates.put("hkd", d -> d / 8.0);
        this.rates.put("usd", d -> d);
    }

    public void processIncomes(ArrayList<Income> incomes) {
        for (Income i : incomes)
            i.setAmountUSD(this.rates.get(i.getCurrency()).apply(i.getAmount()));
    }
}