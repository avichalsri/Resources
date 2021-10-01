package searchForRange;

public class searchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null) {
            return result;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            }
        }

        if (nums[start] == target) {
            result[0] = start;
        } else if (nums[end] == target) {
            result[0] = end;
        }

        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            result[1] = end;
        } else if (nums[start] == target) {
            result[1] = start;
        }
        return result;
    }
}
