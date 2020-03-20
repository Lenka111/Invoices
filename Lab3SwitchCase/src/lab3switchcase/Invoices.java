
package lab3switchcase;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Elena Voinu
 */
public class Invoices {

    public static void main(String[] args) {

    // the variables
    int invNum = 0;
    int numItems = 0;
    double itemPrice = 0.0, shipCharge = 0.0, totAmt = 0.0;
    double discount = 0.02, subTotal = 0.0;
    char shipMethod = '\0';
    String invDate = "", carier = "";
    boolean check = false;
    Scanner sc = new Scanner(System.in);
    
    // obtain today's date
    Date date = new Date();
    
    
    // display time and date using toString()
    System.out.println(date.toString());
    
    // the program header
    System.out.println("[ Invoice Processing ]");
    System.out.println("----------------------\n");
    System.out.println("Today's Date is: " + date + "\n");
        
    // prompt user for data and receive data
    System.out.println("please enter the invoice number");
    invNum = sc.nextInt();
    System.out.println("the invoice number is: " + invNum);
    System.out.println("please enter the invoice date");
    invDate = sc.next();
    System.out.println("the invoice date is: " + invDate);
    System.out.println("please enter the number of items purchased");
    numItems = sc.nextInt();
    System.out.println("the number of items is: " + numItems);
    
    // determine the per item price
    if (numItems > 0 && numItems <= 10)
      itemPrice = 0.75;
    else if (numItems > 10 && numItems <= 50)
      itemPrice = 0.65;
    else
      itemPrice = 0.62;
    System.out.printf("the per item price is: $%.2f\n", itemPrice);
    
    // determine the shipping method
    System.out.println("Enter shipping method (A for UPS%\n , B for Federal Express, C for United Parcel Services"
            + ", or D for DHL)");
    shipMethod = sc.next().charAt(0);
    
    
    // determine the shipping charge
    switch(shipMethod) {
      case 'A': case 'a': shipCharge = 5.00; break;
      case 'B': case 'b': shipCharge = 7.20; break;
      case 'C': case 'c': shipCharge = 10.00; break;
      case 'D': case 'd': shipCharge = 0.0; break;
      default:  shipCharge = 20.00;
    }
      
    if(shipMethod == 'A'|| shipMethod =='a') {
        carier = "UPS"; 
    }
    else if (shipMethod == 'B' || shipMethod == 'b') {
         carier = "Federal Express";    
    }
    else if (shipMethod == 'C' || shipMethod == 'c') {
        carier = "United Parcel Service";
    }
    else if (shipMethod == 'D' || shipMethod == 'd') {
        carier = "DHL";
    }
    else 
    {
        System.out.println("Invalid selection");
        carier = "undefined";
    }
            
    System.out.printf("The shipping method is: " + carier + "," + 
            " the shipping charge is: $%.2f\n" , shipCharge); 
    
    // determine the days from invoice date to today's date
    System.out.println("is discount period valid? true or false");
    check = sc.nextBoolean();
    if (check == true) 
    {
      check = true;
    }
    else
    {
      check = false;
    }
    System.out.println("discount valid? " + check);
    // determine and display the total invoice amount
    subTotal = numItems * itemPrice;
    if(check == true)
      totAmt = subTotal * (1 - discount) + shipCharge;
    else
      totAmt = subTotal + shipCharge;
    System.out.printf("(total invoice amount due) $%.2f\n",totAmt);
    
    // the program footer
    System.out.println(" ");
    System.out.println("thank you!");
    System.out.println("---------------------");



    }
    
}
