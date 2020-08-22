import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Java2 {

    // "dateSecurityType" superkey
    private HashMap<String, HashSet<String>> clientHistory;
    
    // C1->Type->partialTransactionString ("Date,Priority,Rest")
    // encode Priority as 0 or 1, for display use Y or N, so that Y stays at top in report
    // encode Date as YYYY/MM/DD but display as required
    private HashMap<String, HashMap<String, HashSet<String>>> clientTransactions;
    
    // T1->fee
    private HashMap<String, Integer> fees;

    private ArrayList<String> transactionTypes;

    public Java2() {
        this.clientHistory = new HashMap<String, HashSet<String>>();
        this.clientTransactions = new HashMap<String, HashMap<String, HashSet<String>>>();
        this.fees = new HashMap<String, Integer>();

        // sorted order
        this.transactionTypes = new ArrayList<String>();
        this.transactionTypes.add("BUY");
        this.transactionTypes.add("DEPOSIT");
        this.transactionTypes.add("SELL");
        this.transactionTypes.add("WITHDRAW");
    }

    public static void main(String[] args) {
        Java2 ob = new Java2();
        ob.solve();
        ob.report();
    }

    public void report() {
        ArrayList<String> clients = new ArrayList<String>(Arrays.asList(this.clientHistory.keySet().toArray(new String[this.clientHistory.size()])));
        Collections.sort(clients);

        for (String client : clients) {
            for (String type : this.transactionTypes) {
                if (!this.clientTransactions.get(client).containsKey(type)) continue;

                ArrayList<String> partials = new ArrayList<String>(this.clientTransactions.get(client).get(type));
                Collections.sort(partials);

                for (String partial : partials) {
                    String record = client + " |      " + type + " |      ";
                    String[] pList = partial.split(",");

                    String[] date = pList[0].split("/");
                    String dateStr = date[1] + "/" + date[2] + "/" + date[0];
                    record += dateStr + " |      ";

                    if (pList[1].equals("0")) record += "Y" + " |      ";
                    else record += "N" + " |      ";

                    record += this.fees.get(pList[2]);
                    System.out.println(record);
                }
            }
        }
    }

    public void solve() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("transactions.csv"));
            
            ArrayList<String> transaction;
            String line = br.readLine();
            while (line != null) {
                transaction = new ArrayList<String>(Arrays.asList(line.split(",")));

                String[] date = transaction.get(4).split("/");
                String dateStr = date[2] + "/" + date[1] + "/" + date[0]; // YYYY/MM/DD

                String oppType = null;
                if (transaction.get(3).equals("BUY"))
                    oppType = "SELL";
                else if (transaction.get(3).equals("SELL"))
                    oppType = "BUY";
                
                if (!this.clientHistory.containsKey(transaction.get(1))) {
                    this.clientHistory.put(transaction.get(1), new HashSet<String>());
                }

                // INTRA-DAY
                if (oppType != null && this.clientHistory.get(transaction.get(1)).contains(dateStr + transaction.get(2) + oppType)) {
                    for (String t : this.clientTransactions.get(transaction.get(1)).get(oppType)) {
                        String[] tList = t.split(",");
                        if (tList[0].equals(dateStr) && tList[3].equals(transaction.get(2))) {
                            this.fees.put(tList[2], 10);
                            break;
                        }
                    }
                    this.fees.put(transaction.get(0), 10);
                }

                // NORMAL
                else {
                    if (transaction.get(6).equals("Y")) {
                        this.fees.put(transaction.get(0), 500);
                    }
                    else {
                        if (transaction.get(3).equals("SELL") || transaction.get(3).equals("WITHDRAW")) {
                            this.fees.put(transaction.get(0), 100);
                        }
                        else {
                            this.fees.put(transaction.get(0), 50);
                        }
                    }
                }

                HashMap<String, HashSet<String>> clientCurValue;
                if (this.clientTransactions.containsKey(transaction.get(1))) {
                    clientCurValue = this.clientTransactions.get(transaction.get(1));
                }
                else {
                    clientCurValue = new HashMap<String, HashSet<String>>();
                }
                
                String priority;
                if (transaction.get(6).equals("Y")) priority = "0"; // so it stays higher in report
                else priority = "1";

                String partial = dateStr + "," + priority + "," + transaction.get(0) + "," +transaction.get(2) + "," +transaction.get(5);
                if (clientCurValue.containsKey(transaction.get(3))) {
                    clientCurValue.get(transaction.get(3)).add(partial);
                }
                else {
                    clientCurValue.put(transaction.get(3), new HashSet<String>());
                    clientCurValue.get(transaction.get(3)).add(partial);
                }

                this.clientHistory.get(transaction.get(1)).add(dateStr + transaction.get(2) + transaction.get(3));
                this.clientTransactions.put(transaction.get(1), clientCurValue);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}