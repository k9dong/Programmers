import java.util.*;
class Solution {
    private static List<String> list = new ArrayList<>();
    private static boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean [tickets.length];
        dfs(tickets,"ICN","ICN",0);
        
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    private static void dfs(String[][] tickets, String route, String start, int idx){
        if(idx==tickets.length){
            list.add(route);
        }
        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets,route+" "+tickets[i][1],tickets[i][1],idx+1);
                visited[i] = false;
            }
        }
        
        
    }
}