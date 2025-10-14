package calculator;

import java.io.*;

public class Application {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("덧셈함 문자열을 입력해 주세요.");

        String str = br.readLine();
        System.out.println(str);
    }
}
