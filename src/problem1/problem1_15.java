package problem1;

import java.util.*;

public class problem1_15 {
    /*Description
    * Given an array of N distinct elementsA[ ], find the minimum number of swaps required
    *  to sort the array.Your are required to complete the function which returns
    * an integer denoting the minimum number of swaps, required to sort the array.
    * */

    public static void main(String[] args){
        int nnnn=2;
        for(int i=0;i<nnnn;i++){
            int time=(int)(Math.random()*100);
            System.out.println(time);
            Set<Integer> set=new HashSet<>();
            for(int j=0;j<time;j++){
                int cur=(int)(Math.random()*1000);
                while(set.contains(cur))
                    cur=(int)(Math.random()*1000);
                set.add(cur);
                System.out.print(cur+" ");
            }System.out.println();
        }
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testNumber=Integer.parseInt(s.nextLine());
            while(testNumber-->0) {
                int number = Integer.parseInt(s.nextLine());
                String[] num = s.nextLine().split(" ");
                int[] n=new int[number];
                for(int i=0;i<number;i++)
                    n[i]=Integer.parseInt(num[i]);
                int[] nn=n.clone();
                Arrays.sort(nn);
                System.out.println("数组n为"+Arrays.toString(n));
                System.out.println("排序数组为+"+Arrays.toString(nn));
                Map<Integer,Integer> map1=new HashMap<>();//数字对应的index
                Map<Integer,Integer> map2=new HashMap<>();//index对应的数字
                for(int i=0;i<number;i++) {
                    map1.put(n[i], i);
                    map2.put(i, nn[i]);
                }
                System.out.println(map1);
                System.out.println(map2);
                int result=0;
                for(int i=0;i<number;i++){
                    if(map2.get(i)==n[i])
                        continue;
                    int temp=n[i];
                    n[i]=map2.get(i);
                    int index=map1.get(n[i]);
                    n[index]=temp;
                    map1.put(temp,index);
                    result++;
                    System.out.println(Arrays.toString(n));
                }
                System.out.println("经过排序的n为"+Arrays.toString(n));
                System.out.println(result);
            }
        }
    }
}
