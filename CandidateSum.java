// Problem No. 39

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        combinate(new ArrayList<>(), candidates, target, 0, 0);
        
        return output;
    }
    
    List<List<Integer>> output = new ArrayList<>();
    
    public void combinate(List<Integer> tempList,int [] candidates, int target, int startIndex, int sum){

        if(startIndex == candidates.length) return;

        for(int i = startIndex; i < candidates.length ; i++){
            if(sum + candidates[i] == target){
                tempList.add(candidates[i]);
                output.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size() - 1);
                return;
            }    
            
            if(sum + candidates[i] < target){
                tempList.add(candidates[i]);
                combinate(tempList, candidates, target, i, sum + candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
            else {
                return;
            }
        }
    }
}
