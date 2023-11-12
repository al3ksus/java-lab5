package org.example;

import org.example.model.MyClass;
import org.example.reflection.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InjectorTest {

    @Test
    void injectTest() throws Exception {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = (new Injector()).inject(new MyClass());
        Assertions.assertThrows(NullPointerException.class, myClass1::foo);
        Assertions.assertDoesNotThrow(myClass2::foo);
    }
}
