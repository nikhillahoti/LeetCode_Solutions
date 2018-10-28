
import java.util.*;

// Problem Number: 442
public class FindingDuplicatesInArray {

	public static void main(String[] args) {
		int arr[] = {4,3,2,7,8,2,3,1};
		FindingDuplicatesInArray fDA = new FindingDuplicatesInArray();
		List<Integer> duplicates = fDA.findDuplicates(arr);
		
		System.out.println(duplicates);
	}
	
	public List<Integer> findDuplicates(int[] nums) {
        
		HashSet<Integer> duplicates = new HashSet<>();
		
		int i = 0;
		int temp;
		while(i < nums.length) {
			
			if(nums[i] - 1 == i ) {
				i++;
				continue;
			}
			
			if(nums[nums[i] - 1] == nums[i]) {
				duplicates.add(nums[i]);
				i++;  continue;
			}
			
			temp = nums[i];
			nums[i] = nums[nums[i] - 1];
			nums[temp - 1] = temp;	
		}
		
		return new ArrayList(duplicates);
    }
	
}
