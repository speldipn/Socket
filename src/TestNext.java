import java.util.Scanner;

/*
 * @author Oh, joon young (speldipn)
 * @since 2018-11-29
 */
public class TestNext {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    for (int i = 0; i < 3; ++i) {
      System.out.println("[" + i + "]");
      String a = s.nextLine();
      int b = s.nextInt();
      s.nextLine(); // 개행문자를 제거!!
      String c = s.nextLine();
    }
  }
}
