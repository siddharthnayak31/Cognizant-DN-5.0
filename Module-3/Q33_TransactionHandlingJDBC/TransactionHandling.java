package Q33_TransactionHandlingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionHandling {

    public static void transfer(
            int fromAccount,
            int toAccount,
            double amount) {

        String url =
                "jdbc:mysql://localhost:3306/bankdb";

        String user = "root";
        String password = "root";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url, user, password);

            con.setAutoCommit(false);

            PreparedStatement debit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance = balance - ? WHERE id = ?");

            debit.setDouble(1, amount);
            debit.setInt(2, fromAccount);

            PreparedStatement credit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance = balance + ? WHERE id = ?");

            credit.setDouble(1, amount);
            credit.setInt(2, toAccount);

            debit.executeUpdate();
            credit.executeUpdate();

            con.commit();

            System.out.println("Transaction Successful");

            con.close();

        } catch (Exception e) {
            System.out.println("Transaction Failed");
        }
    }

    public static void main(String[] args) {

        transfer(1, 2, 500);
    }
}