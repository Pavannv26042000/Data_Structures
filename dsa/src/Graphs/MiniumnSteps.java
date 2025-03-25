package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MiniumnSteps{

    public static void main(String[] args) {
        int[] arr = {9 , 12 , 18 , 19};
        int src = 4 ;
        int dest = 55;
        MiniumnSteps miniumnSteps = new MiniumnSteps();
       int val =  miniumnSteps.minimumMultiplications(arr, src, dest);
       System.out.println(val + " ___");
    }
        class Pair{
        int first;
        int second;
        
        Pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {

        int[] dist = new int[100000];
        for(int i = 0 ; i < dist.length ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[start] = 0;
        
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair( 0 , start));
        while(!que.isEmpty()){
            int step = que.peek().first;
            int value = que.peek().second;
            que.remove();
            
            for(int i = 0 ; i < arr.length ; i++){
                int num = (arr[i] * value) % 100000;
                if(dist[step] + 1 < dist[num]){
                    dist[num] = dist[step]+ 1;
                    if(num == end )  return step + 1;
                    que.add(new Pair (step + 1 , num));
                }
            }
        }
        
        return -1;
    }
}