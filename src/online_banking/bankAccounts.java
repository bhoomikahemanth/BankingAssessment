package online_banking;

import java.util.Scanner;

// sub class with in same package
// contains Account Types
// Operations on Account Types
public class bankAccounts
{

    Scanner myScanner = new Scanner(System.in);

    // initializing all 3 account types balances
    private double cAccBal = 1000;
    private double sAccBal = 2000;
    private double jAccBal = 3000;

    void withdraw()
    {
        System.out.println("Please enter account type from which you would like to withdraw money from ?");
        String accType = myScanner.nextLine();

        System.out.println("Enter the amount to be withdrawn ?");
        double withdrawAmt = Double.parseDouble(myScanner.nextLine());

        // valid account type
        if (accType.equalsIgnoreCase("current"))
        {
            // invalid withdrawal amount
            if (withdrawAmt > cAccBal)
                System.out.println("Insufficient funds!! Please Deposit to Withdraw.");
                // valid withdrawal amount
            else
            {
                cAccBal = cAccBal - withdrawAmt;
                System.out.println("The Current Account Balance is " + cAccBal);
            }
        }
        // valid account type
        else if (accType.equalsIgnoreCase("savings"))
        {
            // invalid withdrawal amount
            if (withdrawAmt > sAccBal)
                System.out.println("Insufficient funds!! Please Deposit to Withdraw.");
                // valid withdrawal amount
            else
            {
                sAccBal = sAccBal - withdrawAmt;
                System.out.println("The Savings Account Balance is " + sAccBal);
            }
        }
        // valid account type
        else if (accType.equalsIgnoreCase("joint"))
        {
            // invalid withdrawal amount
            if (withdrawAmt > jAccBal)
                System.out.println("Insufficient funds!! Please Deposit to Withdraw.");
                // valid withdrawal amount
            else
            {
                jAccBal = jAccBal - withdrawAmt;
                System.out.println("The Joint Account Balance is " + jAccBal);
            }
        }
        // invalid account type
        else
        {
            System.out.println("Invalid Account Type.");
            System.out.println("Please try again.");
            // to enter valid account types
            withdraw();
        }
    }
    // deposit amount

    void deposit()
    {
        System.out.println("Please enter which account type to  which you would like to deposit the amount ?");
        String accType = myScanner.nextLine();

        System.out.println("Enter the amount to be deposited.");
        double depAmt = Double.parseDouble(myScanner.nextLine());

        // checks for invalid deposit amount
        if (depAmt <= 0)
        {
            System.out.println("Please enter a correct amount to deposit.");
            // enter valid deposit amount
            deposit();
        }
        // valid amount
        else
        {
            // valid account type
            if(accType.equalsIgnoreCase("current"))
            {
                cAccBal = cAccBal + depAmt;
                System.out.println("The Current Account Balance is : " + cAccBal);
            }
            // valid account type
            else if(accType.equalsIgnoreCase("savings"))
            {
                sAccBal = sAccBal + depAmt;
                System.out.println("The Savings Account Balance is : " + sAccBal);
            }
            // valid account type
            else if(accType.equalsIgnoreCase("joint"))
            {
                jAccBal = jAccBal + depAmt;
                System.out.println("The Joint Account Balance is : " + jAccBal);
            }
            // invalid account type
            else
            {
                System.out.println("Invalid Account Type.");
                System.out.println("Please try again.");
                // enter valid account type
                deposit();
            }

        }
    }
    // withdraw amount

    // transfer amount
    void transfer()
    {
        System.out.println("Enter the account type you wish to transfer from ?");
        String srcAccType = myScanner.nextLine();

        System.out.println("Enter the account type you wish to transfer to ?");
        String destAccType = myScanner.nextLine();

        System.out.println("How much would you like to transfer?");
        double transAmt = Double.parseDouble(myScanner.nextLine());

        // Current to Savings account
        if (srcAccType.equalsIgnoreCase("current") && destAccType.equalsIgnoreCase("savings"))
        {
                // sufficient current account balance
                if (cAccBal >= transAmt)
                {
                    cAccBal = cAccBal - transAmt;
                    System.out.println("Current Account Balance is : " + cAccBal);

                    sAccBal = sAccBal + transAmt;
                    System.out.println("Savings Account Balance is : " + sAccBal);
                }
                // insufficient current account balance
                else
                {
                    System.out.println("Insufficient funds in Current Account.");
                    System.out.println("Please deposit amount to current account & try again.");
                    deposit();
                }
        }
        // Current to Joint account
        else if (srcAccType.equalsIgnoreCase("current") && destAccType.equalsIgnoreCase("joint"))
        {
            // sufficient current account balance
            if (cAccBal >= transAmt)
            {
                cAccBal = cAccBal - transAmt;
                System.out.println("Current Account Balance is : " + cAccBal);

                jAccBal = jAccBal + transAmt;
                System.out.println("Joint Account Balance is : " + jAccBal);
            }
            // insufficient current account balance
            else
            {
                System.out.println("Insufficient funds in Current Account.");
                System.out.println("Please deposit amount to current account & try again.");
                deposit();
            }
        }
        // Savings to Current
        else if (srcAccType.equalsIgnoreCase("savings") && destAccType.equalsIgnoreCase("current"))
        {
            // sufficient savings account balance
            if (sAccBal >= transAmt)
            {
                sAccBal = sAccBal - transAmt;
                System.out.println("Savings Account Balance is : " + sAccBal);

                cAccBal = cAccBal + transAmt;
                System.out.println("Current Account Balance is : " + cAccBal);
            }
            // insufficient savings account balance
            else
            {
                System.out.println("Insufficient funds in Savings Account.");
                System.out.println("Please deposit amount to savings account & try again. ");
                deposit();
            }
        }
        // Savings to Joint
        else if (srcAccType.equalsIgnoreCase("savings") && destAccType.equalsIgnoreCase("joint"))
        {
            // sufficient savings account balance
            if (sAccBal >= transAmt)
            {
                sAccBal = sAccBal - transAmt;
                System.out.println("Savings Account Balance is : " + sAccBal);

                jAccBal = jAccBal + transAmt;
                System.out.println("Joint Account Balance is : " + jAccBal);
            }
            // insufficient savings account balance
            else
            {
                System.out.println("Insufficient funds in Savings Account.");
                System.out.println("Please deposit amount to savings account & try again.");
                deposit();
            }
        }
        // Joint to Current
        else if (srcAccType.equalsIgnoreCase("joint") && destAccType.equalsIgnoreCase("current"))
        {
            // sufficient joint account balance
            if (jAccBal >= transAmt)
            {
                jAccBal = jAccBal - transAmt;
                System.out.println("Joint Account Balance is : " + jAccBal);

                cAccBal = cAccBal + transAmt;
                System.out.println("Current Account Balance is : " + cAccBal);
            }
            // insufficient joint account balance
            else
            {
                System.out.println("Insufficient funds in Joint Account.");
                System.out.println("Please deposit amount to joint account & try again.");
                deposit();
            }
        }
        // Joint to Savings
        else if (srcAccType.equalsIgnoreCase("joint") && destAccType.equalsIgnoreCase("savings"))
        {
            // sufficient joint account balance
            if (jAccBal >= transAmt)
            {
                jAccBal = jAccBal - transAmt;
                System.out.println("Joint Account Balance is : " + jAccBal);

                sAccBal = sAccBal + transAmt;
                System.out.println("Savings Account Balance is : " + sAccBal);
            }
            // insufficient joint account balance
            else
            {
                System.out.println("Insufficient funds in Joint Account.");
                System.out.println("Please deposit amount to joint account & try again.");
                deposit();
            }
        }
        // invalid account types
        else
        {
                System.out.println("Invalid Account Types.");
                System.out.println("So, Please try again.");
                // to enter valid src & dest account types
                transfer();
        }
    }

    void checkBalance()
    {
        System.out.println("Please enter which account type would you like to check the balance of ?");
        String accountType = myScanner.nextLine();

        if(accountType.equalsIgnoreCase("Current")){
            System.out.println("Your Current Account Balance is: " + cAccBal);
        }

        else if(accountType.equalsIgnoreCase("Savings")){
            System.out.println("Your Savings Account Balance is: " + sAccBal);
        }

        else if(accountType.equalsIgnoreCase("Joint")){
            System.out.println("Your Joint Account Balance is: " + jAccBal);
        }
    }
}
