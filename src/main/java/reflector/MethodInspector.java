package reflector;
import annotations.markTest;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MethodInspector {

    public static void inspectMethods(Class<?> clazz){
        getTestMethods(clazz);
    }

    public static List<Method> getTestMethods(Class<?> clazz){
        //System.out.println("Test methods of: " + clazz.getSimpleName());

        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods).filter(method -> method.isAnnotationPresent(markTest.class)).collect(Collectors.toList());
    }

    public static Object getInstance(Class<?> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return Objects.requireNonNull(Arrays.stream(clazz.getDeclaredConstructors())
                .filter(constructor -> constructor.getParameterCount() == 0)
                .findFirst().orElse(null).newInstance());
    }

    public static void invokeMethods(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        for(Method method:getTestMethods(clazz)){
            Object o = getInstance(clazz);
            method.invoke(o);

        }
    }

    public static void getParameters(Class<?> clazz){
        Parameter[] parameters = null;
        for(Method method:getTestMethods(clazz)){
            parameters = method.getParameters();
        }

        for(Parameter parameter: parameters){
            System.out.println(parameter.getName());
            System.out.println(parameter.getType());
        }
    }




}
