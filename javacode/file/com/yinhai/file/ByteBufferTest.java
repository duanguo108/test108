package com.yinhai.file;

import java.nio.ByteBuffer;

public class ByteBufferTest {
    public static void main(String[] args) {
        System.out.println("----------Test allocate--------");
        System.out.println("before alocate:"
                + Runtime.getRuntime().freeMemory());

        // 如果分配的内存过小，调用Runtime.getRuntime().freeMemory()大小不会变化？
        // 要超过多少内存大小JVM才能感觉到？

        // 分配一个新的字节缓冲区。
        ByteBuffer buffer = ByteBuffer.allocate(10240000);
        System.out.println("buffer = " + buffer);

        System.out.println("after alocate:"
                + Runtime.getRuntime().freeMemory());

        // 这部分直接用的系统内存，所以对JVM的内存没有影响
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(10240000);
        System.out.println("directBuffer = " + directBuffer);
        System.out.println("after direct alocate:"
                + Runtime.getRuntime().freeMemory());

        System.out.println("----------Test wrap--------");
        byte[] bytes = new byte[32];
        buffer = ByteBuffer.wrap(bytes);
        System.out.println(buffer);

        buffer = ByteBuffer.wrap(bytes, 10, 10);
        System.out.println(buffer);



        System.out.println("--------Test reset----------");
        buffer.clear();//清除此缓冲区。 位置设置为零，限制设置为容量
        buffer.position(5);
        buffer.mark();
        buffer.position(10);
        System.out.println("before reset:" + buffer);
        buffer.reset();
        System.out.println("after reset:" + buffer);

        System.out.println("--------Test rewind--------");
        buffer.clear();
        buffer.position(10);
        buffer.limit(15);
        System.out.println("before rewind:" + buffer);
        buffer.rewind();
        System.out.println("before rewind:" + buffer);

        System.out.println("--------Test compact--------");
        buffer.clear();
        buffer.put("abcd".getBytes());
        System.out.println("before compact:" + buffer);
        System.out.println(new String(buffer.array()));
        buffer.flip();
        System.out.println("after flip:" + buffer);
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());
        System.out.println("after three gets:" + buffer);
        System.out.println("\t" + new String(buffer.array()));
        buffer.compact();//缓冲区当前位置与其限制（如果有的话）之间的字节被复制到缓冲区的开头。
        System.out.println("after compact:" + buffer);
        System.out.println("\t" + new String(buffer.array()));

        System.out.println("------Test get-------------");
        buffer = ByteBuffer.allocate(32);
        buffer.put((byte) 'a').put((byte) 'b').put((byte) 'c').put((byte) 'd')
                .put((byte) 'e').put((byte) 'f');
        System.out.println("before flip()" + buffer);
        // 转换为读取模式
        buffer.flip();//翻转这个缓冲区。 该限制设置为当前位置，然后将该位置设置为零
        System.out.println("before get():" + buffer);
        System.out.println((char) buffer.get());
        System.out.println("after get():" + buffer);
        // get(index)不影响position的值
        System.out.println((char) buffer.get(2));
        System.out.println("after get(index):" + buffer);
        byte[] dst = new byte[10];
        buffer.get(dst, 0, 2);
        System.out.println("after get(dst, 0, 2):" + buffer);//此方法将字节从此缓冲区传输到给定的目标数组。
        System.out.println("\t dst:" + new String(dst));
        System.out.println("buffer now is:" + buffer);
        System.out.println("\t" + new String(buffer.array()));

        System.out.println("--------Test put-------");
        ByteBuffer bb = ByteBuffer.allocate(32);
        System.out.println("before put(byte):" + bb);
        System.out.println("after put(byte):" + bb.put((byte) 'z'));
        System.out.println("\t" + bb.put(2, (byte) 'c'));
        // put(2,(byte) 'c')不改变position的位置
        System.out.println("after put(2,(byte) 'c'):" + bb);
        System.out.println("\t" + new String(bb.array()));
        // 这里的buffer是 abcdef[pos=3 lim=6 cap=32]
        bb.put(buffer);
        System.out.println("after put(buffer):" + bb);
        System.out.println("\t" + new String(bb.array()));
    }



}
