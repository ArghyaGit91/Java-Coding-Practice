package static_practice;

public class ChildStatic extends ParentStatic{
    public static void show(){
        System.out.println("Child.show()");
    }

    public void print(){
        System.out.println("Child.print() non-static");
    }
}
