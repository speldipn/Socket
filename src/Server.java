import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * @author Oh, joon young (speldipn)
 * @since 2018-11-29
 */
public class Server {
  public static final int PORT_NUM = 5557;

  public static void main(String[] args) {
    Socket socket = null;
    try {
      ServerSocket serverSocket = new ServerSocket(PORT_NUM);
      socket = serverSocket.accept();
      socket.setReuseAddress(true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      while (true) {
        System.out.println("입력 대기중..");
        String data = in.readLine();
        if(data.length() > 0) {
          System.out.println(data);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println("서버가 종료되었습니다.");
  }
}
