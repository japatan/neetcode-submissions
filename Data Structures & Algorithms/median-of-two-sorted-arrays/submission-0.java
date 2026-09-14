class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        int total = A.length + B.length;
        int half = (total + 1) / 2;

        // binary search only works correctly if you search over the smaller array
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0;
        int r = A.length;
        while (l <= r) {
            // ex:
            // B = [1, 2, 3, | 4, 5, 6, 7, 8]
            // A = [1, 2, 3, | 4]
            
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft  = i > 0 ? A[i - 1] : Integer.MIN_VALUE; // element just left of cut in A (or -∞ if i=0)
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE; // element just right of cut in A (or +∞ if i=A.length)
            int Bleft  = j > 0 ? B[j - 1] : Integer.MIN_VALUE; // element just left of cut in B (or -∞ if j=0)
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE; // element just right of cut in B (or +∞ if j=B.length)

            if (Aleft <= Bright && Bleft <= Aright) {
                // Valid partition found: everything left of both cuts <= everything right of both cuts
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);       // odd total: median is the largest "left" value
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0; // even: avg of largest-left and smallest-right
            } else if (Aleft > Bright) {
                r = i - 1;   // A's cut is too far right (took too many from A) — shrink search
            } else {
                l = i + 1;   // A's cut is too far left (took too few from A) — grow search
            }
        }
        return -1;
    }
}
