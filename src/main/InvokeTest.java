package main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvokeTest {
    public int x;
    public static int sx;
    public  static Object addStatic(int a){
        sx = a;
        return null;
    };
    public void add(int a){
        x = a;
//        Proxy.newProxyInstance();
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        InvokeTest it = new InvokeTest();


    }
}
