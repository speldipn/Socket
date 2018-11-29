import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/*
 * @author Oh, joon young (speldipn)
 * @since 2018-11-29
 */
public class Client {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Socket socket = null;

    try {
      socket = new Socket("192.168.1.56", Server.PORT_NUM);
      OutputStream os = socket.getOutputStream();

//      while (true) {
//        System.out.print("input: ");
//        String word = scanner.nextLine();
//        if (word.equals("exit")) break;
//        word += "\r\n";
//        os.write(word.getBytes());
//        os.flush();
//      }

      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      String data;
      while (true) {
        System.out.print("input: ");
        data = scanner.nextLine(); // so do\n
        if (data.equals("exit")) break;
        out.write(data);
        out.newLine();
        out.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    System.out.println("클라이언트 프로그램을 종료합니다.");
  }
}
