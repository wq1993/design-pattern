package com.pattern.singleton;

import com.pattern.singleton.serializable.SerializableSingleton;

import java.io.*;

/**
 * Created by wq on 2019/3/17
 */
public class SerializableSingletonTest {

    public static void main(String[] args) {
        SerializableSingleton s1 = null;
        SerializableSingleton s2 = SerializableSingleton.getInstance();

        try {
            FileOutputStream fos = new FileOutputStream("SerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            // 序列化读取时，JDK底层会通过newInstance实例化一个对象
            // 再判断序列化对象是否包含"readResolve"方法
            // 如果包含，会用该方法的返回值覆盖序列化实例化出来的对象，而序列化对象会被GC回收
            s1 = (SerializableSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
