package _interface;

import _interface.default_practice.A;
import _interface.default_practice.B;
import _interface.implementation.C;
import _interface.implementation.D;

public class TestInterface {
    public static void main(String[] args){
        A a = new C();
        a.show();

        B b = new D();
        b.show();
    }
}
