class Solution {
    String roundToNearest(String str) {
        int n = str.length();
        if (n == 0) return str;  

        int lastDigit = str.charAt(n - 1) - '0';  

        if (lastDigit <= 5) {
            str = str.substring(0, n - 1) + '0';  
        } else {
            str = str.substring(0, n - 1) + '0';  
            int i = n - 2;

            while (i >= 0) {
                if (str.charAt(i) != '9') {
                    str = str.substring(0, i) + (char)(str.charAt(i) + 1) + str.substring(i + 1);  
                    break;
                }
                str = str.substring(0, i) + '0' + str.substring(i + 1);  
                i--;
            }
            if (i < 0) {
                str = '1' + str;  
            }
        }
        return str;
    }
}
