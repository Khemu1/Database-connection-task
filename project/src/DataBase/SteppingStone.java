package DataBase;

import java.sql.SQLException;
import java.util.Scanner;

public class SteppingStone {
    public static void main(String[] args) throws SQLException {
        dataBase.connect();
        Scanner in = new Scanner(System.in);
        boolean work = true;
        while (work) {
            System.out.println("To Sign in, press 1");
            System.out.println("To Sign up, press 2");
            System.out.println("To exit, press 3");
            System.out.println("To print data, press 4");
            System.out.println("To update data, press 5");

            int choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter your account id and password");
                    String id = in.next();
                    String password = in.next();
                    boolean loggedIn = dataBase.login(id, password);
                    if (loggedIn) {
                        System.out.println("Logged in successfully");
                    } else {
                        System.out.println("Login failed. Please check your credentials.");
                    }
                }
                case 2 -> {
                    System.out.println("Enter your new account id and password");
                    String newId = in.next();
                    String newPassword = in.next();
                    dataBase.signUp(newId, newPassword);
                    System.out.println("Account created successfully");
                }
                case 3 -> {
                    System.out.println("Exiting");
                    work = false;
                }
                case 4 ->   {
                    dataBase.Print();
                }
                case 5 ->   {
                    System.out.println("Enter the row number: ");
                    int row = in.nextInt();

                    System.out.println("Enter the column index: ");
                    int columnIndex = in.nextInt();

                    System.out.println("Enter the new ID: ");
                    String id = in.next();

                    System.out.println("Enter the new value: ");
                    String passwrod = in.next();

                    dataBase.update(row, columnIndex, id, passwrod );

                    System.out.println("Data updated successfully");
                }
                default -> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

    }
}
