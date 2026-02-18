public class s {

static int tree[];
public static void init(int n){
   tree= new int[4*n];
}



/// segment tree implementation 
public static int build (int arr[], int i, int start, int end ){
   //base  acse
   if(start== end){
        tree[i]= arr[start];
        return arr[start];

   }
     int mid = (start+end)/2;
     build(arr, 2*i+1, start, mid);
     build(arr, 2*i+2, mid+1, end);
     tree[i]=tree[2*i+1]+tree[2*i+2];
     return tree[i];
   }

   public static int getSum(int i , int si, int sj ,int qi, int qj){
      // base case
      if(qj<si|| qi>sj){
         return 0;
      }
      else if(si>=qi && sj<=qj){
         return tree[i];
      }
      else {
         int mid = (si+sj)/2;
         return getSum(2*i+1, si, mid, qi, qj) + getSum(2*i+2, mid+1, sj, qi, qj);
      }
   }



   public static void main(String[] args) {
      System.out.println("Hi this is my segment tree logic chapter Here !");
      int arr[]= {1,2,3,4,5,6,7,8};
      int n = arr.length;
      init(n);
      build(arr, 0, 0, n-1); 
      for(int i=0; i<tree.length; i++){
         System.out.print(tree[i]+" ");
      }
      System.out.println("Sum of range (2, 4): " + getSum(0, 0, n-1, 2, 4));
   }
}

