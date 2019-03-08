class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       
        HashMap<String, String> emailNameMap = new HashMap<>();
        for(int i = 0 ; i < accounts.size() ; i++){
            List<String> record = accounts.get(i);
           
            String parent = null;
            int j = 1;
            for(j = 1 ; j < record.size() ; j++){
                if(parentMap.containsKey(record.get(j))){
                    //parent = parentMap.get(record.get(j));
                    parent = getParent(record.get(j));
                    break;
                }
            }
           
            if(parent == null){
                for(j = 1 ; j < record.size() ; j++)
                    parentMap.put(record.get(j), record.get(1));
                emailNameMap.put(record.get(1), record.get(0));
            }
            else {
                for(j = 1 ; j < record.size() ; j++){
                    String currParent = getParent(record.get(j));
                    if(currParent == null)
                        setParent(record.get(j), parent);
                    else {
                        setParent(record.get(j), parent);
                        if(emailNameMap.containsKey(currParent) && !currParent.equals(parent)){
                           emailNameMap.remove(currParent);
                        } 
                    }
                }
            }
        }
       
        HashMap<String, List<String>> emailList = new HashMap<>();
        for(String key: parentMap.keySet()){
            String parent = getParent(key);
            if(emailList.containsKey(parent)){
                List<String> ls = emailList.get(parent);
                ls.add(key);
                emailList.put(parent, new ArrayList<>(ls));
                //emailList.put(parentMap.get(key), new ArrayList<>(ls));
            }
            else {
                List<String> ls = new ArrayList<String>();
                ls.add(key);
                emailList.put(parent, new ArrayList<>(ls));
                //emailList.put(parentMap.get(key), new ArrayList<>(ls));
            }
        }
       
        List<List<String>> result = new ArrayList<>();
        for(String key: emailNameMap.keySet()){
            List<String> lst = emailList.get(key);
            Collections.sort(lst);
            lst.add(0, emailNameMap.get(key));
            result.add(new ArrayList<>(lst));
        }
       
        return result;
    }
   
    HashMap<String, String> parentMap = new HashMap<>();
   
    public String getParent(String child){
        String currentParent = parentMap.get(child);
        if(currentParent == null) return null;
        if(currentParent.equals(child)) return child;
        return getParent(currentParent);
    }
   
    public void setParent(String child, String parent){
        String currentParent = parentMap.get(child);
        parentMap.put(child, parent);
       
        if(currentParent != null && !currentParent.equals(parent))
            setParent(currentParent, parent);
    }
   
}
