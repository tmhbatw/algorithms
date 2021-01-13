package problem1;

import java.util.Arrays;
import java.util.Scanner;

public class problem1_7 {
    /*Description
    *Given a Complete Binary tree, print the level order traversal in sorted order.
    * Input
    * The first line of the input contains integer T denoting the number of test cases.
    * For each test case, the first line takes an integer n denoting the size of array i.e number
    * of nodes followed by n-space separated integers denoting the nodes of the tree in level order
    * fashion.(1<=T<=100；1<=n<=10^5）
    * Output
    * For each test case, the output is the level order sorted tree.
    * ( Note: For every level, we only print distinct elements.)
    * */

    private static void print(int[] num,int start,int end){
        Arrays.sort(num,start,end);
        for(int i=start;i<end-1;i++){
            if(num[i]!=num[i+1])
                System.out.print(num[i]+" ");
        }
        System.out.println(num[end-1]);
    }

    private static int[] getNumber(Scanner s){
        int number=Integer.parseInt(s.nextLine());
        String[] res=s.nextLine().split(" ");
        int[] num=new int[number];
        for(int i=0;i<number;i++){
            num[i] = Integer.parseInt(res[i]);
        }
        return num;
    }


    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testcaseNumber=Integer.parseInt(s.nextLine());
            while(testcaseNumber-->0){
                int[] num=getNumber(s);
                int levelNumber=1;
                int start=0;
                int length=num.length;
                while(levelNumber+start<length){
                    print(num,start,start+levelNumber);
                    start+=levelNumber;
                    levelNumber*=2;
                }
                print(num,start,length);
            }
        }
    }
}
