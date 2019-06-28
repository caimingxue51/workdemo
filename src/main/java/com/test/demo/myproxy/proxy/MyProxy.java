package com.test.demo.myproxy.proxy;

import com.test.demo.myproxy.handler.MyInvocationHandler;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/3/7 11:14
 * 1、生成java源碼
 * 2、將源码输出到java文件中
 * 3、将java文件编译成class文件
 * 4、将class加载进jvm
 * 5、返回代理类对象
 */
public class MyProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader myClassLoder,
                                          Class<?>[] interfaces, MyInvocationHandler h) {
        // 1 java源碼
        String src = generateSrc( interfaces );
        // 2 將源码输出到java文件中
        String filePath = MyProxy.class.getResource( "" ).getPath();
        System.out.println( filePath );

        File file = new File( filePath + "$Proxy0.java" );
        try {
            FileWriter fw = new FileWriter( file );
            fw.write( src );
            fw.flush();
            fw.close();
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager( null, null, null );
            Iterable iterable = standardFileManager.getJavaFileObjects( file );
            JavaCompiler.CompilationTask compilationTask = javaCompiler.getTask( null,standardFileManager,null,null,null,iterable );
            compilationTask.call();
            standardFileManager.close();
            //4、将class加载进jvm
            Class proxyClass = myClassLoder.findClass( "$Proxy0" );
            //file.delete();
            Constructor constructor = proxyClass.getConstructor( MyInvocationHandler.class );
            return constructor.newInstance( h );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        // TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer();
        sb.append( "package com.test.demo.myproxy.proxy;" + ln );
        sb.append( "import java.lang.reflect.Method;" + ln );
        sb.append( "import com.test.demo.myproxy.handler.MyInvocationHandler;" + ln );
        sb.append( "public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln );
        sb.append( "private MyInvocationHandler h;" + ln );
        //在构造方法中传入handler
        sb.append( "public $Proxy0(MyInvocationHandler h) { " + ln );
        sb.append( "this.h = h;" + ln );
        sb.append( "}" + ln );
        for (Method m : interfaces[0].getMethods()) {

            sb.append( "public " + m.getReturnType().getName() + " "
                    + m.getName() + "() {" + ln );
            sb.append( "try{" + ln );
            sb.append( "Method m = " + interfaces[0].getName()
                    + ".class.getMethod(\"" + m.getName()
                    + "\",new Class[]{});" + ln );
            sb.append( "this.h.invoke(this,m,null);" + ln );
            sb.append( "}catch(Throwable e){" + ln );
            sb.append( "e.printStackTrace();" + ln );
            sb.append( "}" + ln );
            sb.append( "}" + ln );
        }
        sb.append( "}" + ln );
        return sb.toString();
    }
}
