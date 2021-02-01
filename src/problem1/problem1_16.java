package problem1;

import java.util.Arrays;
import java.util.Scanner;

public class problem1_16 {
    /*Description
    * 实现插入排序。
    * */

    public static void main(String[] args){
        for(int i=0;i<100;i++){
            System.out.print(100-i+" ");
        }
        for(int i=0;i<100;i++)
            System.out.print(i+" ");
        System.out.println();
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testNumber=Integer.parseInt(s.nextLine());
            while(testNumber-->0){
                String[] number=s.nextLine().split(" ");
                int[] num=new int[number.length];
                for(int i=0;i<num.length;i++)
                    num[i]=Integer.parseInt(number[i]);
                Arrays.sort(num);
                System.out.print(num[0]);
                for(int i=1;i<num.length;i++)
                    System.out.print(" "+num[i]);
                System.out.println();
            }
        }
    }
}
