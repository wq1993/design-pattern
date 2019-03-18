### 单例模式（singleton-pattern）

#### 概念

&emsp;确保一个类在任何情况下都只有一个实例，并提供一个全局访问点。特点是构造方法私有，属于创建型模式。

#### 实现方式

1. 饿汉式单例：

   线程安全，不管单例对象是否被调用，类加载时单例对象已经被初始化，比较浪费资源。

2. 懒汉式单例：

   * 普通实现：无法规避线程安全

     ```java
     public class SimpleLazySingleton {
     	......
         public static SimpleLazySingleton getInstance() {
             if (null == singleton) {
                 // 线程1执行到此处进入等待；
                 // 线程2进来发现单例还未被实例化，也会执行到此处
                 // 无法避免线程安全问题
                 singleton = new SimpleLazySingleton();
             }
             return singleton;
         }
         ......
     }
     ```

   * 线程安全：可能导致整个类被锁定，消耗性能

     ```java
     public class SyncLazySingleton {
     	......
     	// 加上synchronized关键字，当一个线程获取到锁，进入方法时，其他线程会在外等待，直到获取锁的线程执行完该方法
         // 但是，synchronized加在方法上，锁的力度太大，性能比较低
         public synchronized static SyncLazySingleton getInstance() {
             if (null == singleton) {
                 singleton = new SyncLazySingleton();
             }
             return singleton;
         }
         ......
     }
     ```

   * 双重检查实现线程安全：仍然使用了`synchronized`关键字，优于加在方法上，但还是比较浪费性能

     ```java
     public class SyncLazySingleton {
     	......
     	// 双重检查，减小了锁的力度，但性能仍然有待提升。
         public static SyncLazySingleton getInstance() {
             // 第一个if用来判断，当单例对象已经实例化时，直接返回，避免获取到锁后再判断，优化性能
             if (null == singleton) {
                 synchronized (SyncLazySingleton.class) {
                     if (null == singleton) {
                         // 第二个if为了实现线程安全
                         // 当第二个线程获取到锁时，发现单例对象已经实例化，不会再执行后面代码
                         singleton = new SyncLazySingleton();
                     }
                 }
             }
             return singleton;
         }
         ......
     }
     ```

   * 内部类实现：通过静态内部类加载机制实现，线程安全，但可以通过反射技术破坏单例模式

     ```java
     public class InnerClassLazySingleton {
         private InnerClassLazySingleton() {
             if (null != LazySingletonHolder.singleton) {
                 throw new RuntimeException("无法通过反射构造实例");
             }
         }
     
         // static 是为了使单例的空间共享
         // final 保证这个方法不会被重写，重载
         public static final InnerClassLazySingleton getInstance() {
             return LazySingletonHolder.singleton;
         }
     
         // 静态内部类不会随着外部类的实例化而加载
         // 而是在被调用时才会加载，而且只加载一次
         // 通过JVM的类加载机制实现了线程安全的单例模式
         // 可能被反射破坏
         private static class LazySingletonHolder {
             private static final InnerClassLazySingleton singleton = new InnerClassLazySingleton();
         }
     }
     ```

     ![](/image/单例模式内部类加载uml图.png)

     ```java
     
     ```

     

3. 注册式单例：

   * 枚举实现：JDK底层保证了枚举式单例不被破坏。
   * 容器式单例：需要使用`synchronized`关键字实现线程安全。

4. `ThreadLocal`单例：同一个线程内绝对安全，线程间不安全。

#### 使用案例

1. `ServletContext`
2. `ServletConfig`
3. `ApplicationContext`
4. `DBPool`



#### 破坏单例模式的方法

1. 反射，利用构造方法强行构造对象；
2. 序列化，没有重写`readResolve()`方法时，反序列化会重新`new`一个对象，要想保证单例模式不被序列化破解，应该重写`readResolve()`方法；