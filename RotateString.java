
// Problem No. 796
class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        String strA = A + A;
        if(strA.contains(B)) return true;
        return false;
    }
}
