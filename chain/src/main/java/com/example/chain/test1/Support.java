package com.example.chain.test1;

public abstract class Support {

    private String name;

    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble){
        if(resolve(trouble)){
            done(trouble);
        }else if (next != null){
            next.support(trouble);
        }else {
            fail(trouble);
        }
    }

    @Override
    public String toString() {              // 显示字符串
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {  // 未解决
        System.out.println(trouble + " cannot be resolved.");
    }

}
