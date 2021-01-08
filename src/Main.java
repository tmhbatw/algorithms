import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int testcaseNumber= Integer.parseInt(s.nextLine());
        //测试每一个测试用例
        while(testcaseNumber-->0){
            //将数据读取出来
            int n=Integer.parseInt(s.nextLine());
            String[] number=s.nextLine().split(" ");
            int[] num=new int[n+1];
            for(int i=0;i<n;i++)
                num[i+1]=num[i]+Integer.parseInt(number[i]);
            Map<Integer,Integer> map=new HashMap<>();
            int m= Integer.parseInt(s.nextLine());
            System.out.println(getMinSum(n,num,0,m,map));
        }
    }

    private static int getRes(int n,int start,int m){
        return n*start+m;
    }

    private static int getMinSum(int n,int[] dp,int start,int m,Map<Integer,Integer> map){
        if(n<m)
            return -1;
        if(m==1)
            return dp[n]-dp[start];
        int min=Integer.MAX_VALUE;
        for(int i=start+1;i<=n-m+1;i++){
            int post=getRes(n,i,m-1);
            if(!map.containsKey(post))
                map.put(post,getMinSum(n,dp,i,m-1,map));
            min=Math.min(min,Math.max(dp[i]-dp[start],map.get(post)));
        }
        return min;
    }
}
