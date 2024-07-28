class Solution {
    String removeDups(String str) {
        // code here
         HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                result.append(c);
                seen.add(c);
            }
        }

        return result.toString();
    }
}
