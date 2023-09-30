import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int count = 0;

        count = getCount(0,255);

        System.out.println("로또 번호 모든 경우의 수 : " + count);

        createNumber c = createNumber.getInstance();
        int[] num = c.create();
        line(); //////////////////////////////////////////////////////////////////
        System.out.println("그냥 번호 한 개 생성");
        for(int i=0;i<num.length;i++){
            sb.append(num[i] + " ");
        }
        System.out.println(sb.toString());
//        line(); //////////////////////////////////////////////////////////////////
//
//        System.out.println("1 2 3 4 5 6 나올 확률");
//        int[] oneToSix = {1,2,3,4,5,6};
//        count = 0;
//        boolean flag = false;
//        while(!flag) {
//            flag = c.verification(oneToSix, c.create());
//            count++;
//        }
//        System.out.println("1/"+count);
//        System.out.println("10회 평균");
//        for(int i=0;i<9;i++){
//            flag = false;
//            while(!flag) {
//                flag = c.verification(oneToSix, c.create());
//                count++;
//            }
//        }
//        System.out.println("1/"+(count/10));
//        line(); //////////////////////////////////////////////////////////////////
//        System.out.println("4 7 17 18 38 44 나올 확률");
//        int[] latest = {4,7,17,18,38,44};
//        count = 0;
//        flag = false;
//        while(!flag) {
//            flag = c.verification(latest, c.create());
//            count++;
//        }
//        System.out.println("1/"+count);
//        System.out.println("10회 평균");
//        for(int i=0;i<9;i++){
//            flag = false;
//            while(!flag) {
//                flag = c.verification(latest, c.create());
//                count++;
//            }
//        }
//        System.out.println("1/"+(count/10));
//        line(); //////////////////////////////////////////////////////////////////
//        System.out.println("40 41 42 43 44 45 나올 확률");
//        int[] lastSix = {40,41,42,43,44,45};
//        count = 0;
//        flag = false;
//        while(!flag) {
//            flag = c.verification(lastSix, c.create());
//            count++;
//        }
//        System.out.println("1/"+count);
//        System.out.println("10회 평균");
//        for(int i=0;i<9;i++){
//            flag = false;
//            while(!flag) {
//                flag = c.verification(lastSix, c.create());
//                count++;
//            }
//        }
//        System.out.println("1/"+(count/10));
        line(); //////////////////////////////////////////////////////////////////

        System.out.println("번호합 48미만, 238 초과 제외");
        count = getCount(48,238);

        System.out.println("경우의 수 : " + count);
        System.out.println("제외된 경우의 수 : " + (8145060-count));
        line();
        System.out.println("번호합 50미만, 200 초과 제외");
        count = getCount(50,200);
        System.out.println("경우의 수 : " + count);
        System.out.println("제외된 경우의 수 : " + (8145060-count));
        line();
        System.out.println("번호합 100미만, 200 초과 제외");
        count = getCount(100,200);
        System.out.println("경우의 수 : " + count);
        System.out.println("제외된 경우의 수 : " + (8145060-count));
        line();
        System.out.println("번호합 100미만, 150 초과 제외");
        count = getCount(100,150);
        System.out.println("경우의 수 : " + count);
        System.out.println("제외된 경우의 수 : " + (8145060-count));
        line();

        int[] averCount = new int[256];

        for(int i=1;i<=45;i++){
            for(int j=i+1; j<=45;j++){
                for(int k=j+1; k<=45;k++){
                    for(int l=k+1;l<=45;l++){
                        for(int m=l+1;m<=45;m++){
                            for(int n=m+1;n<=45;n++){
                                int sum = i+j+k+l+m+n;
                                averCount[sum]++;
                            }
                        }
                    }
                }
            }
        }

        for(int i=21;i<=255;i++){
            System.out.printf("%8d ", i);
        }
        System.out.println();
        for(int i=21;i<=255;i++){
            System.out.printf("%8d ", averCount[i]);
        }
        System.out.println();
        line();
        System.out.println("번호합 120미만, 160 초과 제외");
        count = getCount(120,160);
        System.out.println("경우의 수 : " + count);
        System.out.println("제외된 경우의 수 : " + (8145060-count));
        line();


        boolean[] numCheck = new boolean[45];
        numCheck[1] = numCheck[4] = numCheck[18] = numCheck[19] = numCheck[27] = numCheck[38] = numCheck[40] = true;
        count = 0;
        for(int i=1;i<=45;i++){
            if(numCheck[i-1]) continue;
            for(int j=i+1; j<=45;j++){
                if(numCheck[j-1]) continue;
                for(int k=j+1; k<=45;k++){
                    if(numCheck[k-1]) continue;
                    for(int l=k+1;l<=45;l++){
                        if(numCheck[l-1]) continue;
                        for(int m=l+1;m<=45;m++){
                            if(numCheck[m-1]) continue;
                            for(int n=m+1;n<=45;n++){
                                if(numCheck[n-1]) continue;
                                int sum = i+j+k+l+m+n;
                                if(sum>=120 && sum <=160) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("2, 5, 19, 20, 28, 39, 41를 제외한 번호합 120 ~ 160의 경우의 수 " + count);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        for(int i=0;i<1086;i++){
//            st = new StringTokenizer(br.readLine(), "\t");
//            int[] temp = new int[6];
//            for(int j=0;j<6;j++){
//                temp[j] = Integer.parseInt(st.nextToken());
//                System.out.print(temp[j] + " ");
//            }
//            System.out.println();
//        }

//        System.out.println("최근 회차를 입력하시오.");
//        int no = Integer.parseInt(br.readLine());
//
//        System.out.println("1회차 부터 최근 회차까지 입력하시오");
//        int[] release = new int[45];
//        for(int i=0;i<no;i++){
//            for(int k=0;k<45;k++){
//                release[k]++;
//            }
//            st = new StringTokenizer(br.readLine(),"\t");
//            for(int j=0;j<6;j++){
//                release[Integer.parseInt(st.nextToken())-1] = 0;
//            }
//        }
//        System.out.println("연속 미출현 정보입니다.");
//        for(int i=0;i<45;i++){
//            System.out.print((i+1) + "번은 연속 " + release[i] + "번 미출현 했습니다.");
//            System.out.println();
//        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] history = new int[1086][7];
        for(int i=0;i<1086;i++){
            st = new StringTokenizer(br.readLine(), "\t");
            int total = 0;
            for(int j=0;j<6;j++){
                int temp = Integer.parseInt(st.nextToken());
                total += temp;
                history[i][j] = temp;
            }
            history[i][6] = total;
        }

        count = 0;
        for(int i=0;i<1085;i++){
            for(int j=i+1; j<1086;j++){
                if(history[i][6] == history[j][6]){
                    boolean flag = true;
                    for(int k=0;k<6;k++){
                        if(history[i][k] != history[j][k]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) count++;
                }
            }
        }

        System.out.println("같은 번호의 수는 " + count);

    }

    public static void line(){
        for(int i=0;i<40;i++)
        System.out.print("-");
        System.out.println();
    }

    public static int getCount(int start, int end){
        int count=0;
        for(int i=1;i<=45;i++){
            for(int j=i+1; j<=45;j++){
                for(int k=j+1; k<=45;k++){
                    for(int l=k+1;l<=45;l++){
                        for(int m=l+1;m<=45;m++){
                            for(int n=m+1;n<=45;n++){
                                int sum = i+j+k+l+m+n;
                                if(sum>=start && sum <=end)
                                    count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}