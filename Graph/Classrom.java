import java.util.ArrayList;
public class Classrom{
    
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
    public static void main(String[] args){
        System.out.println("Hello, Graph");
        int v=5;
        @SuppressWarnings("unchecked")
       ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<v; i++){
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
}
