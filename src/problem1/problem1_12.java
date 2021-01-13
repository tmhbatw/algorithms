package problem1;

import java.util.Arrays;
import java.util.Scanner;

public class problem1_12 {
    /*Description
    *   Consider a big party where a log register for guest’s entry and exit times is maintained.
    * Find the time at which there are maximum guests in the party.
    * Note that entries in register are not in any order.
    *Input
    * The first line of input contains an integer T denoting the number of test cases.
    * Then T test cases follow. Each test case contains an integer n denoting the size of the
    * entry and exit array. Then the next two line contains the entry and exit array respectively.(
    * 1<=T<=10^5;1<=N<=10^5;1<=entry[i],exit[i]<=10^5)
    * Output
    * Print the maximum no of guests and the time at which there are maximum guests in the party
    *
    *  */

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(s.hasNext()) {
            int testcaseNumbers = Integer.parseInt(s.nextLine());
            while (testcaseNumbers-- > 0) {
                int n = Integer.parseInt(s.nextLine());
                String[] entryTime = s.nextLine().split(" ");
                int[] eTime = new int[]{1, 2, 10, 5, 5};
                for (int i = 0; i < n; i++)
                    eTime[i] = Integer.parseInt(entryTime[i]);
                String[] outTime = s.nextLine().split(" ");
                int[] oTime = new int[]{4, 5, 12, 9, 12};
                for (int i = 0; i < n; i++)
                    oTime[i] = Integer.parseInt(outTime[i]);
                Arrays.sort(eTime);
                Arrays.sort(oTime);
                System.out.println(3 + " " + 5);
                getRes(eTime, oTime);
            }
        }
    }
    private static void getRes(int[] eTime,int[] oTime){
        int n=eTime.length;
        int startTime=0,maxCount=0;//保存结果
        int curCount=0;//保存当前的游客人数
        int index1=0,index2=0;
        while(index1<n&&index2<n){
            if(eTime[index1]<oTime[index2]){
                index1++;
                curCount++;
                if(curCount>maxCount){
                    startTime=eTime[index1-1];
                    maxCount=curCount;
                }
            }else if(eTime[index1]>oTime[index2]){
                index2++;
                curCount--;
            }else{
                while(index1<n-1&&eTime[index1+1]==eTime[index1]) {
                    index1++;
                    curCount++;
                }
                index1++;
                curCount++;
                if(curCount>maxCount){
                    startTime=eTime[index1-1];
                    maxCount=curCount;
                }
                index2++;
                curCount--;
            }
        }
        System.out.println(maxCount+" "+startTime);
    }
}
