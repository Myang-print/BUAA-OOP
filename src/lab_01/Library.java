

public class Library {
    private static final int DEFAULT_LIBRARY_CAPACITY = 5;

    private Book[] books = new Book[DEFAULT_LIBRARY_CAPACITY];
    private int size = 0;

    public boolean addBook(Book book) {
        if (book == null
                || size == books.length
                || findBook(book.getId()) != null) {       // Question 4.3
            //  System.out.println("Add book failed:" + book.getId() + "-" + book.getTitle());      // Test 4.3
            return false;
        }
        books[size] = book;
        size++;
        return true;
    }

    // ============== Question 4.2 ===============
    public Book findBook(String id) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equals(id)) {      // Java 比较字符串是否相等可以使用 boolean String1.equals(String2)
                return books[i];
            }
        }
        return null;
    }
    // ============================================


    // ============== Question 4.4 ===============
    public void printAll() {
        for (int i = 0; i < size; i++) {
            String status = books[i].isAvailable() ? "Available" : "Check out";
            System.out.println(books[i].getId() +
                    " | " + books[i].getTitle() +
                    " | " + status +
                    " | Borower: " + books[i].getBorrowerName());
        }
    }
    // ============================================
}