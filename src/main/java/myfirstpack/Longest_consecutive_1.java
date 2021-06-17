package myfirstpack;

import java.util.Scanner;

class Solution{

  /*  Function to calculate the longest consecutive ones
   *   N: given input to calculate the longest consecutive ones
   */
  public static int maxConsecutiveOnes(int N) {

    // Your code here
    int maxi=0,cnt=0;
    for(int i=0;i<32;i++)
    {
      int tmp=N&1;
      if(tmp==1)
      {
        cnt++;
      }
      else
      {
        maxi=Math.max(maxi,cnt);
        cnt=0;
      }
      N>>=1;
    }
    maxi=Math.max(maxi,cnt);
    return maxi;

  }
}

public class Longest_consecutive_1 {

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Number of test cases:");
    int t= sc.nextInt();
    while(t-->0)
    {
      System.out.println("Enter n:");
      int n=sc.nextInt();
      Solution obj=new Solution();
      System.out.println(obj.maxConsecutiveOnes(n));
    }
  }

}
