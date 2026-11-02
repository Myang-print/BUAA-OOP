class Base {
    private void hello() {
        System.out.println("base hello");
    }

    public static void main(String[] args) {
        // Question 1: the reference type is Base.
        Base b = new Child();
        b.hello();

        // Question 2: the reference type is Child.
        Child c = new Child();
        c.hello();
    }
}

class Child extends Base {
    // This is not an override: Base.hello() is private and is not inherited.
    public void hello() {
        System.out.println("child hello");
    }
}

public class Test {
    public static void main(String[] args) {
        Base.main(args);
    }
}
