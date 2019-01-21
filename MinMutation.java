
// Problem No. 433
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        HashSet<String> hBank = new HashSet<>();
        for(String s: bank) hBank.add(s);
        
        Queue<String> que = new LinkedList<>();
        que.add(start);
        
        HashSet<String> visited = new HashSet<>();
        char opt[] = {'A', 'C', 'G', 'T'};
        
        int min = 1;
        while(!que.isEmpty()){
            int counter = que.size();
            while(counter > 0){
                
                String trans = que.poll();
                for(int i = 0 ; i < trans.length() ; i++){
                    char[] chAr = trans.toCharArray();
                    for(int j = 0 ; j < opt.length ; j++){
                        
                        chAr[i] = opt[j];
                        String nStr = String.valueOf(chAr);
                   
                        if(visited.contains(nStr)) continue;
                    
                        if(hBank.contains(nStr)){
                            if(nStr.equals(end)) return min;
                            
                            que.add(nStr);
                            visited.add(nStr);
                        }
                    }
                }
                
                counter--;
            }
            min++;
        }
        
        
        return -1;
    }
    
}
