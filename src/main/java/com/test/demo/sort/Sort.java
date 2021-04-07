package com.test.demo.sort;

public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    /**
     * 比较值
     * @param v
     * @param w
     * @return
     */
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换值
     * @param a
     * @param i
     * @param j
     */
    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}