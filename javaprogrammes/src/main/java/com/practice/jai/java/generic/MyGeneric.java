package com.practice.jai.java.generic;

/* bounded type generic class*/
public class MyGeneric <T extends Runnable & Comparable>
{
    T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}
