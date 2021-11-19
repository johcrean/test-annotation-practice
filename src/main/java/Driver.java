import assertions.Assertion;
import org.bouncycastle.util.test.Test;
import reflector.MethodInspector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class Driver {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        //MethodInspector.invokeMethods(TestModel.class);

        for(Method m: MethodInspector.getTestMethods(TestModel.class)){
            m.invoke(TestModel.class);
        }



    }
}
