public class ATMTransactions {
    private String firstName;
    private String lastName;
    private double balance;
    private String membership;
    private static int accountCount = 0;


    public ATMTransactions(String firstName, String lastName, double balance, String membership){
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.membership = membership;
        accountCount++;
    }
    public ATMTransactions(String firstName, String lastName, double balance){
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        membership = "";
        accountCount++;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public String getMembership(){
        return membership;
    }
    public void setMembership(String membership){
        this.membership = membership;
    }

    public static int banksCount(){
        return accountCount;
    }

    //1 Brain Method, withdrawling money from bank account
    public void withdrawal(double amountW){
        if(membership.equalsIgnoreCase("gold") && amountW > 0 && amountW <= balance)
            System.out.println(firstName + "s new bank balance: $" + (balance = balance - amountW)) ;
        else if(membership.equalsIgnoreCase("silver") && amountW > 0 && amountW <= balance)
            System.out.println(firstName + "s new bank balance: $" + (balance = balance - (amountW + 1)));
        else if(membership.equalsIgnoreCase("bronze") && amountW > 0 && amountW <= balance)
            System.out.println(firstName + "s new bank balance: $" + (balance = balance-(amountW + 2)));
        else if(membership.equalsIgnoreCase(""))
            System.out.println(firstName + "s new bank balance: $" + (balance = balance - (amountW+5)));
        else
            System.out.println("Sorry Invalid withdrawal Amount");
    }

    //Brain Method 2, depositing money to bank account
    public void deposit(double amountD){
        if(membership.equalsIgnoreCase("gold") && amountD > 0)
            System.out.println(firstName + "s new bank balance: $" + (balance = balance + amountD)) ;
        else if(membership.equalsIgnoreCase("silver") && amountD > 0)
            System.out.println(firstName + "s new bank balance: $" + (balance = balance + (amountD - 1)));
        else if(membership.equalsIgnoreCase("bronze") && amountD > 0)
            System.out.println(firstName + "s new bank balance: $" + (balance = balance+(amountD - 2)));
        else if(membership.equalsIgnoreCase(""))
            System.out.println(firstName + "s new bank balance: $" + (balance = balance + (amountD-5)));
        else
            System.out.println("Sorry invalid deposit amount");
    }

    public String toString(){
        return "Your Name is: " + firstName + " " + lastName + "\n"+
                "Your balance is: " + balance + "\n" +
                "Your membership is: " + membership;
    }
}