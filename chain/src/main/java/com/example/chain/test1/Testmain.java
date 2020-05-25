package com.example.chain.test1;

public class Testmain {

    public static void main(String[] args) {
        Support alice   = new NoSupport("Alice");
        Support bob     = new LimitSupport("Bob", 100);
        Support charlie = new SpscialSupport("Charlie", 429);
        Support diana   = new LimitSupport("Diana", 200);
        Support elmo    = new OddSupport("Elmo");
        Support fred    = new LimitSupport("Fred", 300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        for(int i=0;i<500;i+=33) {
            alice.support(new Trouble(i));
        }
    }
}
