class Catalans {
    public static int catalans(int n){
      if(n==0|| n==1){
        return 1;
      }
      int ans =0;
      for(int i=0; i<n; i++){
        ans+=catalans(i)*catalans(n-i-1);
      }
      return ans;
    }
  public static void main(String[] args){
      System.out.println("hello , catalans concept");
      System.out.println(catalans(5));
  }

}
