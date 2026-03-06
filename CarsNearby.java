import java.lang.classfile.instruction.ArrayStoreInstruction;
import java.util.*;

public class CarsNearby {

     public static class points  implements Comparable<points>{

    int x;
    int y;
    String name;
    int distSqr;


    points(int x, int y, String name,  int distSqr){
        this.x=x;
        this.y=y;
        this.name= name;
        this.distSqr= distSqr;
    }
    @Override
    public int compareTo(points p2){
        return this.distSqr -p2.distSqr;
    }



     }


        public static void NearbyCar(int points[][], int k){

             PriorityQueue<points> pq= new PriorityQueue<>();
             for(int i=0; i<points.length; i++){
                 int distSqr= points[i][0]*points[i][0]+points[i][1]*points[i][1];
                 pq.add(new points(points[i][0], points[i][1], "C"+i, distSqr));

             }
             for(int i=0; i<k; i++){
                points p = pq.remove();
                System.out.println(p.name);
             }


        }


    

          
         public static void ConnectNropes(int ropes[]){
        int totalCost=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }
        while(pq.size()>1){
            int first= pq.remove();
            int second= pq.remove();
            int cost = first+second;
            totalCost+=cost;
            pq.add(cost);
            System.out.println("Last cost to connect "+first+" and "+second+" is "+cost);
        }
        System.out.println("Total cost to connect ropes: " + totalCost);
   }


        

   public static void main(String args[]){

   int points[][]={{3,3},{5,-1},{-2,4}};
   int ropes[]= {2,3,3,4,6};
   ConnectNropes(ropes);
   PriorityQueue<Integer> pq= new PriorityQueue<>();
   ArrayList<Integer> list= new ArrayList<>();
   for(int i=0; i<ropes.length; i++){
    pq.add(ropes[i]);
   }
   Arrays.sort(ropes);
   int outside= ropes[0];
   for(int i=1; i<ropes.length; i++){
        int sum= outside+ropes[i];
        list.add(sum);
        outside= sum;
   }  int sum2=0;
   for(int i=0; i<list.size(); i++){
       sum2+= list.get(i);
   }
   System.out.println("this is the sum is here of the n ropes connect "+sum2);

   int k=2;
   NearbyCar(points, k);

  System.out.println("Hi This is the Problems of the Nearby cars");


   }
    
    // Class implementation goes here
}