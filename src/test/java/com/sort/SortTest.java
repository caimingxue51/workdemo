package com.sort;

import com.alibaba.fastjson.JSON;
import com.test.demo.sort.Bubble;
import com.test.demo.sort.Selection;
import org.junit.Test;

/**
 * 各种排序算法测试
 *
 * @author Mr.CCX
 * @date 2021-04-07 18:02
 **/
public class SortTest {
    Integer[] num = new Integer[]{3,4,5,2,1,0,7,6,8,9};

    @Test
    public void testSelection(){
        Selection<Integer> sort = new Selection<Integer>();

        sort.sort(num);
        System.out.println(JSON.toJSONString(num));
    }

    @Test
    public void testBubble(){
        Bubble<Integer> sort = new Bubble<Integer>();

        sort.sort(num);
        System.out.println(JSON.toJSONString(num));
    }
}
