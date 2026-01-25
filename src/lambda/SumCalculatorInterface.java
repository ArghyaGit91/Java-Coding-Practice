package lambda;

@FunctionalInterface
public interface SumCalculatorInterface {
    int addition(int a, int b);

    default String print(){
        return "Hello I am Default method";
    }

    static void show()
    {
        System.out.println("Static Method Executed");
    }
}
