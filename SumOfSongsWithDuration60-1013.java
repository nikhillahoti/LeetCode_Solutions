class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if(time == null || time.length < 2) return 0;
        HashMap<Integer, Integer> compliment = new HashMap<>();
        int value = 0;
        int count = 0;
        for(int i = 0 ; i < time.length ; i++){
            value = time[i] % 60;
            int compvalue = 60 - value;
            if(value == 0) value = 60;
            if(compliment.containsKey(compvalue)){
                count += compliment.get(compvalue);
            }
            compliment.put(value, compliment.getOrDefault(value, 0) + 1);
        }
        return count;
    }
}
