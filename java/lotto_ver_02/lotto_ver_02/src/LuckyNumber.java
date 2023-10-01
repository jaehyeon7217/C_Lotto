public class LuckyNumber {
    private int[] num;
    private int sum;

    private int sumMin;
    private int sumMax;

    private boolean[] check;

    public LuckyNumber(){
        num = new int[6];
        sum = 0;
        sumMin = 21;
        sumMax = 255;
        check = new boolean[45];
    }

    public void setSumRange(int min, int max){
        if(min<21 || min >=255) {
            System.out.println("최소 범위는 21이상 255미만이어야 합니다.");
        }
        if(max<=21 || max>255){
            System.out.println("최소 범위는 21초과 255이하이어야 합니다.");
        }
        this.sumMin=min;
        this.sumMax=max;
    }

    public void resetSumRange(){
        this.sumMax=21;
        this.sumMin=255;
    }

    public void setExceptNum(int[] exNum){
        for(int i=0;i<exNum.length;i++){
            if(exNum[i]<=0 || exNum[i]>45){
                System.out.println("범위를 초과한 수가 들어왔습니다.");
                resetExceptNum();
                return;
            }
            check[exNum[i]]=true;
        }
    }

    public void resetExceptNum(){
        // 초기화
        for(int j=0;j<45;j++){
            check[j]=false;
        }
    }

}
