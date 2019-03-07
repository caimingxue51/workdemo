package com.test.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ClassUtilTest {
    private static final Log logger = LogFactory.getLog(ClassUtilTest.class);

    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.even.test;");
        sb.append("import java.util.Map;\nimport java.text.DecimalFormat;\n");
        sb.append("public class Sum{\n");
        sb.append("private final DecimalFormat df = new DecimalFormat(\"#.#####\");\n");
        sb.append("public Double calculate(Map<String,Double> data){\n");
        sb.append("double d = (30*data.get(\"f1\") + 20*data.get(\"f2\") + 50*data.get(\"f3\"))/100;\n");
        sb.append("return Double.valueOf(df.format(d));}}\n");

        //设置编译参数
        ArrayList<String> ops = new ArrayList<String>();
        ops.add("-Xlint:unchecked");
        //编译代码，返回class
        Class<?> cls = ClassUtil.loadClass("/com/even/test/Sum.java", sb.toString(), "com.even.test.Sum", ops);
        //准备测试数据
        Map<String, Double> data = new HashMap<>();
        data.put("f1", 10.0);
        data.put("f2", 20.0);
        data.put("f3", 30.0);
        //执行测试方法
        Object result = ClassUtil.invoke(cls, "calculate", new Class[]{Map.class}, new Object[]{data});
        //输出结果
        logger.debug(data);

        logger.debug("(30*f1+20*f2+50*f3)/100 = " + result);
        System.out.println("(30*f1+20*f2+50*f3)/100 = " + result);
    }
}