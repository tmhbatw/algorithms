package problem1;

import java.util.*;

public class problem1_25 {
    /*Description
    * 对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，
    * 则按照数值大小排序。例如，给定数组为{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}，
    * 则排序后结果为{3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}。
    * */

    public static void main(String[] args){


        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int testNumber=Integer.parseInt(s.nextLine());
            while(testNumber-->0){
                int number=Integer.parseInt(s.nextLine());
                Map<Integer,Integer> map=new HashMap<>();
                String[] num=s.nextLine().split(" ");
                for(String cur:num){
                    int curNumber=Integer.parseInt(cur);
                    map.put(curNumber,map.getOrDefault(curNumber,0)+1);
                }
                PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[1]==o2[1])
                            return o1[0]-o2[0];
                        return o2[1]-o1[1];
                    }
                });
                for(Map.Entry entry:map.entrySet())
                    priorityQueue.add(new int[]{(int)entry.getKey(),(int)entry.getValue()});
                while(!priorityQueue.isEmpty()){
                    int[] cur=priorityQueue.poll();
                    while(cur[1]-->0)
                        System.out.print(cur[0]+" ");
                }
                System.out.println();
            }
        }
    }
}
