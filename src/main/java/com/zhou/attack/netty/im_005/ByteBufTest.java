package com.zhou.attack.netty.im_005;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * ByteBuf API学习
 * Created by zhoumb on 2018/12/25
 */
public class ByteBufTest {
    public static void main(String[] args) {
        //初始化一个内存区域
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);

        print("allocate ByteBuf(9,100)", buffer);

        //write 方法改变写指针，写完之后写指针未到capacity时，buffer仍然是可写的
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        print("writeBytes(1,2,3,4)", buffer);

        // write 方法改变写指针，写完之后写指针未到 capacity 的时候，buffer 仍然可写, 写完 int 类型之后，写指针增加4
        buffer.writeInt(12);
        print("writeInt(12)", buffer);

        buffer.writeBytes(new byte[]{5});
        print("writeBytes(new byte[]{5})", buffer);

        buffer.writeBytes(new byte[]{6});
        print("writeBytes(new byte[]{6})", buffer);

        //get操作不改变写指针
        System.out.println("getByte(3) return: " + buffer.getByte(3));
        System.out.println("getShort(3) return: " + buffer.getShort(3));
        System.out.println("getInt(3) return : " + buffer.getInt(3));
        print("getByte()", buffer);

        //set操作不改变写指针
        buffer.setByte(buffer.readableBytes() + 1, 0);
        print("setByte()", buffer);

        // read 方法改变读指针
        byte[] bytes = new byte[buffer.readableBytes()];
        buffer.readBytes(bytes);
        print("readBytes(" + bytes.length + ")", buffer);

        ByteBuf slice = buffer.slice(1, 5);
        print("slice(1,5)", buffer);
        print("slice", slice);

        buffer.writeBytes(new byte[10]);
        print("writeBytes(new byte[10])", buffer);
        buffer.markReaderIndex();
        buffer.readBytes(5);
        print("readBytes(5)", buffer);
        buffer.resetReaderIndex();
        print("buffer.restReaderIndex()", buffer);

        //netty使用堆外内存，堆外内存是不被jvm管理的，无法被自定被垃圾收集，因此需要手动释放，不然会造成内存溢出
        //release():释放堆外内存
        //retain()
    }

    private static void print(String action, ByteBuf buffer) {
        System.out.println("after ===========" + action + "============");
        System.out.println("capacity(): " + buffer.capacity());
        System.out.println("maxCapacity(): " + buffer.maxCapacity());
        System.out.println("readerIndex(): " + buffer.readerIndex());
        System.out.println("readableBytes(): " + buffer.readableBytes());
        System.out.println("isReadable(): " + buffer.isReadable());
        System.out.println("writerIndex(): " + buffer.writerIndex());
        System.out.println("writableBytes(): " + buffer.writableBytes());
        System.out.println("isWritable(): " + buffer.isWritable());
        System.out.println("maxWritableBytes(): " + buffer.maxWritableBytes());
        System.out.println();
    }
}
