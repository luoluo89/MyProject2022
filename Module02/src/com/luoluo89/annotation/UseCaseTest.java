package com.luoluo89.annotation;

public class UseCaseTest {

    @UseCase(id = 111, description = "Test1")
    public boolean Test1() {
        return true;
    }

    @UseCase(id = 222, description = "Test2")
    public boolean Test2() {
        return true;
    }

    @UseCase(id = 333, description = "Test3")
    public boolean Test3() {
        return true;
    }
}
