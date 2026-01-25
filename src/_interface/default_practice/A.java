package _interface.default_practice;

public interface A {
    default void show(){
        System.out.println("A Default is showing");
    }

    default void testShow(){
        System.out.println("A Default is TestShowing");
    }
}
