package problem1;

import java.util.Arrays;
import java.util.Scanner;

public class problem1_5 {
    /*Description
    *
    * Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An].
    * He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.
    * The problem is to find the minimum time to get this job done under the constraints that any
    * painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1}
    * or nothing but not board {2, 4, 5}.
    * Input
    * The first line consists of a single integer T, the number of test cases. For each test case,
    * the first line contains an integer k denoting the number of painters and integer n denoting
    * the number of boards. Next line contains n- space separated integers denoting the size of
    * boards.Constraints:1<=T<=1001<=k<=301<=n<=501<=A[i]<=500
    * Output
    * For each test case, the output is an integer displaying the minimum time for painting that house.
    * */

    private static int getRes(int[] num,int k){
        int n=num.length;
        int[][] dp=new int[k+1][n+1];
        for(int i=1;i<=n;i++){
            dp[1][i]+=dp[1][i-1]+num[i-1];
        }
        for(int i=2;i<=k;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.max(num[j-1],dp[i-1][j-1]);
                int curSum=num[j-1];
                for(int l=j-1;l>=1;l--){
                    curSum+=num[l-1];
                    dp[i][j]=Math.min(dp[i][j],Math.max(curSum,dp[i-1][l-1]));
                }
            }
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        return dp[k][n];
    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testcaseNumber=Integer.parseInt(s.nextLine());
            while(testcaseNumber-->0){
                String[] val=s.nextLine().split(" ");
                int k=Integer.parseInt(val[0]);
                int n=Integer.parseInt(val[1]);
                String[] number=s.nextLine().split(" ");
                int[] num=new int[n];
                for(int i=0;i<n;i++)
                    num[i]=Integer.parseInt(number[i]);
                System.out.println(getRes(num,k));
            }
        }
    }


}
