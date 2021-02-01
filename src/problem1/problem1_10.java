package problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problem1_10 {
    /*Description
    * You are given N number of books. Every ith book has Pi number of pages.
    * You have to allocate books to M number of students. There can be many ways or permutations to do so.
    * In each permutation one of the M students will be allocated the maximum number of pages.
    * Out of all these permutations, the task is to find that particular permutation in which the maximum
    * number of pages allocated to a student is minimum of those in all the other permutations,
    * and print this minimum value. Each book will be allocated to exactly one student.
    * Each student has to be allocated at least one book.每一个学生只能分配连续出现的书本。
    * */

    /*Solution
    * 实则是一个数组分成n个区间要求每个区间和最小
    *使用了递归，应该可以动态规划优化一下算法
    * */

    public static void main(String[] args){
        for(int i=0;i<3;i++){
            int n=(int)(Math.random()*50);
            System.out.println(n);
            while(n-->0){
                System.out.print((int)(Math.random()*250)+" ");
            }System.out.println();
            System.out.println((int)(Math.random()*50));
        }
        Scanner s=new Scanner(System.in);
        while(s.hasNext()) {
            int testcaseNumber = Integer.parseInt(s.nextLine());
            //测试每一个测试用例
            while (testcaseNumber-- > 0) {
                //将数据读取出来
                int n = Integer.parseInt(s.nextLine());
                String[] number = s.nextLine().split(" ");
                int[] num = new int[n + 1];
                for (int i = 0; i < n; i++)
                    num[i + 1] = num[i] + Integer.parseInt(number[i]);
                Map<Integer, Integer> map = new HashMap<>();
                int m = Integer.parseInt(s.nextLine());
                System.out.println(getMinSum(n, num, 0, m, map));
            }
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
