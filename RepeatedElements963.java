import java.util.HashSet;

public class RepeatedElement {

	public static void main(String[] args) {
		
	}
	public int repeatedNTimes(int[] A) {
		HashSet<Integer> hash = new HashSet<>();
	        
        for(int i = 0 ; i < A.length ; i++){
            if(hash.contains(A[i])) return A[i];
            
            hash.add(A[i]);
        }
        return -1;
    }
	
}

