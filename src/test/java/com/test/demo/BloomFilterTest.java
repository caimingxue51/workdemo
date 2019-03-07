import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author xiaomu
 * @ClassName: Test
 * @Description: 动态编译运行的测试(这里用一句话描述这个类的作用)
 * @date 2018年1月5日 上午8:37:04
 */
//将所有警告取消
@SuppressWarnings("all")
public class BloomFilterTest {
    public static void main(String[] args) throws Exception {

        FileOutputStream out = null;


        out = new FileOutputStream(new File("C:/tmep/Test.java"));

        long begin = System.currentTimeMillis();
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("public class Test {");
        javaCode.append("public static void main(String[] args) throws Exception {");
        javaCode.append("system.out.println(\"do!\");");
        javaCode.append("}");
        javaCode.append("}");


        out.write(javaCode.toString().getBytes());
        out.close();

        long end = System.currentTimeMillis();

        System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 豪秒");


        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "C:/tmep/Test.java");
        System.out.println(result == 0 ? "成功" : "失败");


        URL[] urls = new URL[]{new URL("file:/" + "C:/tmep/")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class c = loader.loadClass( "BloomFilterTest" );
        Method m = c.getDeclaredMethod("main", String[].class);
        //通过Object把数组转化为参数
        m.invoke(null, new String[]{});

    }

    @org.junit.Test
    public  void test(){

        List<String> oldlist = null;
        Object o = oldlist;
        List<String> newlist = (List<String>) o;
        System.out.println( newlist.size() );
    }
}
