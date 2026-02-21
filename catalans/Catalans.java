import java.util.Arrays;

class Catalans {
    public static int catalans(int n, int dp[]){
      if(n==0|| n==1){
        return 1;
      }
      if(dp[n]!=-1){
        return dp[n];
      }
      int ans =0;
      for(int i=0; i<n; i++){
        ans+=catalans(i,dp)*catalans(n-i-1,dp);
      }
      dp[n]=ans;  
      return ans;
    }


    public static int catalansTab(int n){
      int dp[]= new int[n+1];
      dp[0]=1;
      dp[1]=1;
      for(int i=2; i<=n; i++){
        for(int j=0; j<i; j++){
          dp[i]+=dp[j]*dp[i-j-1];
        }
      }
      return dp[n];
    }
  public static void main(String[] args){
      System.out.println("hello , catalans concept");
      int n=4000000;
      int dp[]= new int[n+1];
      Arrays.fill(dp,-1);
      System.out.println(catalansTab(n));
  }

}
