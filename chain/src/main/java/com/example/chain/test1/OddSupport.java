package com.example.chain.test1;

public class OddSupport extends Support{
    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 ==1;
    }

    public OddSupport(String name) {
        super(name);
    }
}
