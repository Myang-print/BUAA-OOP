public class Book {
    private String id;
    private String title;

    // private boolean available = true;
    private Student borrower = null;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // ============ Question 1.2 ==============
    public String getId() {
        return id;
    }
    // ========================================

    // public boolean isAvailable() {
    //     return available;
    // }
    public boolean isAvailable() {
        return borrower == null;
    }

    // ============ Question 2.2 ==============
    //    public boolean borrow() {
    //        if (!isAvailable()) return false;
    //        available = false;
    //        return true;
    //    }
    // ========================================

    // ============ Question 2.3 ==============
    //    public boolean giveBack() {
    //        if (isAvailable()) return false;
    //        available = true;
    //        return true;
    //    }
    // ========================================

    public boolean borrow(Student student) {
        if (student == null || !isAvailable()) {
            return false;
        }
        borrower = student;
        return true;
    }

    public boolean giveBack(Student student) {
        if (student == null || borrower != student) {
            return false;
        }
        borrower = null;
        return true;
    }

    // ============ Question 2.3 ==============
    public String getBorrowerName() {
        if (isAvailable()) {
            return null;
        }
        return borrower.getName();
    }
    // ========================================
}