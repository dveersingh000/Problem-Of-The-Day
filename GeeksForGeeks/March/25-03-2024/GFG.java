ArrayList<String> NBitBinary(int N) {
        ArrayList<String> result = new ArrayList<>();
        generateNBitBinary("", N, 0, 0, result);
        return result;
    }

    void generateNBitBinary(String current, int n, int ones, int zeroes, ArrayList<String> result) {
        if (n == 0) {
            result.add(current);
            return;
        }

        if (ones == zeroes) {
            generateNBitBinary(current + "1", n - 1, ones + 1, zeroes, result);
        } else {
            generateNBitBinary(current + "1", n - 1, ones + 1, zeroes, result);
            generateNBitBinary(current + "0", n - 1, ones, zeroes + 1, result);
        }
    }
