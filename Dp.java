import java.util.Arrays;

public class Dp {


    public static int countWays(int n, int ways[]){
        // base 
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n] != -1){
            return ways[n];
        }
        int toways = countWays(n-1, ways)+countWays(n-2, ways);
        ways[n] = toways;
        return ways[n];
    }
  

    public static int knapSack(int val[], int wt[], int W, int n){
      
        int dp[][]= new int[n+1][W+1];
        for(int i=0; i<=n ; i++){
            for(int j=0; j<=W; j++){
                dp[i][j]=-1;
            }
        }
   //base case 
   if(W==0|| n==0){
    return 0;
   }


   if(dp[n][W]!=-1){
    return dp[n][W];
   }
    if(wt[n-1]<=W){  // valid 
        int ans1 = val[n-1]+knapSack(val, wt, W-wt[n-1],n);
        int ans2 = knapSack(val, wt, W, n-1);
        dp[n][W]=Math.max(ans1, ans2);
        return dp[n][W];

    }
    else{   // not valid here also 
        return  dp[n][W]= knapSack(val, wt, W, n-1);

    }
    

    }



    /// 0-1 knapsack tabulation code here 
    public static int knapTab(int val[], int wt[], int W, int n){
        int dp[][]= new int[n+1][W+1];
        for(int i=0; i<=n; i++){
             for(int j=0; j<=W; j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
             }
        }

     for(int i=1; i<n+1; i++){
         for(int j=1; j<W+1; j++){
            // valid 
            if(wt[i-1]<=j){
                // include 
                int ans1= val[i-1]+dp[i-1][j-wt[i-1]];
                //exclude 
                int ans2 = dp[i-1][j];
                dp[i][j]= Math.max(ans1, ans2);
                
            }
            // invalid 
            else{
                dp[i][j]=dp[i-1][j];
               
            }




            // invalid 
         }
     }
     return dp[n][W];


    }





    public static  int unboundedKnapsack(int val[], int wt[], int W){
        int n = val.length;
        int dp[][]= new int[n+1][W+1];
          for(int i=0; i<n+1; i++){
             for(int j=0; j<W+1; j++){
                 if(i==0|| j==0){
                     dp[i][j]=0;
                 }
             }
          }
           for(int i=1; i<n+1; i++){
             for(int j=1; j<W+1; j++){
                // valid 
                if(wt[i-1]<=j){
                    dp[i][j]= Math.max(dp[i][j-wt[i-1]]+val[i-1], dp[i-1][j]);
                }
                // invalid 
                else{
                    dp[i][j]=dp[i-1][j];
                }
             }
           }


  return dp[n][W];

    }


      public static int coinschange(int coins[], int sum){
   int n = coins.length;
   int dp[][]= new int[n+1][sum+1];
   for(int i=0; i<n+1; i++){
    dp[i][0]=1;

   }
    for(int j=0; j<sum+1; j++){
        dp[0][j]=0;
    }
    for(int i=1; i<n+1; i++){
         for(int j=1; j<sum+1; j++){
            if(coins[i-1]<=j){
                dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
            }
            //invalid
            else{
                dp[i][j]= dp[i-1][j];
            }
         }
    }

   
         return dp[n][sum];

      }



      public static int rodCutting(int price[], int length[], int rodLength, int n, int dp[][]){
        
         // base case 
         if(rodLength==0|| n==0){
            return 0;
         }
         if(dp[n][rodLength]!=-1){
            return dp[n][rodLength];

         }
         if(length[n-1]<=rodLength){ //valid hai actully here 
                int ans1 = price[n-1]+rodCutting(price, length, rodLength-length[n-1], n, dp);
                int ans2= rodCutting(price, length, rodLength, n-1, dp);
                return dp[n][rodLength] = Math.max(ans1, ans2);
         }else{
            return  dp[n][rodLength] = rodCutting(price, length, rodLength, n-1, dp);
         }
         
      }
    


    public static int lcs(String s1, String s2,int n , int m,int dp[][]){
        /// base case 
        if(n==0|| m==0){
            return 0;
        }

  if(dp[n][m]!=-1){
    return dp[n][m];
  }
        //case 1:
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return  dp[n][m]=1+lcs(s1,s2,n-1,m-1 ,dp);
        }
        //case 2:
        return    dp[n][m]=Math.max(lcs(s1,s2,n-1,m,dp),lcs(s1, s2, n, m-1,dp));
    }



public static int lcsTab(String s1, String s2){
 
int n= s1.length();
int m = s2.length();
int dp[][]= new int[n+1][m+1];
for(int i=0; i<n+1; i++){
     for(int j=0; j<m+1; j++){
        if(i==0|| j==0){
            dp[i][j]=0;
        }
     }
}
  
for(int i=1; i<n+1; i++){
    for(int j=1; j<m+1; j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            dp[i][j]=dp[i-1][j-1]+1;

        }else{
            dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]); 
        }
    }
}
 printArr(dp);
 return dp[n][m];
 
}
public static void printArr(int dp[][]){
    for(int i=0; i<dp.length; i++){
        for(int j=0; j<dp[0].length; j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }
}

   static  int max= Integer.MIN_VALUE;
  public static int substring(String s1, String s2, int n , int m,  int dp[][]){
           
    //  base case
    if(n==0|| m==0){
        return 0;
    }
 if(s1.charAt(n-1)==s2.charAt(m-1)){
    dp[n][m] = 1+substring(s1,s2,n-1,m-1,dp);
     max=Math.max(max,dp[n][m]);
   
 } 
 else{
     dp[n][m]=Math.max(0,substring(s1,s2,n-1,m-1,dp));
 }

  return dp[n][m];
  }

  public  static  String longestPalindromeSubseq(String s) {
             String s2="";
             for(int i=s.length()-1; i>=0; i--){
                  s2+=s.charAt(i);
             }
  return s2;
        
    }
    
    public static void main(String[] args){
     
        
        String s1 ="adil";
        String s2="adil";
        int n= s1.length();
    int m= s2.length();

    int dp[][]= new int[n+1][m+1];  
     for(int i=0;i<n+1; i++){
         for(int j=0; j<m+1; j++){
            if(i==0|| j==0){
                dp[i][j]=0;
            }
         }
     }
         System.out.println("Maximum length of common substring find karna  hai okay now okay: " +  substring(s1,s2,n,m, dp));
        System.out.println("this is recersed strings are: " + longestPalindromeSubseq(s1));

    }
    
}
