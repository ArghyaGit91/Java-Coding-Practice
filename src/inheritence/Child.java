package inheritence;

public class Child extends Parent {
    int x = 10;
    public Child(){}

    @Override
    public void show(){
        System.out.println("Child Show x = "+x);
    }
}
