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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));

        graph[1].add(new Edge(0, 0, 10));
        graph[1].add(new Edge(0, 3, 40));

        graph[2].add(new Edge(2, 0, 15));

        graph[2].add(new Edge(2, 3, 50));
         graph[3].add(new Edge(3, 1, 40));

        graph[3].add(new Edge(3, 2, 50));
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
    public static class pair implements Comparable<pair> {
     int v;
      int cost;
      pair(int v, int cost){
        this.v= v; 
        this.cost= cost;
      }
      @Override
      public int compareTo(pair p2){
        return this.cost - p2.cost;
      }


    }


    public static class EdgeList{
        int v;
        int cost;
        EdgeList(int v, int cost){
            this.v= v;
            this.cost= cost;
        } 


    }

    

    public static void mst(ArrayList<Edge>[] graph){
          boolean vis[]= new boolean[graph.length];
           ArrayList<EdgeList> mstEdges= new ArrayList<>();
          int costfinal=0;
            PriorityQueue<pair> pq= new PriorityQueue<>();
            pq.add(new pair(0, 0));
              while(!pq.isEmpty()){
                pair curr= pq.remove();
                if(!vis[curr.v]){
                    vis[curr.v]=true;
                    costfinal+=curr.cost;
                    mstEdges.add(new EdgeList(curr.v, curr.cost));

                 for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e= graph[curr.v].get(i);
                    pq.add(new pair(e.dest,e.w));
                 }

                }
              }

              for(int i=0; i<mstEdges.size(); i++){
                  EdgeList e= mstEdges.get(i);
                  System.out.println("Edge: " + e.v + " Cost: " + e.cost);
              } 
              System.out.println("the costs is that"+costfinal);

    }
    public static void main(String[] args){
        System.out.println("Hello, Graph");
        int v=6;
        @SuppressWarnings("unchecked")
       ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        // BfsAlgo(graph);
        // System.out.println("the Graph that is given is Bipartite:"+isBipartite(graph));
        // topsort(graph);
        mst(graph);
    }
}
