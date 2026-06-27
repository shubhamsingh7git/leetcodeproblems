class Solution {

    public int maximumLength(int[] nums) {

        int max = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put((long) x, map.getOrDefault((long) x, 0) + 1);
            max = Math.max(max, x);
        }

        int ans = map.containsKey(1L)
                ? map.get(1L) - (map.get(1L) % 2 == 0 ? 1 : 0)
                : 1;

        for (int num : nums) {

            if (num == 1)
                continue;

            long x = num;
            int len = 0;

            while (x <= max &&
                   map.containsKey(x) &&
                   map.get(x) >= 2) {

                len += 2;
                x = x * x;
            }

            if (map.containsKey(x))
                ans = Math.max(ans, len + 1);
            else
                ans = Math.max(ans, len - 1);
        }

        return ans;
    }
}