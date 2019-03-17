class Solution {
    public int bitwiseComplement(int n) {
        if(n < 0) return 0;
        String arr = Integer.toBinaryString(n);
        
		int i = 0;
		while(i < arr.length() && arr.charAt(i) == '1')
			i++;
		
		if(i == arr.length()) return 0;
		StringBuilder sb = new StringBuilder();
		while(i < arr.length()) {
            if(arr.charAt(i) == '0')
			    sb.append('1');
            else
                sb.append('0');
			i++;
		}
        System.out.println(sb.toString());
		return Integer.parseInt(sb.toString(), 2);
    }
}
