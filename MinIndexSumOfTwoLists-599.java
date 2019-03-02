class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        HashSet<String> output = new HashSet<>();
        
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0 ; i < list1.length ; i++)
            hash.put(list1[i], i);
        
        int minIndex = Integer.MAX_VALUE;
        for(int j = 0 ; j < list2.length ; j++){
            if(hash.containsKey(list2[j])){
                if(hash.get(list2[j]) + j == minIndex){
                    output.add(list2[j]);
                }
                else if(hash.get(list2[j]) + j < minIndex){
                    output.clear();
                    output.add(list2[j]);
                    minIndex = hash.get(list2[j]) + j;
                }
            }
        }
        
        String result[] = new String[output.size()];
        minIndex = 0;
        for (String i : output) {
            result[minIndex++] = i;
        } 
        return result;
    }
}
