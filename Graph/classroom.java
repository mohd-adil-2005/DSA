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


    public static void topsort(ArrayList<Edge>[] graph){
        int inddeg[]= new int[graph.length];
         for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                inddeg[e.dest]++;
            }
         }

         Queue<Integer> q= new LinkedList<>();
         for(int i=0; i<graph.length; i++){
            if(inddeg[i]==0){
                q.add(i);
            }
         }
         while(!q.isEmpty()){
            int curr= q.remove();
            System.out.println("visting toposrt nodes " + curr);
                 for(int i=0; i<graph[curr].size(); i++){
                      Edge e= graph[curr].get(i);
                      inddeg[e.dest]--;
                      if(inddeg[e.dest]==0){
                        q.add(e.dest);
                      }
                 }
         }
       
    }


    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        // graph[0].add(new Edge(0,1,5));
        // graph[0].add(new Edge(0,2,1));

          graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));
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



    // is bipartite Graph
    public static boolean isBipartite(ArrayList<Edge> [] graph){
           int col[]= new int[graph.length];
           Arrays.fill(col, -1);
           Queue<Integer> q= new LinkedList<>();
           for(int i=0; i<graph.length; i++){
            if(col[i]==-1){
                col[i]=0;
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++){
                         Edge e = graph[curr].get(j);
                         if(col[e.dest]==col[curr]){
                            return false;
                         }

                         //we have to assign the color actually here  
                         if(col[e.dest]==-1){
                            int colnext= col[curr];
                            if(colnext==0){
                                col[e.dest]=1;
                            }else{
                                col[e.dest]=0;
                            }
                         }

                    }
                }
            }
           }
           return true;
    }
    public static void main(String[] args){
        System.out.println("Hello, Graph");
        int v=6;
        @SuppressWarnings("unchecked")
       ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        BfsAlgo(graph);
        System.out.println("the Graph that is given is Bipartite:"+isBipartite(graph));
        topsort(graph);
    }
}
