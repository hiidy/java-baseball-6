package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;

public class PlayGame {

    private int ball;
    private int strike;

    public void startGame() {
        System.out.println("숫자를 입력해주세요 : ");
        String originalInput = Console.readLine();
        validateInput(originalInput);
        ArrayList<Integer> userNumberList = inputToArrayList(originalInput);
        ArrayList<Integer> answerNumbers = GenerateNum.makeAnswer();
    }

    public ArrayList<Integer> inputToArrayList(String numInput) {
        ArrayList<Integer> userNumbers = new ArrayList<>();

        for (char c : numInput.toCharArray()) {
            userNumbers.add(c - '0');
        }

        return userNumbers;
    }

    public void validateInput(String input) {
        validateNumberLength(input);
        validateIsZero(input);
        validateIntegerNumber(input);
        validateDuplicateNumbers(input);
    }

    public void validateNumberLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 초과되었습니다.");
        }
    }

    public void validateIntegerNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("1~9 사이에 있는 정수만 입력해주세요.");
            }
        }
    }

    public void validateDuplicateNumbers(String input) {
        HashSet<Character> setNumbers = new HashSet<>();
        for (char c : input.toCharArray()) {
            setNumbers.add(c);
        }

        if (input.length() != setNumbers.size()) {
            throw new IllegalArgumentException("중복된 값을 입력하지 말아주세요.");
        }
    }

    public void validateIsZero(String input) {
        for (char c : input.toCharArray()) {
            if (c == '0') {
                throw new IllegalArgumentException("0을 입력하지 말아주세요");
            }
        }
    }
}
