package online_banking;

import java.util.Scanner;

// Main Class
// Takes user inputs
// validates log in details
// gets cx choice
// log out
public class bankMainClass
{

    Scanner myScanner = new Scanner(System.in);

    private String userName;
    private String passWord;

    // Main Program Execution begins here
    public static void main(String[] args)
    {

        // main class object creation
        // constructor invocation
        bankMainClass myCx = new bankMainClass("Bhoomika","Nagaraja");

        // bank atm name
        System.out.println("SBI Bank");

        // method call to take user input
        myCx.getCxAcc();
    }
    // command line inputs through parameterized constructors
    private bankMainClass(String username, String password)
    {
        this.userName = username;
        this.passWord = password;
    }

    private void getCxAcc()
    {
        System.out.println("Enter Account Details");

        // Input user name
        System.out.println("User ID :");
        String cxName = myScanner.nextLine();

        // Input user password
        System.out.println("Password :");
        String cxPasswd = myScanner.nextLine();

        // to verify the log in details & prints msg accordingly
        if(checkCredentials(cxName, cxPasswd))
        {
            // log in success
            System.out.println("Logged In");
            // get cx choice
            getCxChoice();
        }
        else
        {
            // log in failed
            System.out.println("Invalid user details have been entered. Please try again.");
            // try log in again
            getCxAcc();
        }
    }

    // cx entered log in must match the internal bank stored log in details
    private boolean checkCredentials(String enteredUsername, String enteredPassword)
    {
        if (enteredUsername.equals(userName) && enteredPassword.equals(passWord))
                   return true;
        else
        return false;
    }

    // get cx choice to perform operations & display corresponding msg
    private void getCxChoice()
    {

        System.out.println("Enter your choice :");

        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Transfer Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Log Out");

        int userChoice = Integer.parseInt(myScanner.nextLine());

        // bank operations & accountTypes are defined in bankAccounts class in the same package as bankMainClass
        // obj of bankAccounts class
        bankAccounts myAccOp = new bankAccounts();

        switch (userChoice)
        {
            case 1 :
                // call deposit method of bankAccounts with its obj
                myAccOp.deposit();
                // to enter next choice
                getCxChoice();
                break;
            case 2 :
                // call withdraw method of bankAccounts with its obj
                myAccOp.withdraw();
                // get next choice
                getCxChoice();
                break;
            case 3 :
                // call transfer method of bankAccounts with its obj
                myAccOp.transfer();
                // to get next choice
                getCxChoice();
                break;
            case 4 :
                // call balance method of bankAccounts with its obj
                myAccOp.checkBalance();
                // to get next choice
                getCxChoice();
                break;
            case 5 :
                System.out.println("You choose to exit.");
                // call log out
                logOut();
                break;
            default:
                // wrong choice
                System.out.println("Invalid input received.");
                System.out.println("Please Try Again.");
                // enter correct choice
                getCxChoice();
            }
    }

    // log out method
    private void logOut()
    {
        System.out.println("Logged Out");
        // to get next user input
        getCxAcc();
    }
}
