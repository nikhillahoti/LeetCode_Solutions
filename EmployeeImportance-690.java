/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null || employees.size() < 1) return -1;
        
        Map<Integer,Employee> map = new HashMap<>();
        for(int i = 0 ; i < employees.size(); i++)
            map.put(employees.get(i).id, employees.get(i));
        
        if(!map.containsKey(id)) return -1;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int totalValue = 0;
        while(!queue.isEmpty()){
            Employee current = map.get(queue.poll());
            totalValue += current.importance;
            for(int i = 0 ; i < current.subordinates.size() ; i++)
                queue.offer(current.subordinates.get(i));
        }
        
        return totalValue;
    }
}