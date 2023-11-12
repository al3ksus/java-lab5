package org.example;

import org.example.model.MyClass;
import org.example.reflection.Injector;

public class Main {
    public static void main(String[] args) {
        try {
            MyClass myClass1 = (MyClass) (new Injector()).inject(new MyClass());
            myClass1.foo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}