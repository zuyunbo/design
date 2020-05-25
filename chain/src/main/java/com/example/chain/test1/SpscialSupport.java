package com.example.chain.test1;

public class SpscialSupport extends Support {

    private int number;

    public SpscialSupport(String name,int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
