package DivideAndConquer;

public class DivideAndConquer {


    /**
     * https://leetcode.com/problems/majority-element/
     * <p>
     * Algorithm - https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int maxElement = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                maxElement = nums[i];
                count++;
            } else if (maxElement == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        if (count < 0) {
            return -1;
        }

        return maxElement;
    }
}
