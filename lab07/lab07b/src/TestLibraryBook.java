import java.util.Scanner;
/**
 * Tests LibraryBook
 * @author Munib Emre Sevilgen
 * @version 1.00 2017-11-28
 */ 

public class TestLibraryBook
{ 
   public static void main (String[] args)
   {
      // constants
      
      // variables
      String title;
      String author;
      String dueDate;
      int selection;
      LibraryBook testBook;
      Scanner scan;
      // program code
      scan = new Scanner( System.in);
      
      // Initilize the book title, authors name and create LibraryBook object
      title = "Tutunamayanlar";
      author = "Oguz Atay";
      dueDate = "";
      testBook = new LibraryBook( title , author );
      do {
         // Get the selection
         System.out.print("Please enter what you want to do:(Loan: 1, " +
                             "Return: 2, Status: 3, Times Loaned: 4, " + 
                             "Print everything: 5, Exit: 0) ");
         selection = scan.nextInt();
         // For loan selection
         if ( selection == 1) {
            if ( testBook.onLoan() ) {
               System.out.print( "Please enter the due date: ");
               dueDate = scan.next();
            }
            
            if (testBook.loanBook( dueDate )) {
               System.out.println( "You loaned the book successfully.");
            }
            else {
               System.out.println( "Sorry, the book is not available.");
            }
         }
         // For return selection
         else if ( selection == 2 ) {
            if (testBook.returnBook()) {
               System.out.println( "You returned the book successfully.");
            }
            else {
               System.out.println( "You cannot return the book because book is free.");
            }
         }
         // For see status selection
         else if ( selection == 3 ) {
            if ( testBook.onLoan() ) {
               System.out.println( "It's free");
            }
            else {
               System.out.println( "It's loaned");
            }
         }
         // For get times loaned selection
         else if ( selection == 4) {
            System.out.println( "Times Loaned: " + testBook.getTimesLoaned());
         }
         // For print selection
         else if ( selection == 5) {
            System.out.println( testBook.toString());
         }
         // Check it is a valid selection
         else if ( selection != 0 ){
            System.out.println( "Please enter a valid selection.");
         }
      } while ( selection != 0 );
   }
}