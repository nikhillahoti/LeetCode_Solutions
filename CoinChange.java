import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		//int []coins = {2};
		int [] coins = {186,419,83,408};
		int amount = 6249;
		
		CoinChange cc = new CoinChange();
		System.out.println(cc.coinChange(coins, amount) + "");
	}
	
	
    public int coinChange(int[] coins, int amount) {

		 // The idea is we maintain an array which is of size amount + 1 and it contains the minimum number of coins needed for that amount. 
		 // for e.g. for amount = 11, the array will be from 0 to 11 and say for position 5, dp[5] = 1, 1 coin is needed        
		 long [] dp = new long[amount + 1];

		 // Initialize it with amount + 1 
		 Arrays.fill(dp, amount + 1);
		 dp[0] = 0;
		 for (int i = 1 ; i < amount + 1 ; i++) {

		 	// We then check for every coin if it gets us the desired amount. If yes, we check if the sum of coins + 1 < the coins needed currently.
			 for(int j = 0 ; j < coins.length ; j++) {
				 if(i - coins[j] >= 0) {
					 dp[i] = Long.min(dp[i], dp[i - coins[j]] + 1); 
				 }
			 }
		 }
		 
		 // If the sum does not match, the last element will be amount + 1, so return -1
		 return dp[amount] > amount ? -1 : (int) dp[amount];
	 }
}
