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



   public static void main(String args[]){

   int points[][]={{3,3},{5,-1},{-2,4}};
   int k=2;
   NearbyCar(points, k);

  System.out.println("Hi This is the Problems of the Nearby cars");


   }
    
    // Class implementation goes here
}