package org.example.model;

import org.example.annotation.AutoInjectable;

public class MyClass {
    @AutoInjectable
    private FirstInterface field1;

    @AutoInjectable
    private SecondInterface field2;

    /**
     * demonstrates that the class fields are initialized
     */
    public void foo() {
        field1.move();
        field2.talk();
    }
}
