package ladder.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_PARTICIPANT_NUMBER = 2;
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+(,\\s*[a-zA-Z]+)*$");
    private static final Pattern OUTCOME_PATTERN = Pattern.compile("^(꽝|[1-9][0-9]*)(,\\s*(꽝|[1-9][0-9]*))*$");
    private static final Pattern HEIGHT_PATTERN = Pattern.compile("^([1-9][0-9]*)$");

    public static String[] inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String names = SCANNER.nextLine();

        if (!names.matches(NAME_PATTERN.pattern())) {
            throw new InputMismatchException("잘못된 입력 형식입니다. 다시 입력해주세요.");
        }

        String[] participantNames = names.split(",");

        if(participantNames.length < MIN_PARTICIPANT_NUMBER) {
            throw new InputMismatchException("참가자의 수는 최소 2명 이상어이야 합니다.");
        }

        participantNames = Arrays.stream(participantNames)
                .map(String::trim)
                .toArray(String[]::new);

        return participantNames;
    }

    public static String[] inputOutcomes() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String outcome = SCANNER.nextLine();

        if(!outcome.matches(OUTCOME_PATTERN.pattern())) {
            throw new InputMismatchException("잘못된 입력 형식입니다. 다시 입력해주세요.");
        }

        String[] outcomes = outcome.split(",");
        outcomes = Arrays.stream(outcomes)
                .map(String::trim)
                .toArray(String[]::new);

        return outcomes;
    }

    public static int inputMaxLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        String maxHeight = SCANNER.nextLine();

        if (!maxHeight.matches(HEIGHT_PATTERN.pattern())) {
            throw new InputMismatchException("잘못된 입력 형식입니다. 사다리의 높이는 1이상의 숫자만 입력할 수 있습니다.");
        }

        return Integer.parseInt(maxHeight);
    }

    public static String inputParticipantNameForOutcome() {
        System.out.println("\n결과를 보고 싶은 사람은?");

        return SCANNER.nextLine();
    }

}

