package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class MyRef {

    public static void softExample(SoftReference<? extends Object> soft) {
        Object obj = soft.get();
        if (null == obj) {
            System.out.println("Object got from soft reference ->" + obj.toString());
        } else {
            System.out.println("Object from soft reference already collected");
        }
    }


    public static void weakExample(WeakReference<? extends Object> soft) {
        Object obj = soft.get();
        if (null == obj) {
            System.out.println("Object got from weak reference ->" + obj.toString());
        } else {
            System.out.println("Object from weak reference already collected");
        }
    }
}
