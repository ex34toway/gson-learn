package com.demo.javaenum;

/**
 * Created by liliang on 2017/6/29.
 */
public enum ExtendedOperation implements Operation{
    EXP("^"){
        @Override
        public double apply(double x, double y) {
            return Math.pow(x,y);
        }
    },REMAINDER("%"){
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String op;

    ExtendedOperation(String op){
        this.op = op;
    }

    @Override
    public String toString() {
        return op;
    }
}
