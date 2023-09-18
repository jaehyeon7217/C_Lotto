import java.util.Random;

public class createNumber {

    public static createNumber instance = new createNumber();

    private createNumber(){

    }
    public static createNumber getInstance(){
        return instance;
    }


    public int[] create(){
        boolean[] check = new boolean[45]; // 중복 번호 제거

        int[] num = new int[6]; // 로또 번호
        int count = 0; // 이제껏 뽑은 로또 번호 수

        while(count<6){
            int n = (int)(Math.random()*45); // 0 ~ 44 까지의 수가 뽑힘
            if(check[n]){
                continue; // 뽑힌 수가 이미 뽑혔다면 다음으로 넘어가기
            }
            count++; // 뽑힌적 없으면 번호 뽑았으니 갯수 늘려주고
            check[n] = true; // 뽑혔다고 바꿔주기

        }
        count = 0;
        for(int i=0;i<45;i++){
            if(check[i]){
                num[count++] = i; // 낮은 순서대로 정렬
            }
        }

        return up(num); // 로또 번호는 1부터 45이니 1 증가
    }

    private int[] up(int[] n){
        for(int i=0;i<6;i++){
            n[i] += 1;
        }
        return n;
    }
    private int[] down(int[] n){
        for(int i=0;i<6;i++){
            n[i] -= 1;
        }
        return n;
    }

    public boolean verification(int[] one, int[] theOther) {
        boolean[] check = new boolean[45];
        one = down(one);
        theOther = down(theOther);
        for(int i=0;i<6;i++){
            check[one[i]] = true;
        }

        for(int i=0;i<6;i++){
            if(!check[theOther[i]]){
                one = up(one);
                theOther = up(theOther);
                return false;
            }
        }
        one = up(one);
        theOther = up(theOther);
        return true;
    }
}
