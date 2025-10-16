package calculator;

import calculator.utils.Calculator;
import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("덧셈함 문자열을 입력해 주세요.");

        String str = Console.readLine();

        int ans = calculator.calc(str);

        System.out.println("결과 : " + ans);

    }


}
