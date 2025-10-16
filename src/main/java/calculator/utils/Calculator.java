package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculator {

    private final List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

    public int calc(String str) {
        // 기본 구분자를 기준으로 숫자 분리
        int ans = 0;
        StringBuilder num = new StringBuilder();

        if (Objects.equals(str, "")) {
            return 0;
        }

        if (str.startsWith("//")) {
            delimiters.add(getCustomDelimiter(str));
            str = str.substring(5);
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

    private char getCustomDelimiter(String str) {
        if (str.charAt(3) == '\\' && str.charAt(4) == 'n') {
            char delimiter = str.charAt(2);
            if (delimiters.contains(delimiter)) {
                throw new IllegalArgumentException("기본 구분자는 커스텀으로 등록할 수 없습니다.");
            }
            return delimiter;
        } else {
            throw new IllegalArgumentException("커스텀 구분자 입력 형식을 확인하세요.");
        }
    }

    private boolean checkNum(char c) {
        return Character.isDigit(c);
    }

}
