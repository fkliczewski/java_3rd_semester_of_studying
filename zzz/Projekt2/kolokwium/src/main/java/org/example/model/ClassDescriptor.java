package org.example.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassDescriptor {
    private Class <?> clazz;

    public ClassDescriptor(Class <?> clazz){
        this.clazz = clazz;
    }

    public String getFullName(){
        return "Nazwa klasy: " + clazz.getClass().getName() + ", Pakiet: " + clazz.getPackageName().toString();
    }

    public List<String> getMethodNames(){
        List <String> methodNames = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods){
            methodNames.add(m.getName());
        }

        return methodNames;
    }

    public List<String> getFieldNames(){
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = clazz.getFields();

        for(Field f : fields){
            fieldNames.add(f.getName());
        }

        return fieldNames;
    }

    public String getInfo(){

        if(!clazz.isAnnotationPresent(Info.class))
            return null;

        int i = clazz.getAnnotation(Info.class).nr();
        String fn = clazz.getAnnotation(Info.class).firstName();
        String ln = clazz.getAnnotation(Info.class).lastName();

        return "index: " + i + " first name: " + fn + " last name: " + ln;
    }
}
