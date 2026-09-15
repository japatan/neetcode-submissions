class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1; // minimum banana possible
        int r = Arrays.stream(piles).max().getAsInt(); // stream returns OptionalInt, thus needs to unwrap
        int rate = l; // defaults to 1 banana per-hour (per-pile)
        while (l <= r) {
            long totalTime = 0;
            int k = (l + r) / 2; // binary search target eating rate (also as midpoint)
            for (int pile : piles) {
                totalTime += Math.ceilDiv(pile, k);
            }

            if (totalTime <= h) {
                rate = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return rate;
    }
}
