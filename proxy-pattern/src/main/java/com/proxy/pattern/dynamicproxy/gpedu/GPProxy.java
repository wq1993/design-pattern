package com.proxy.pattern.dynamicproxy.gpedu;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by wq on 2019/3/20
 */
public class GPProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler handler) {

        try {
            // 1.动态生成代理对象源代码
            String source = generateSourceCode(interfaces);
            // System.out.println(source);

            // 2.将生成的源代码保存到磁盘
            String path = GPProxy.class.getResource("").getPath();
            System.out.println("代理对象生成路径：" + path);
            File file = new File(path + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(source);
            fw.flush();
            fw.close();

            // 3.将生成的.java编译成.class
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4.将类文件加载到ClassLoader
            Class<?> proxyClass = loader.findClass("$Proxy0");

            // 5.通过反射实例化代理对象
            Constructor<?> constructor = proxyClass.getConstructor(GPInvocationHandler.class);
            // 删除.java文件
            file.delete();
            return constructor.newInstance(handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSourceCode(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        // 引包
        sb.append("package com.proxy.pattern.dynamicproxy.gpedu;" + ln);
        // 导包
        sb.append("import com.proxy.pattern.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        // 类名
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        // 成员变量
        sb.append("GPInvocationHandler h;" + ln);
        // 有参构造
        sb.append("public $Proxy0(GPInvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        // 重写实现接口的方法
        for (Method method : interfaces[0].getMethods()) {
            sb.append("public " + method.getReturnType() + " " + method.getName() + "() {" + ln);
            sb.append("try {" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\", new Class[]{});" + ln);
            sb.append("this.h.invoke(this, m, null);" + ln);
            sb.append("} catch (Throwable e) {" + ln);
            sb.append("e.printStackTrace();" + ln);
            sb.append("}" + ln);
            sb.append("}" + ln);
        }

        sb.append("}");
        return sb.toString();
    }
}
