package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Melody
 * @date 2022/11/3 9:08
 */
public class MethodInvoke extends MethodBase {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }

    int divide() {
        return 4 / 2;
    }

    public void getMethodTest() {
        try {
            Method method = this.getClass().getMethod("sayHello");
            System.out.println(method.getName());
            System.out.println(method.getAnnotatedReturnType());
            method.invoke(this);
            Method[] methods = this.getClass().getMethods();
            Method[] methods1 = this.getClass().getDeclaredMethods();
            Method method1 = this.getClass().getMethod("summary");
            method1.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MethodInvoke test = new MethodInvoke();
        test.getMethodTest();
    }

}
