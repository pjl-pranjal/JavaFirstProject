public class App {
    public static void main(String[] args) {
        try {
            DAO dao = new DAO();
            dao.readData("transactions.csv", "csv");

            BO bo = new BO();
            bo.processFees(dao.getTransactions());

            dao.getReport("feeReport.csv");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}