package _abstract;

public abstract class AbstractPractice {
    private int count = 0;
    private AbstractPractice() { }            // allowed (but then subclass must call another constructor)
    protected AbstractPractice(int c) { this.count = c; }
    public static void hi() { System.out.println("hi"); }
    public final void printCount() { System.out.println(count); }
    private void helper() { System.out.println("helper"); } // allowed, not overridable
    public abstract void work();



}
