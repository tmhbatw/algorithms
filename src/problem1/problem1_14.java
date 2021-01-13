package problem1;

import java.util.Arrays;
import java.util.Scanner;

public class problem1_14 {
    /*Description
    * Given K sorted arrays arranged in a form of a matrix, your task is to merge them.
    * You need to complete mergeKArrays function which takes 2 arguments,
    * an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the no. of sorted arrays.
    * The function should return a pointer to the merged sorted arrays. There are multiple test cases.
    * For each test case, this method will be called individually.
    * Input
    * The first line of input will denote the no of Test cases then T test cases will follow .
    * Each test cases will contain an integer N denoting the no of sorted arrays.
    * Then in the next line contains all the elements of the array separated by space.（1<=T<=50；1<=N<=10）
    * Output
    * The output will be the sorted merged array.
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testcaseNumber=Integer.parseInt(s.nextLine());
            while(testcaseNumber-->0){
                int N=Integer.parseInt(s.nextLine());
                String[] number=s.nextLine().split(" ");
                int[] num=new int[N*N];
                for(int i=0;i<N*N;i++)
                    num[i]=Integer.parseInt(number[i]);
                Arrays.sort(num);
                System.out.println(Arrays.toString(num));
            }
        }
    }
}
