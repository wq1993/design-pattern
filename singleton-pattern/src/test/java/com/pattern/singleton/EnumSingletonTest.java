package com.pattern.singleton;

import com.pattern.singleton.register.EnumSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Created by wq on 2019/3/17
 */
public class EnumSingletonTest {

    public static void main(String[] args) {
        try {
            Class<EnumSingleton> clazz = EnumSingleton.class;
            Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            // JDK底层规避了通过反射和序列化破坏单例的风险
            // java.lang.reflect.Constructor#newInstance
            EnumSingleton singleton = constructor.newInstance("wq", 666);
            System.out.println(singleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        EnumSingleton e1 = null;
//        EnumSingleton e2 = EnumSingleton.getInstance();
//        e2.setData("EnumSingleton");
//
//        try {
//            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(e2);
//            oos.flush();
//            oos.close();
//
//            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//
//            e1 = (EnumSingleton) ois.readObject();
//            ois.close();
//
//            System.out.println(e1.getData());
//            System.out.println(e1.getData() == e2.getData());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
