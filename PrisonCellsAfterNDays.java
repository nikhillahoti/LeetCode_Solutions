
// Problem No. 957
class Solution {
public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<List<Integer>, Integer> hash = new HashMap<>();
        
        List<Integer> lsttt = new ArrayList<>();
        for(int i = 0 ; i < 8 ; i++) lsttt.add(cells[i]);
        
        int counter = N;
        boolean flag = true;
        while(counter > 0){
        	lsttt = changePrisonCells(lsttt );
            counter--;
            
            if(hash.containsKey(lsttt) && flag){
                counter = (counter) % (hash.get(lsttt) - counter);
                flag = false;
            }
            hash.put(lsttt, counter);
        }
        
        for(int i = 0 ; i < 8 ; i++) {
        	cells[i] = lsttt.get(i);
        }
        return cells;
    }
    
    public List<Integer> changePrisonCells(List<Integer> cells) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int i = 1 ; i < 7 ; i++){
            if((cells.get(i-1) == 0 && cells.get(i+1) == 0) || (cells.get(i-1) == 1 && cells.get(i+1) == 1))
                result.add(1);
            else 
            	result.add(0);
        }
        result.add(0);
        return result;
    }
}
