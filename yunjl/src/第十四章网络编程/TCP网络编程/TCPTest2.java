package 第十四章网络编程.TCP网络编程;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 * @author Yunjl
 * @create 2021-04-16 17:51
 */
public class TCPTest2 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;

        try {
            //1.
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            //2.
            os = socket.getOutputStream();
            //3.
            fis = new FileInputStream(new File("艾米莉亚.jpg"));
            //4.
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            //5.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //1.
            ss = new ServerSocket(9090);
            //2.
            socket = ss.accept();
            //3.
            is = socket.getInputStream();
            //4.
            fos = new FileOutputStream(new File("艾米莉亚5.jpg"));
            //5.
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
