import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        DynamicProxy dp = new DynamicProxy();
        dp.testDynamicProxy();
    }

    public void testDynamicProxy() {
        UserServiceImpl target = new UserServiceImpl();

        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("---before---");
                        Object result = method.invoke(target, args);
                        System.out.println("---after---");
                        return result;
                    }
                }
        );

        proxy.getName();
    }
}

interface UserService {
    String getName();
}

class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        System.out.println("name");
        return "name";
    }
}
