
// Problem No. 406
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> Double.compare(a[0], b[0]));
       /* for(int i = 0 ; i < people.length ; i++){
            System.out.println(people[i][0] + "  -- " + people[i][1]);
        }*/
        
        int [][] output = new int[people.length][2];
        
        for (int[] row: output)
            Arrays.fill(row, -1);
        
        for(int i = 0 ; i < people.length ; i++){
            int counter = people[i][1];
            int height = people[i][0];
            int j = 0;
            while( j < people.length && counter > 0){
                if(output[j][0] != -1 && output[j][0] < height){
                    j++;
                    continue;
                }
                j++;
                counter--;
            }
            
           // System.out.println(people[i][0] + " ---- " + j);
            
            while(j < people.length && output[j][0] != -1){
                j++;
            }
            
            output[j][0] = people[i][0];
            output[j][1] = people[i][1];
        }
        
        return output;
    }
}
