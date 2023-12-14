import java.util.Scanner;
public class ATMTransactionsDriver {
    public static void main(String[] args) {
        ATMTransactions bank1 = new ATMTransactions("Samuel", "Jimenez", 430, "Gold");
        ATMTransactions bank2 = new ATMTransactions("Yair", "Gutierrez", 760);
        ATMTransactions bank3 = new ATMTransactions("Andrew", "Duran", 1000, "bronze");

        System.out.println(bank1.toString());
        System.out.println();
        System.out.println(bank2.toString());
        System.out.println();
        System.out.println(bank3.toString());
        System.out.println();


        Scanner scan = new Scanner(System.in);
        String rerun;

        do{
            System.out.print("Enter 'd' if you want to deposit, Enter 'w' if you want to withdrawal, Enter 't' if you want to transfer from your account to anothers: ");
            String transaction = scan.nextLine();


            if(transaction.substring(0,1).equals("d") || transaction.substring(0,1).equals("D")) {
                System.out.print("Enter the amount you want to deposit into your account : $");
                double depositInput = scan.nextDouble();
                scan.nextLine(); //This extra nextLine(), consumes the empty line and goes to the nextLine which actually has input
                bank1.deposit(depositInput);


            }//Deposit conditional section closed
            else if(transaction.charAt(0) == 'W' || transaction.charAt(0) == 'w'){
                System.out.print("Enter the amount you want to withdrawal from your account : $");
                double withdrawalInput = scan.nextDouble();
                scan.nextLine(); //This extra nextLine(), consumes the empty line and goes to the nextLine which actually has input
                bank1.withdrawal(withdrawalInput);


            }//Withdrawal conditional section closed
            else if(transaction.charAt(0) == 'T' || transaction.charAt(0) == 't'){
                System.out.print("What account would you like to transfer to? Type '1' if you wanna transfer to " + bank2.getFirstName() + " or if you wanna transfer to " + bank3.getFirstName()+ " type '2': ");
                int transferNum = scan.nextInt();
                scan.nextLine();

                if(transferNum == 1) {
                    //
                    System.out.print("Enter the amount you want to transfer from your account to " + bank2.getFirstName() + ": $");
                    double transferAmount = scan.nextDouble();
                    scan.nextLine();

                    // Check if the transfer amount is less than or equal to the balance in Account1
                    if(transferAmount <= bank1.getBalance()) {
                        // Perform the transfer
                        bank1.withdrawal(transferAmount);
                        bank2.deposit(transferAmount);
                        System.out.println("Transfer successful!");
                    }else{
                        System.out.println("Insufficient funds in Account1. Transfer failed.");
                    }
                }//Transfer to account 2 conditional closed
                else if(transferNum == 2) {
                    System.out.print("Enter the amount you want to transfer from your account to " + bank3.getFirstName() + ": $");
                    double transferAmount = scan.nextDouble();
                    scan.nextLine();
                    // Check if the transfer amount is less than or equal to the balance in Account1
                    if (transferAmount <= bank1.getBalance()) {
                        // Perform the transfer
                        bank1.withdrawal(transferAmount);
                        bank3.deposit(transferAmount);

                        System.out.println("Transfer successful!");
                    }else{
                        System.out.println("Insufficient funds in Account1. Transfer failed.");
                    }
                }//Transfer to account 3 conditional closed
                else{
                    System.out.println("Invalid input type '1' or '2'");
                }
            }//Transaction conditional section closed
            else{
                System.out.println("Invalid transaction type. Please only enter 'W' or 'D' thank you.");
            }
            System.out.print("Would you like to make an additional transaction(Y/N): ");
            rerun = scan.nextLine();
        }while(rerun.substring(0,1).equalsIgnoreCase("Y"));

    }
}