/*
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        if(costs == null || costs.length < 1) return 0;
        
	// We first sort the array based on the difference between the prices of the 
	// two cities. So, our array would contain the prices in the increasing order for city A.
	// We then pick the first N elements for city A, which gives us the cheapest flights for city A.
	// The other N are the cheapest flights for city B.
        Arrays.sort(costs, (a,b) -> {
           return (a[0] - a[1]) - (b[0] - b[1]);
        });
        
        int counter = costs.length / 2;
        int minSum = 0;
        for(int i = 0 ; i < counter ; i++)
            minSum += costs[i][0];
        for(int i = counter ; i < costs.length ; i++)
            minSum += costs[i][1];
        
        return minSum;
    }
}
