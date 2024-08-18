class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n + 1]; // Frequency array to count occurrences

        // Count occurrences of each element
        for (int num : arr) {
            if (num >= 1 && num <= n) {
                freq[num]++;
            }
        }

        int max = -1; // Initialize max as -1 because the problem mentions returning -1 if no lucky integer is found

        // Find the maximum lucky integer
        for (int i = 1; i <= n; i++) {
            if (freq[i] == i) {
                max = Math.max(max, i);
            }
        }

        return max;
    }
}