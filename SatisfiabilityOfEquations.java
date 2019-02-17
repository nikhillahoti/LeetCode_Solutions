class Solution {
    public boolean equationsPossible(String[] equations) {
        
        if(equations == null || equations.length < 1) return true;
        
        for(int i = 0 ; i < equations.length ; i++){
            if(equations[i].charAt(1) == '='){
                Character part1 = equations[i].charAt(0);
                Character part2 = equations[i].charAt(3);
                
                if(!hash.containsKey(part1) && !hash.containsKey(part2)){
                    hash.put(part1, part1);
                    hash.put(part2, part1);
                }
                else {
                    if(hash.containsKey(part1))
                        setParent(part2, getParent(part1));
                    else
                        setParent(part1, getParent(part2));
                }
            }
        }
        
        for(Character key : hash.keySet()){
            System.out.println(key + " ->" + hash.get(key));
        }
        
        for(int i = 0 ; i < equations.length ; i++){
            if(equations[i].charAt(1) == '!'){
                
                if(equations[i].charAt(0) == equations[i].charAt(3)) return false;
                
                Character part1 = getParent(equations[i].charAt(0));
                Character part2 = getParent(equations[i].charAt(3));
                
                if(part1 == null || part2 == null) continue;
                
                if(part1.equals(part2)) return false;   
            }
        }
        
        return true;
    }
    
    HashMap<Character, Character> hash = new HashMap<>();
    
    public Character getParent(Character child) {
        while(true){
            Character parent = hash.get(child);    
            if(parent == null) return null;
            if(parent.equals(child)) return child;
            child = parent;
        }
    }
    
    public void setParent(Character child, Character target){
        Character currentParent = hash.get(child);
        hash.put(child, target);
        if(currentParent != null && !currentParent.equals(child))
            setParent(currentParent, target);
    }
    
}
