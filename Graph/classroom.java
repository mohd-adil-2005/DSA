import java.util.*;
public class Classroom{

    public  static class Edge{
        int src;
        int dest;
        int w;
    public Edge(int src, int dest, int w){
        this.src= src;
        this.dest= dest;
        this.w=w;
    }


    }


    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
        graph[4].add(new Edge(4,2,2));
    }


    /// Bfs   algo rtith
    public static void BfsAlgo(ArrayList<Edge>graph[]){
            boolean vis[]= new boolean[graph.length];
            for(int i=0; i<graph.length; i++){
                if(!vis[i]){
                     bfsUtil(graph, i, vis);
                }
            }
    }


    public static void bfsUtil(ArrayList<Edge>[] graph, int src, boolean vis[]){
             Queue<Integer> q= new LinkedList<>();
             q.add(src);
             while(!q.isEmpty()){
                int curr= q.remove();
                if(!vis[curr]){
                    vis[curr]= true;
                    System.out.println("Visiting: " + curr);
                    for(int i=0; i<graph[curr].size(); i++){
                        Edge e = graph[curr].get(i);
                        q.add(e.dest);
                    }
                }
             }
    }
    public static void main(String[] args){
        System.out.println("Hello, Graph");
        int v=5;
        @SuppressWarnings("unchecked")
       ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        BfsAlgo(graph);
    }
}
