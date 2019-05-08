package basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {
    public static void main(String[] args){
        try {
            copyFile("C:\\Users\\CHT\\Desktop\\A.txt","C:\\Users\\CHT\\Desktop\\B.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //复制文件
    public static void copyFile(String src,String dest) throws IOException{
        //获得源文件的输入字节流
        FileInputStream fileInputStream = new FileInputStream(src);
        //获得输入文件流的文件通道
        FileChannel fileChannelIn = fileInputStream.getChannel();
        //获取目标文件的输出字节流
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        //获取输出字节流的文件通道
        FileChannel fileChannelOut = fileOutputStream.getChannel();
        //缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            int r = fileChannelIn.read(buffer);
            if (r==-1){
                break;
            }
            buffer.flip();
            fileChannelOut.write(buffer);
            buffer.clear();
        }
    }
}
