package com.pattern.singleton;

import com.pattern.singleton.lazy.InnerClassLazySingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wq on 2019/3/17
 */
public class InnerClassLazySingletonTest {

    public static void main(String[] args) {
        try {
            Class<InnerClassLazySingleton> clazz = InnerClassLazySingleton.class;
            Constructor<InnerClassLazySingleton> constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            InnerClassLazySingleton singleton = constructor.newInstance();

            InnerClassLazySingleton instance = InnerClassLazySingleton.getInstance();
            System.out.println(singleton == instance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
