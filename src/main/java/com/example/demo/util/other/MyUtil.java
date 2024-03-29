package com.example.demo.util.other;

import java.io.*;

/**
 * @author pxh
 * @date 2021.10.23
 */
public class MyUtil {

    private MyUtil(){
        throw new AssertionError();
    }

    /**
     * 有两种方式：
     *     实现Cloneable接口并重写Object类中的clone()方法；
     *     实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆，代码如下：
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unckecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T)ois.readObject();
        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }
}
