import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        /*
        입력받기 위한 BufferedReader 선언
        입력받은 문자열을 자르기위한 StringTokenizer 선언
         */

        StringTokenizer st;

        /*
        1. 금주 회차 입력
        thisWeekNo => 이번 주 회차 (가장 최신 회차)
         */
        int thisWeekNo = 0;

        /*
        입력 맞을 때 까지 입력 및 검증 반복
         */
        while (true) {
            System.out.println("금주 회자를 입력해주세요. (예) 1086");
            String tempStr = inputStr(1, 999999999);

            thisWeekNo = Integer.parseInt(tempStr);
            System.out.println("입력하신 회차는 " + thisWeekNo + "회 입니다. 맞으면 1번 틀리면 2번을 눌러주세요.");
            tempStr = inputStr(1, 2);

            int tempFlag = Integer.parseInt(tempStr);
            if (tempFlag == 1) break;
            else {
                System.out.println("재입력을 선택하셨습니다.");
            }
        }
        System.out.println("금주의 회차는 " + thisWeekNo + "회 입니다.");

        makeLine();//////////////////////////////////////////////////////////////////////////

        /*
        2. 역대 당첨번호 입력
         */

        System.out.println("역대 당첨번호를 입력합니다.");
        System.out.println("동행 복권사이트에서 다운받은 엑셀을 (1회차부터 입력회차 까지) 긁어 넣습니다. 이때 회차는 역순 상태 그대로 입력합니다.");

        int[][] historyNum = new int[thisWeekNo][7];

        // 이 부분에 번호 제대로 들어갔는지 검증하는 방법

        for (int i = thisWeekNo - 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine(), "\t");
            int sumTemp = 0;
            for (int j = 0; j < 6; j++) {
                if (!st.hasMoreTokens()) {
                    System.out.println("6자리 이하의 로또번호가 들어왔습니다. ");
                }
                String check = st.nextToken();
                if (!numberOnlyCheck(check)) {
                    System.out.println("숫자가 아닙니다. 혹은 \\t로 개행하신 것 맞나요? (엑셀을 그대로 복사할 시 \\t로 개행 됨)");
                }
                historyNum[i][j] = Integer.parseInt(check);
                if (historyNum[i][j] <= 0 || historyNum[i][j] > 45) {
                    System.out.println("범위가 0이하거나 45를 초과했습니다.");
                }
                sumTemp += historyNum[i][j];
            }
            historyNum[i][6] = sumTemp;
        }

        // 입력 값 확인
//        for(int i=0;i<thisWeekNo;i++){
//            for(int j=0;j<6;j++){
//                System.out.print(historyNum[i][j] + " ");
//            }
//            System.out.println(historyNum[i][6]);
//        }

        /*
        3. 동작 선택
            1. 번호 생성
            2. 통계 조회
            3. 경우의 수 조회
            4. 종료
         */

        boolean operator = true;
        while (operator) {
            System.out.println("동작을 선택해주세요.");
            System.out.println("1. 번호 생성");
            System.out.println("2. 번호 통계 조회");
            System.out.println("3. 경우의 수 조회");
            System.out.println("0. 종료");

            int op = Integer.parseInt(inputStr(0, 3));


            if (op == 0) {
                operator = false;
                break;
            } else if (op == 1) {
                System.out.println("- 번호를 생성합니다.");
                System.out.println("생성할 조합의 수를 정하세요. 최소 1, 최대 100");
                int lottoCount = Integer.parseInt(inputStr(1, 100));
                System.out.println(lottoCount + "개의 번호 조합을 생성합니다.");

                int sumMin = 21;
                int sumMax = 255;


                System.out.println("구간합을 설정하시려면 1번, 전체 구간에서 번호 출력을 원하시면 0번을 입력해주세요.");
                int tempNum = Integer.parseInt(inputStr(0, 1));

                boolean sumFlag = true;

                if (tempNum == 0) {
                    System.out.println("다음 단계로 넘어갑니다.");
                    sumFlag = false;
                }


                while (sumFlag) {
                    System.out.println("번호 합 구간을 설정합니다. 생성된 번호의 합은 입력한 최솟값과 최댓값의 사이에서 생성됩니다.");
                    System.out.println("** ex) 120 ~ 150으로 설정되었다면 번호합이 119이하나 151이상은 버리고 새로운 조합을 생성합니다.");
                    System.out.println("최소 값을 설정하세요. 최소 21, 최대 254입니다.");
                    int tempMin = Integer.parseInt(inputStr(21, 254));
                    System.out.println("최대 값을  설정하세요. 최소 22, 최대 255입니다.");
                    int tempMax = Integer.parseInt(inputStr(22, 255));
                    if (tempMin >= tempMax) {
                        System.out.println("최솟값이 최댓값보다 크거나 같습니다. 다시 입력합니다.");
                    } else {
                        System.out.println("입력하신 최소 값은 " + tempMin + "최대 값은 " + tempMax + "입니다.");
                        System.out.println("맞으면 1번 틀리면 2번을 입력해주세요.");
                        tempNum = Integer.parseInt(inputStr(1, 2));
                        if (tempNum == 1) {
                            System.out.println("설정이 완료되었습니다.");
                            sumMin = tempMin;
                            sumMax = tempMax;
                            sumFlag = false;
                        } else {
                            System.out.println("설정을 다시 시작합니다.");
                        }
                    }
                }

                System.out.println("미사용 번호를 입력합니다.");
                System.out.println("입력을 원하시면 1번 아니면 0번을 눌러주세요.");
                tempNum = Integer.parseInt(inputStr(0, 1));

                boolean notUseNumberFlag = true;

                if (tempNum == 0) {
                    System.out.println("다음 단계로 넘어갑니다.");
                    notUseNumberFlag = false;
                }

                boolean[] notUseNumberCheck = new boolean[45];

                System.out.println("사용하지 않을 번호를 입력하세요. 다시 입력하면 사용하기로 바뀝니다.");
                System.out.println("입력이 끝나면 0번을 입력해주세요.");
                while (notUseNumberFlag) {
                    int tempNumber = Integer.parseInt(inputStr(0, 45));
                    if (tempNumber == 0) {
                        System.out.println("입력을 종료합니다.");
                        printNotUseNumber(notUseNumberCheck);
                        notUseNumberFlag = false;
                        break;
                    }
                    tempNumber -= 1;
                    notUseNumberCheck[tempNumber] = !notUseNumberCheck[tempNumber];
                    if (notUseNumberCheck[tempNumber]) {
                        System.out.println((tempNumber + 1) + "번을 사용하지 않습니다.");
                    } else {
                        System.out.println((tempNumber + 1) + "번을 사용합니다.");
                    }
                }

                System.out.println("번호 생성을 시작합니다.");
                LuckyNumber[] lotto = new LuckyNumber[lottoCount];
                for (int i = 0; i < lottoCount; i++) {
                    lotto[i] = new LuckyNumber(sumMin, sumMax, notUseNumberCheck);
                    lotto[i].createNumber();
                }

                br.readLine();

            } else if (op == 2) {
                System.out.println(" 번호 통계를 조회합니다.");

                System.out.println("1. 미출현 번호");
                System.out.println("2. 번호합 구간별 출현 횟수");

                int tempNum = Integer.parseInt(inputStr(1, 2));

                if (tempNum == 1) {
                    int[] unappearedNumbers = new int[45];

                    for (int i = 0; i < thisWeekNo; i++) {
                        for (int j = 0; j < 45; j++) {
                            unappearedNumbers[j]++;
                        }
                        for (int j = 0; j < 6; j++) {
                            unappearedNumbers[historyNum[i][j] - 1] = 0;
                        }
                    }

                    for (int i = 0; i < 45; i++) {
                        System.out.println((i + 1) + "번은 " + unappearedNumbers[i] + "주 전에 출현하였습니다.");
                    }

                    System.out.println("10주 이상 미출현 번호는 다음과 같습니다.");
                    for (int i = 0; i < 45; i++) {
                        if (unappearedNumbers[i] >= 10) {
                            System.out.print((i + 1) + " ");
                        }
                    }
                    System.out.println();

                    System.out.println("15주 이상 미출현 번호는 다음과 같습니다.");
                    for (int i = 0; i < 45; i++) {
                        if (unappearedNumbers[i] >= 15) {
                            System.out.print((i + 1) + " ");
                        }
                    }
                    System.out.println();
                } else {
                    int[] sumNum = new int[256];
                    for (int i = 0; i < thisWeekNo; i++) {
                        sumNum[historyNum[i][6]]++;
                    }

                    for (int i = 0; i < 256; i++) {
                        if (sumNum[i] != 0)
                            System.out.println("번호합 " + i + " 의 출현 횟수 : " + sumNum[i]);
                    }

                    int sliding =0;
                    int maxArea = 0;
                    int start = 0;
                    int end = 20;
                    for(int i=0;i<20;i++){
                        sliding += sumNum[i];
                    }

                    for(int i=20;i<256;i++){
                        sliding += sumNum[i];
                        sliding -= sumNum[i-20];

                        if(sliding > maxArea){
                            maxArea= sliding;
                            start = i-20;
                            end = i;
                        }
                    }
                    System.out.println("연속된 20개의 번호합 중 가장 높은 출현횟수는 " + maxArea + "이며 구간은 "+ start + " ~ " + end + "입니다.");
                }

            } else if (op == 3) {
                System.out.println(" 경우의 수를 조회합니다.");
            }
        }

    }

    public static void printNotUseNumber(boolean[] check) {
        System.out.println("제외할 번호를 출력합니다.");
        for (int i = 0; i < 45; i++) {
            if (check[i]) {
                System.out.print((i + 1) + "번 ");
            }
        }
        System.out.println();
    }

    public static String inputStr(int one, int two) throws Exception {
        String tempStr = br.readLine();
        boolean numberOnlyCheckFlag = true;  // 숫자만 있는지 확인
        boolean numberRangeCheckFlag = true; // 숫자가 10억을 넘어가지 않는지 확인
        boolean oneOrTwoFlag = true; // 숫자가 one 이상 two 이하 인지 확인
        while (numberOnlyCheckFlag || numberRangeCheckFlag || oneOrTwoFlag) {
            if (numberOnlyCheckFlag = !numberOnlyCheck(tempStr)) {
                System.out.println("숫자가 아닌 다른 문자가 포함되었습니다. 다시 입력해 주세요.");
                tempStr = br.readLine();
            } else if (numberRangeCheckFlag = !numberRangeCheck(tempStr)) {
                System.out.println("10억이 넘는 수입니다. 다시 입력해 주세요.");
                tempStr = br.readLine();
            } else if (oneOrTwoFlag = !oneOrTwoCheck(tempStr, one, two)) {
                System.out.println(one + " 이상 " + two + "이하가 아닌 다른 수를 입력하셨습니다. 다시 입력해 주세요.");
                tempStr = br.readLine();
            }
        }
        return tempStr;
    }

    public static void cleanScreen() {
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
    }

    public static void makeLine() {
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static boolean numberRangeCheck(String num) {
        if (num.length() >= 10) {
            return false;
        }
        return true;
    }

    public static boolean numberOnlyCheck(String num) {
        final String REGEX = "[0-9]+"; // 숫자 확인 정규 표현식
        if (num.matches(REGEX)) {
            return true;
        }
        return false;
    }

    public static boolean oneOrTwoCheck(String num, int one, int two) {
        int number = Integer.parseInt(num);
        return number >= one && number <= two;
    }

}
