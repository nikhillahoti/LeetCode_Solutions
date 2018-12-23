
public class MaximumRamp {

	public static void main(String[] args) {
		//int A[] = {6,0,8,2,1,5};
		int A[] = {9,8,1,0,1,9,4,0,4,1};
		MaximumRamp mR = new MaximumRamp();
		System.out.println(mR.maxWidthRamp(A));
	}
	
	 public int maxWidthRamp(int[] A) {
		 
		 int maxi[] = new int[A.length];
		 int posi[] = new int[A.length];
		 int ramp = -1;
		 
		 maxi[A.length - 1] = A[A.length - 1];
		 posi[A.length - 1] = A.length - 1;  
		 
		 for (int i = A.length - 2 ; i > -1 ; i--) {
			 if(A[i] > maxi[i+1]) {
				 maxi[i] = A[i];
				 posi[i] = i;
			 }
			 else {
				 maxi[i] = maxi[i+1];
				 posi[i] = posi[i+1];
				 int last = i + 1;
				 int k = i + 2;
				 while(k < A.length) {		 
					 if(maxi[k] >= A[i]) {
						 last = posi[k];
						 k = posi[k] + 1;
					 }
					 else {
						 break;
					 }
				 }
				 if(last - i > ramp) {
					 ramp = last - i;
				 }
			 }
		 }
		 
		 System.out.println("Position --> ");
		 for(int i = 0 ; i < A.length ; i++) {
			 System.out.print(posi[i] + "");
		 }
		 
		 System.out.println("\nMaximum --> ");
		 for(int i = 0 ; i < A.length ; i++) {
			 System.out.print(maxi[i] + "");
		 }
		 return ramp;
	 }
	
}

