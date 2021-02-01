package problem1;

import java.util.Scanner;

public class problem1_8 {
    /*Description
    *Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
    * The first line of input consists number of the test cases.
    * The following T lines consist of 3 numbers each separated by a space and in the
    *  following order:A B C'A' being the base number, 'B' the exponent (power to the base number)
    * and 'C' the modular.Constraints:1 ≤ T ≤ 70,1 ≤ A ≤ 10^5,1 ≤ B ≤ 10^5,1 ≤ C ≤ 10^5
    * */

    public static void main(String[] args){
        for(int i=0;i<5;i++){
            System.out.print((int)(Math.random()*10000));
            System.out.print(" ");
            System.out.print((int)(Math.random()*10000));
            System.out.print(" ");
            System.out.println((int)(Math.random()*10000));
        }
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testNumber=Integer.parseInt(s.nextLine());
            while(testNumber-->0){
                String[] number=s.nextLine().split(" ");
                int A=Integer.parseInt(number[0]);
                int B=Integer.parseInt(number[1]);
                int C=Integer.parseInt(number[2]);
                int result=1;
                while(B-->0){
                    result*=A;
                    result%=C;
                }
                System.out.println(result);
            }
        }
    }
}
