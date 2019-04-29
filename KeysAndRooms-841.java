/*

There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:  
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.

Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.

Note:

    1 <= rooms.length <= 1000
    0 <= rooms[i].length <= 1000
    The number of keys in all rooms combined is at most 3000.

*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        if(rooms == null || rooms.size() < 1) return false;
        
	// We maintain a list of rooms which are yet to be visited in a Queue
        Queue<Integer> queue = new LinkedList<>();

	// We maintain a list of all the rooms which can be visited in a HashSet
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        
        while(!queue.isEmpty()){
         
            int current = queue.poll();
            if(visited.contains(current)) continue;
            
            visited.add(current);
            List<Integer> currentNode = rooms.get(current);
            
            for(int i = 0 ; i < currentNode.size() ; i++){
                if(visited.contains(currentNode.get(i))) continue;
                queue.offer(currentNode.get(i));
            }
        }
        
	
	// If our visited set contains N entries, that means we can visit those nodes
        if(visited.size() == rooms.size()) return true;
        return false;
    }
}
