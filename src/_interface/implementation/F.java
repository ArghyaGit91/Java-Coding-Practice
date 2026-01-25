package _interface.implementation;

import _interface.default_practice.A;

public class F extends E implements A {

//    @Override
//    public void testShow() {
//        A.super.show();   // explicitly call interface default method
//    }

    public static void main(String[] args) {
        A a = new F();
        a.testShow();

    }
}
