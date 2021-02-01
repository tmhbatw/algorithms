package problem1;

import java.util.*;

public class problem1_22 {
    /*Description
    *实现Shell排序，对给定的无序数组，按照给定的间隔变化（间隔大小即同组数字index的差），打印排序结果，注意不一定是最终排序结果！
     * */

    public static void main(String[] args){
        for(int i=0;i<50;i++){
            System.out.print((int)(Math.random()*100)+" ");
        }
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testNumber=Integer.parseInt(s.nextLine());
            while(testNumber-->0){
                String[] number=s.nextLine().split(" ");
                int[] num=new int[number.length];
                for(int i=0;i<number.length;i++)
                    num[i]=Integer.parseInt(number[i]);
                String[] shell=s.nextLine().split(" ");
                int[] she=new int[shell.length];
                for(int i=0;i<she.length;i++)
                    she[i]=Integer.parseInt(shell[i]);
                for(int cur:she){
                    for(int i=0;i<cur;i++){
                        List<Integer> list=new ArrayList<>();
                        for(int j=i;j<num.length;j+=cur)
                            list.add(num[j]);
                        int index=0;
                        Collections.sort(list);
                        for(int j=i;j<num.length;j+=cur)
                            num[j]=list.get(index++);
                    }
                }
                System.out.print(num[0]);
                for(int i=1;i<num.length;i++)
                    System.out.print(" "+num[i]);
                System.out.println();
            }
        }
    }
}
