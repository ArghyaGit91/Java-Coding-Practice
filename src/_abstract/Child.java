package _abstract;

public class Child extends Parent{

    public void action() {
        System.out.println("Child action Without Override Annotation");
    }

    @Override
    public void greet(){
        System.out.println("Child greet With Override Annotation");
    }
}
