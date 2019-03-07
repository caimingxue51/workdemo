package com.test.demo.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
 
import java.util.ArrayList;
import java.util.List;
 
/**
 * Created by admin on 17/7/7.
 * 布隆过滤器
 */
public class BloomFilterTest {
    private static int size = 1000000;
 
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size,0.001);
 
    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }
 
        for (int i = 0; i < size; i++) {
            if (!bloomFilter.mightContain(i)) {
                System.out.println("有坏人逃脱了");
            }
        }
 
        List<Integer> list = new ArrayList<Integer>(1000);
        for (int i = size + 10000; i < size + 20000; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }
        System.out.println("有误伤的数量：" + list.size());
    }
}
