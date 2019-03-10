class Solution {
    public int clumsy(int N) {
        
        if(N < 1) return 0;
        
        List<Integer> lst = new ArrayList<>();
        for(int i = N ; i > 0 ; i--)
            lst.add(i);
        
        int counter = 4;
        
        while(counter > 0){
            List<Integer> nLst = new ArrayList<>();
            switch(counter) {
                case 4:
                    int i = 0;
                    for(i = 0 ; i + 1 < lst.size() ; i++){
                        nLst.add(lst.get(i) * lst.get(i+1));
                        i += 2;
                        if(i < lst.size())
                            nLst.add(lst.get(i++));
                        if(i < lst.size())
                            nLst.add(lst.get(i));
                    }
                    while(i < lst.size()) {
                        nLst.add(lst.get(i));
                        i++;
                    }
                    break;
                
                case 3:
                    for(i = 0 ; i + 1 < lst.size() ; i++){
                        nLst.add((int) Math.floor(lst.get(i) / lst.get(i+1)));
                        i += 2;
                        if(i < lst.size())
                            nLst.add(lst.get(i));
                    }
                    while(i < lst.size()) {
                        nLst.add(lst.get(i));
                        i++;
                    }
                    break;
                
                case 2:
                    int val = lst.get(0);
                    boolean flag = false;
                    for(i = 1 ; i < lst.size() ; i++){
                        if(!flag) val += lst.get(i);
                        else val -= lst.get(i);
                        flag = !flag;
                    }
                    return val;
            }
            lst = null;
            lst = new ArrayList<>(nLst);
            nLst = new ArrayList<>();
            
            counter--;
        }
        return -1;
    }
}
