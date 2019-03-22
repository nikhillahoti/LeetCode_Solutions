class Solution {
    public int numRabbits(int[] answers) {
        if(answers == null || answers.length < 1) return 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int num: answers)
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        
        int minCount = 0;
        for(int key: hash.keySet()){
            if(key == 0)
                minCount += hash.get(key);
            else if(hash.get(key) > key) 
                minCount += ((key + 1) * (int) Math.ceil(hash.get(key) * 1.0 / (key + 1)));
            else minCount += (key + 1);
        }
        return Integer.max(minCount, answers.length);
    }
}
