package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Prepare insert data...");
        //proxy对象
        Object returnValue = method.invoke(target, args);
        System.out.println("success inserting data...");
        return returnValue;
    }
}
