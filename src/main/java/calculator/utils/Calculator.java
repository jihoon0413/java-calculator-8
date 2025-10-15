package calculator.utils;

import java.util.List;
import java.util.Objects;

public class Calculator {

    private final List<Character> delimiters = List.of(',', ':');

    public int calc(String str) {
        // 기본 구분자를 기준으로 숫자 분리
        int ans = 0;
        StringBuilder num = new StringBuilder();

        if (Objects.equals(str, "")) {
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (checkNum(c)) {
                num.append(c);
            } else {
                if (delimiters.contains(c)) {
                    ans += Integer.parseInt(String.valueOf(num));
                    num.setLength(0);
                } else {
                    throw new IllegalArgumentException("잘못된 입력 방식입니다.");
                }
            }
        }

        ans += Integer.parseInt(String.valueOf(num));

        return ans;
    }

    private boolean checkNum(char c) {
        return Character.isDigit(c);
    }

}
