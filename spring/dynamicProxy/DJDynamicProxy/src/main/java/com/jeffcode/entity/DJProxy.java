package com.jeffcode.entity;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: jefflike
 * @create: 2019/3/23
 * @describe:
 * 生成代理类的代码，更好地理解动态代理实现的流程
 */
public class DJProxy {
    private static String ln = "\r\n";

    // 生成代理对象代码需要三个参数，自定义类加载器，对象的接口，实现invoke的代理对象
    public static Object newProxyInstance(DJClassLoader classLoader,Class<?>[] interfaces,DJInvocationHandler h){


        try{
            //1、生成源代码（为了方便，这里我们只有一个接口）
            String proxySrc = generateSrc(interfaces[0]);


            //2、将生成的源代码输出到磁盘，保存为.java文件
            String filePath = DJProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            //3、编译源代码，并且生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            //4.将class文件中的内容，动态加载到JVM中来

            //5.返回被代理后的代理对象
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(DJInvocationHandler.class);
            f.delete();

            return c.newInstance(h);

        }catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    // 纯手动生成一个java类代码（这个就是实际的被代理对象，此对象实现了被代理对象的接口）
    private static String generateSrc(Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package com.jeffcode.entity;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        // 生成的java类名字就写死了叫$Proxy0
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);

        src.append("DJInvocationHandler h;" + ln);

        // 提供一个有参构造器，赋值代理对象
        src.append("public $Proxy0(DJInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
            // 调用代理对象的invoke方法三个参数分别是被代理对象，执行方法和实参
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }

        src.append("}");

        return src.toString();
    }
}
