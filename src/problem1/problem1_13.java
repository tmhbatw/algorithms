package problem1;

import java.util.Arrays;
import java.util.Scanner;

public class problem1_13 {
    /*Description
    * Given an array A of size N, find all combination of four elements in the
    * array whose sum is equal to a given value K. For example, if the given array is
    * {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple is “3 5 7 8” (3 + 5 + 7 + 8 = 23).
    * Input
    * The first line of input contains an integer T denoting the no of test cases.
    * Then T test cases follow. Each test case contains two lines. The first line of input contains
    * two integers N and K. Then in the next line are N space separated values of the array.（
    * 1<=T<=100；1<=N<=100；-1000<=K<=1000；-100<=A[]<=100）
    * Output
    * */

    private static int[] getNum(Scanner s){
        String[] res=s.nextLine().split(" ");
        int length=res.length;
        int[] number=new int[length];
        for(int i=0;i<length;i++)
            number[i]=Integer.parseInt(res[i]);
        Arrays.sort(number);
        return number;
    }

    private static void print(int cur1,int cur2,int cur3,int cur4){
        System.out.print(cur1+" "+cur2+" "+cur3+" "+cur4+" $");
    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testcaseNumber=Integer.parseInt(s.nextLine());
            while(testcaseNumber-->0){
                String[] firstLine=s.nextLine().split(" ");
                int N=Integer.parseInt(firstLine[0]);
                int T=Integer.parseInt(firstLine[1]);
                int[] number=getNum(s);
                for(int i=0;i<N;i++){
                    for(int j=i+1;j<N;j++){
                        int curTarget=T-number[i]-number[j];
                        int left=j+1,right=N-1;
                        while(left<right){
                            if(number[left]+number[right]<curTarget){
                                left++;
                            }else if(number[left]+number[right]>curTarget)
                                right--;
                            else{
                                print(number[i],number[j],number[left],number[right]);
                                while(left<N-1&&number[left+1]==number[left])
                                    left++;
                                while(right>left&&number[right-1]==number[right])
                                    right--;
                                left++;
                                right--;
                            }
                        }
                        while(j<N-1&&number[j+1]==number[j])
                            j++;
                    }
                    while(i<N-1&&number[i+1]==number[i])
                        i++;
                }
                System.out.println();
            }
        }
    }
}
