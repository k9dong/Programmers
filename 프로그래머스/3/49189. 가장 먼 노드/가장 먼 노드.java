import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){ //왜 1부터안하고 0부터 하는지
            graph.add(new ArrayList<>());
        }
        for(int [] e : edge){
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int [] d = new int[n+1];
        Arrays.fill(d,-1);
        d[1] =0;
        
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        while(!q.isEmpty()){
            int k = q.poll();
            for(int next :graph.get(k)){
                if(d[next] !=-1) continue;
                d[next] = d[k]+1;
                q.offer(next);
            }
        }
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            
            maxDist = Math.max(maxDist, d[i]);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] == maxDist) count++;
        }
        return count;
    }
}