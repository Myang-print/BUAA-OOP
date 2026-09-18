import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Task 1: Create two physical books.
        Book first = new Book("B001", "Algorithm Design and Analysis");     // Create the first Book Object
        Book second = new Book("B002", "Object-Oriented Programming Practice");     // Create the second Book Object

        // Task 3: Create only one object for each student and always reuse it afterwards.
        Student alice = new Student("10010010", "San Zhang");       // Create alice Student Object
        Student bob = new Student("10010011", "Si Li");     // Create bob Student Object
        Student currentStudent = alice;

        // Task 4: The library stores references to the books created above.
        Library library = new Library();        // Create Library Object
        library.addBook(first);     // Add the first Book to the Library
        library.addBook(second);        // Add the second Book to the Library

        System.out.println("The classroom library has launched!");
        System.out.println("Haoran Yang" + " - " + "25371490");     // Question 5.2
        System.out.println(alice.getName() + " - " + alice.getID());
        System.out.println(bob.getName() + " - " + bob.getID());

        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Current student: " + currentStudent.getName()
                    + " - " + currentStudent.getID());
            System.out.println("1 View books | 2 Borrow book | 3 Return book | 4 Switch student | 0 Exit");
            if (!in.hasNextLine()) {
                break;
            }
            String command = in.nextLine().trim();
            switch (command) {
                case "1":       // View all books
                    library.printAll();
                    break;
                case "2": {     // Borrow a book with its ID
                    System.out.println("Please enter the book ID:");
                    if (!in.hasNextLine()) {
                        running = false;
                        break;
                    }
                    String id = in.nextLine().trim();
                    Book book = library.findBook(id);
                    if (book == null) {
                        System.out.println("Book not found");
                    } else if (book.borrow(currentStudent)) {
                        System.out.println("Book borrowed successfully");
                    } else {
                        System.out.println("Borrowing failed: the book has already been borrowed");
                    }
                    break;
                }
                case "3": {         // Return a book with its ID
                    System.out.println("Please enter the book ID:");
                    if (!in.hasNextLine()) {
                        running = false;
                        break;
                    }
                    String id = in.nextLine().trim();
                    Book book = library.findBook(id);
                    if (book == null) {
                        System.out.println("Book not found");
                    } else if (book.giveBack(currentStudent)) {
                        System.out.println("Book returned successfully");
                    } else {
                        System.out.println("Returning failed: the current student did not borrow this book");
                    }
                    break;
                }
                case "4":       // Switch current student
                    if (currentStudent == alice) {
                        currentStudent = bob;
                    } else {
                        currentStudent = alice;
                    }
                    System.out.println("Switched to: " + currentStudent.getName());
                    break;
                case "0":       // Exit the program
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a number from the menu");
            }
        }
        System.out.println("----- Good Bye! -----");
        in.close();
    }
}

/*
public class Main {
    public static void main(String[] args) {
        System.out.println("The classroom library has launched!");

        // ============== Question 1.1 ================
        //        System.out.println("id = " + "25371490");
        //        System.out.println("name = " + "Haoran Yang");
        // ============================================

        // ============== Question 1.2 ================
        Book first = new Book("B001", "Algorithm Design and Analysis");
        Book second = new Book("B002", "Object-Oriented Practices");
        // Book book2 = first;
        // System.out.println(first == book2);          // true
        // System.out.println(book2.getTitle());        // Algorithm Design and Analysis
        // ============================================

        // ============== Question 2.1 ================
        //        System.out.println(first.isAvailable());        // true
        // ============================================

        //        System.out.println(first.borrow());       // true
        //        System.out.println(first.borrow());       // false：不能重复借出
        //        System.out.println(first.isAvailable());  // false：仍处于借出状态
        //        System.out.println(first.giveBack());     // true
        //        System.out.println(first.giveBack());     // false：不能重复归还
        //        System.out.println(first.isAvailable());  // true

        // ============== Question 3.1 ================
        Student alice = new Student("10010010", "San Zhang");
        Student bob = new Student("10010011", "Si Li");
        // ============================================

        //        System.out.println(first.borrow(alice));    // true
        //        System.out.println(first.borrow(bob));      // false
        //        System.out.println(first.giveBack(bob));    // false
        //        System.out.println(first.isAvailable());    // false：失败不能改变状态
        //        System.out.println(first.giveBack(alice));   // true
        //        System.out.println(first.isAvailable());    // true

        // ============== Question 4.1 ===============
        Library library = new Library();
        library.addBook(first);
        library.addBook(second);
        library.addBook(new Book("B001", "Another Algorithm Book"));        // Test 4.3 false
        // ============================================

        // ================ Test 4.2 ==================
        //        System.out.println(library.findBook("B001") == first);      // true：同一个对象
        //        System.out.println(library.findBook("B999") == null);       // true
        // ============================================

        // ================ Test 4.4 ==================
        library.printAll();
        // ============================================
    }
}*/
