import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int thisWeekNo = 0;

        while(true) {
            System.out.println("금주 회자를 입력해주세요. (예) 1086");
            String tempStr = br.readLine();
            while(!numberOnlyCheck(tempStr)){
                System.out.println("숫자가 아닌 다른 문자가 포함되었습니다. 다시 입력해 주세요.");
                tempStr = br.readLine();
            }
            while(!numberRangeCheck(tempStr)){
                System.out.println("10억이 넘는 수입니다. 다시 입력해 주세요.");
                tempStr = br.readLine();
            }
            thisWeekNo = Integer.parseInt(tempStr);
            System.out.println("입력하신 회차는 " + thisWeekNo + "회 입니다. 맞으면 1번 틀리면 2번을 눌러주세요.");
            int tempFlag = Integer.parseInt(br.readLine());
            while(!(tempFlag == 1 || tempFlag == 2)){
                System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요.");
                tempFlag = Integer.parseInt(br.readLine());
            }
            if(tempFlag == 1) break;
            else{
                System.out.println("재입력을 선택하셨습니다.");
            }
        }
        System.out.println("금주의 회차는 " + thisWeekNo + "회 입니다.");

        makeLine();//////////////////////////////////////////////////////////////////////////

        System.out.println("역대 당첨번호를 입력합니다.");
        System.out.println("동행 복권사이트에서 다운받은 엑셀을 (1회차부터 입력회차 까지) 긁어 넣습니다. 이때 회차는 역순 상태 그대로 입력합니다.");

        int[][] historyNum = new int[thisWeekNo][7];

        // 이 부분에 번호 제대로 들어갔는지 검증하는 방법



        for(int i=thisWeekNo-1; i>=0;i--){
            st = new StringTokenizer(br.readLine(),"\t");
            int sumTemp = 0;
            for(int j=0;j<6;j++){
                if(!st.hasMoreTokens()) {
                    System.out.println("6자리 이하의 로또번호가 들어왔습니다. ");
                }
                String check = st.nextToken();
                if(!numberOnlyCheck(check)){
                    System.out.println("숫자가 아닙니다. 혹은 \\t로 개행하신 것 맞나요?");
                }
                historyNum[i][j] = Integer.parseInt(check);
                if(historyNum[i][j] <= 0 || historyNum[i][j] >45){
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



    }

    public static void cleanScreen(){
        for(int i=0;i<80;i++){
            System.out.println();
        }
    }

    public static void makeLine(){
        for(int i=0;i<40;i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static boolean numberRangeCheck(String num){
        if(num.length()>=10){
            return false;
        }
        return true;
    }

    public static boolean numberOnlyCheck(String num){
        final String REGEX = "[0-9]+"; // 숫자 확인 정규 표현식
        if(num.matches(REGEX)){
            return true;
        }
        return false;
    }

}
