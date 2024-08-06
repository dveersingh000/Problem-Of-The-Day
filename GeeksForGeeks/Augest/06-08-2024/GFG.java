class Solution {

    public boolean isValid(String str) {
        // Write your code here
        String[] segments = str.split("\\.");
        
        // Check if there are exactly four segments
        if (segments.length != 4) {
            return false;
        }
        
        for (String segment : segments) {
            // Check if segment is empty or has leading zeros
            if (segment.isEmpty() || (segment.length() > 1 && segment.startsWith("0"))) {
                return false;
            }
            
            // Check if segment is a valid number
            try {
                int num = Integer.parseInt(segment);
                // Check if number is within the valid range
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        return true;
    }
}
