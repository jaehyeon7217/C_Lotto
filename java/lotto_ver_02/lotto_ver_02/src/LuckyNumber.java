public class LuckyNumber {
    private int[] num;
    private int sum;

    private int sumMin;
    private int sumMax;

    private boolean[] check;

//    public LuckyNumber(){
//        boolean[] check = new boolean[45];
//        new LuckyNumber(21,255,check);
//    }
//
//    public LuckyNumber(int sumMin, int sumMax){
//        boolean[] check = new boolean[45];
//        new LuckyNumber(sumMin,sumMax,check);
//    }
//
//    public LuckyNumber(boolean[] check){
//        new LuckyNumber(21,255,check);
//    }

    public LuckyNumber(int sumMin, int sumMax, boolean[] check){
        this.num = new int[6];
        this.sum = 0;
        this.sumMin = sumMin;
        this.sumMax = sumMax;
        this.check = check;
    }

    public void createNumber(){
        while(true){
            int[] tempNum = getNumber();
            int sum = 0;
            for(int i=0;i<6;i++){
                sum += tempNum[i];
            }
            if(sum>=this.sumMin && sum<=this.sumMax){
                this.num = tempNum;
                this.sum = sum;
                break;
            }
        }

        pr();

    }

    public void pr(){
        for(int i=0;i<6;i++){
            System.out.print(this.num[i] + " ");
        }
        System.out.print("   " + this.sum);
        System.out.println();
    }

    public int[] getNumber(){
        boolean[] deduplication = new boolean[45];

        for(int i=0;i<45;i++){
            if(check[i]){
                deduplication[i] = true;
            }
        }

        boolean[] lotto = new boolean[45];
        int count = 0;

        while(count<6){
            int num = (int)(Math.random()*45);
            if(deduplication[num]) continue;
            deduplication[num] = true;
            lotto[num] = true;
            count++;
        }

        int[] lottoNum = new int[6];
        count = 0;
        for(int i=0;i<45;i++){
            if(lotto[i]){
                lottoNum[count++] = i+1;
                if(count == 6) break;
            }
        }

        return lottoNum;
    }

//    public void setSumRange(int min, int max){
//        if(min<21 || min >=255) {
//            System.out.println("최소 범위는 21이상 255미만이어야 합니다.");
//        }
//        if(max<=21 || max>255){
//            System.out.println("최소 범위는 21초과 255이하이어야 합니다.");
//        }
//        this.sumMin=min;
//        this.sumMax=max;
//    }
//
//    public void resetSumRange(){
//        this.sumMax=21;
//        this.sumMin=255;
//    }
//
//    public void setExceptNum(int[] exNum){
//        for(int i=0;i<exNum.length;i++){
//            if(exNum[i]<=0 || exNum[i]>45){
//                System.out.println("범위를 초과한 수가 들어왔습니다.");
//                resetExceptNum();
//                return;
//            }
//            check[exNum[i]]=true;
//        }
//    }
//
//    public void resetExceptNum(){
//        // 초기화
//        for(int j=0;j<45;j++){
//            check[j]=false;
//        }
//    }

}
