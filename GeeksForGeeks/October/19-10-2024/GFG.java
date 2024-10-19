class Solution {
public:
    string roundToNearest(string str) {
        // Convert the string to an integer
        long long num = stoll(str);

        // Get the last digit of the number
        int last_digit = num % 10;

        // Check if we need to round up or round down
        if (last_digit >= 5) {
            // Round up to the next multiple of 10
            num = num + (10 - last_digit);
        } else {
            // Round down to the nearest multiple of 10
            num = num - last_digit;
        }

        // Convert the result back to a string and return
        return to_string(num);
    }
};
