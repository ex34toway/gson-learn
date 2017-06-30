package com.demo.javaenum;

import org.junit.Test;

/**
 * Created by liliang on 2017/6/29.
 */
public class EnumOperationTest {

    @Test
    public void testBase()
    {
        testOp(10D,20D);
    }

    private static void testOp(double x,double y){
        for(BasicOperation operation : BasicOperation.values()){
            System.out.printf("%f %s %f = %f \n",x,operation,y,operation.apply(x,y));
        }
        for(ExtendedOperation operation : ExtendedOperation.values()){
            System.out.printf("%f %s %f = %f \n",x,operation,y,operation.apply(x,y));
        }
    }
}
