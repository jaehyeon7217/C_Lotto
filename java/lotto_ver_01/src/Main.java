import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
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