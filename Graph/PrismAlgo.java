import java.util.*;

public class PrismAlgo {
     static class Edge implements Comparable<Edge>{
        int src;
         int dest;
         int w;

         Edge(int src, int dest, int w){
            this.src= src;
            this.dest= dest;
            this.w=w;
         }
         @Override
         public int compareTo(Edge e2){
            return this.w-e2.w;
         }
     }

    static int n =4;
    static  int par[]= new int[n];
    static int rank[]= new int[n];
    public static void init(){
        for(int i=0; i<n; i++){
            par[i]=i;

        }
    }
       public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]= find(par[x]);
       }


       public static void union(int a, int b){
           int parA= find(a);
           int parB=find(b);
           if(rank[parA]==rank[parB]){
               par[parB]=parA;
               rank[parA]++;
           }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
            rank[parB]++;
           }else{
               par[parB]=parA;
               rank[parA]++;
           }
       }
         
  public static void krsuakl(ArrayList<Edge>edges, int v){
      Collections.sort(edges);
      int mstCost=0;
      int count=0; 
      for(int i=0; count<v-1; i++){
        Edge e =  edges.get(i);
        int src= e.src;
        int dest= e.dest;
        int parA= find(src);
        int parB= find(dest);
        if(parA!=parB){
            union(parA, parB);
            mstCost+=e.w;
            count++;
        }

      }
      System.out.println("the cost is that "+mstCost);
  }



     public static void createGraph(ArrayList<Edge> edges){
         // Create a graph using the edges
         edges.add(new Edge(0,1,10));
edges.add(new Edge(0,2,15));
edges.add(new Edge(0,2,30));   // keep this, but MST will skip it
edges.add(new Edge(1,3,40));   // remove this or make it heavier
edges.add(new Edge(2,3,30));   // adjust this edge to weight 30
     }
    public static void main(String[] args) {
        System.out.println("Hello, PrismAlgo");
        ArrayList<Edge> edges= new ArrayList<>();
        createGraph(edges);
        init();
        krsuakl(edges, 4);
    }
}
