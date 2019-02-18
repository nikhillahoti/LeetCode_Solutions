/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// Problem 277

public class Solution extends Relation {
    public int findCelebrity(int n) {
        List<Integer> result = new ArrayList<>();
        boolean flag = false;
        for(int i = 1 ; i < n ; i++){
            if(knows(0, i)){
                result.add(i);
                flag = true;
            }
        }
        if(!flag) celeb = 0;
        else 
            checkCeleb(result);
        
        if(celeb == -1) return -1;
        for(int i = 0 ; i < n ; i++){
            if(i == celeb) continue;
            if(knows(celeb, i)) return -1;
            if(!knows(i, celeb)) return -1;
        }
        return celeb;
    }
    int celeb = -1;
    
    public void checkCeleb(List<Integer> arr){
        if(arr.size() == 0) return;
        if(arr.size() == 1) {
            celeb = arr.get(0);
            return;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        boolean flag = false;
        for(int i = 1 ; i < arr.size(); i++){
            if(knows(arr.get(0), arr.get(i))){
                flag = true;
                res.add(arr.get(i));
            }
        }
        if(!flag){
            celeb = arr.get(0);  
            return;
        } 
        
        checkCeleb(res);
    }
}
