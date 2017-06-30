package com.demo.javaenum;

/**
 * Created by liliang on 2017/6/29.
 */
public enum  BasicOperation implements Operation {
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String op;

    BasicOperation(String op){
        this.op = op;
    }

    @Override
    public String toString() {
        return op;
    }
}
