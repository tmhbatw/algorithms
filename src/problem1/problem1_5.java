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
