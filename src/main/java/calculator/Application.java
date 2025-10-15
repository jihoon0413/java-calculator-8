package calculator;

import calculator.utils.Calculator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {

        Calculator calculator = new Calculator();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("덧셈함 문자열을 입력해 주세요.");

        String str = br.readLine();

        int ans = calculator.calc(str);

        System.out.println("결과 : " + ans);

    }


}
