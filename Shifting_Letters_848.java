// Problem 848
public String shiftingLetters(String s, int[] shifts) {
   
        long sum = 0;
        char [] chrS = s.toCharArray();
        for(int i = shifts.length - 1 ; i > -1 ; i--) {
            sum += shifts[i];
            int val = (int) ((chrS[i] - 'a' + sum) % 26);
            chrS[i] = (char)( val + 'a');
        }
       
        return String.valueOf(chrS);
    }


