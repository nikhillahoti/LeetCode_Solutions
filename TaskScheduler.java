// Problem No. 621

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;


class Solution {
    public int leastInterval(char[] tasks, int n) {
      PriorityQueue<Map.Entry<Integer, Map.Entry<Character, Integer>>> taskScheduler = new PriorityQueue<>(
            (a,b) -> {
            	if(a.getKey() == b.getKey()) {
            		// compare the occurences
            		return a.getValue().getValue() - b.getValue().getValue();
            	}
            	return a.getKey() - b.getKey();
            }
        );
        
        
        HashMap<Character, Integer> occurences = new HashMap<>();
        for(int i = 0 ; i < tasks.length ; i++) {
        	if(occurences.containsKey(tasks[i])) {
        		occurences.put(tasks[i], occurences.get(tasks[i]) + 1);
        	}
        	else {
        		occurences.put(tasks[i], 1);
        	}
        }
        
        for(Entry<Character, Integer> entry : occurences.entrySet()) {
        	taskScheduler.add(new AbstractMap.SimpleEntry<Integer, Entry<Character, Integer>>(1, entry));
        }
        
        int timeTaken = 1;
        while(!taskScheduler.isEmpty()) {
        	Entry<Integer, Entry<Character, Integer>>  earliestTask = taskScheduler.poll();
            /*System.out.println(earliestTask.getValue().getKey() + "");
        	System.out.println(earliestTask.getKey());
            System.out.println(timeTaken);
        	System.out.println("-----");*/
        	if(timeTaken >= earliestTask.getKey()) {
        		timeTaken++;
        		if(earliestTask.getValue().getValue() - 1 != 0) {
        			taskScheduler.add(new AbstractMap.SimpleEntry<Integer, Entry<Character, Integer>>(earliestTask.getKey() + n + 1, new AbstractMap.SimpleEntry<Character, Integer>(earliestTask.getValue().getKey(), earliestTask.getValue().getValue() - 1)));
        		}
        	}
        	else {
                //System.out.println("I hit");
        		timeTaken = earliestTask.getKey() + 1;
        		if(earliestTask.getValue().getValue() - 1 != 0) {
        			taskScheduler.add(new AbstractMap.SimpleEntry<Integer, Entry<Character, Integer>>(earliestTask.getKey() + n + 1, new AbstractMap.SimpleEntry<Character, Integer>(earliestTask.getValue().getKey(), earliestTask.getValue().getValue() - 1)));	
        		}
        	}
        }
        
        return timeTaken - 1;
    }
}
