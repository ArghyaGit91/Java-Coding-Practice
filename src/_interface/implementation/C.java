package _interface.implementation;

import _interface.default_practice.A;
import _interface.default_practice.B;

public class C implements A, B {
    @Override
    public void show() {
        A.super.show();
        System.out.println("C is showing");
    }


}
