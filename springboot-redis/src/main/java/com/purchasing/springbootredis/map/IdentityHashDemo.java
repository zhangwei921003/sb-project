package com.purchasing.springbootredis.map;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *      Integer 和 int 之间对比的总结
 *   ①无论如何，Integer与new Integer不会相等。不会经历拆箱过程，i3的引用指向堆，而i4指向专门存放他的内存（常量池），他们的内存地址不一样，所以为false
 *   ②两个都是非new出来的Integer，如果数在-128到127之间，则是true,否则为false
 *   java在编译Integer i2 = 128的时候,被翻译成-> Integer i2 = Integer.valueOf(128);而valueOf()函数会对-128到127之间的数进行缓存
 *   ③两个都是new出来的,都为false
 *   ④int和integer(无论new否)比，都为true，因为会把Integer自动拆箱为int再去比
 *
 *   1）对于==，比较的是值是否相等
 *       如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
 * 　  如果作用于引用类型的变量，则比较的是所指向的对象的地址
 *   2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量，equals继承Object类，比较的是是否是同一个对象
 * 　  如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
 * 　  诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容
 * @author zhangwei
 * @createTime 2018/11/7
 */
public class IdentityHashDemo {

    //free - Lock
    private volatile static Integer value;

    //Optimistic Lock （CAS）
    private static AtomicLong count;

    public synchronized void doSome(){
        Lock lock = new ReentrantLock();
        try {
            lock.tryLock();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Integer var1 = new Integer(1);
        Integer var2 = new Integer(1);
        System.out.println(var1.hashCode());
        System.out.println(var2.hashCode());
        System.out.println(var1 == var2);//false
        System.out.println(var1.equals(var2));//true
        System.out.println(System.identityHashCode(var1));
        System.out.println(System.identityHashCode(var2));
    }
}
