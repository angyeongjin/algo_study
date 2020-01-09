

import java.util.ArrayList;

public class 소수의연속합2 {
    public static void getPrime(ArrayList<Integer> prime , int num){
        int cnt = 0;
        prime.add(2);
        for(int i=2; i <= num; i++){
            for(int j=0; j<prime.size(); j++){
                if(i%prime.get(j)==0){
                    break;
                }
                if(j+1 == prime.size()){
                    prime.add(i);
                }
            }
        }
        for(int i = 0; i<prime.size(); i++){
            cnt++;
            System.out.println(prime.get(i));
        }
        System.out.println("소수 개수 : " + cnt);
    }
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        ArrayList<Integer> prime = new ArrayList<Integer>(); 
        getPrime(prime, 4000000);
        long end = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (double)(end-start)/1000 + "(s)");
    }
}
