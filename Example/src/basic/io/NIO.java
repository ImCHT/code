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
    //�����ļ�
    public static void copyFile(String src,String dest) throws IOException{
        //���Դ�ļ��������ֽ���
        FileInputStream fileInputStream = new FileInputStream(src);
        //��������ļ������ļ�ͨ��
        FileChannel fileChannelIn = fileInputStream.getChannel();
        //��ȡĿ���ļ�������ֽ���
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        //��ȡ����ֽ������ļ�ͨ��
        FileChannel fileChannelOut = fileOutputStream.getChannel();
        //������
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
