package search;

public class InterpolatedSearch implements SearchMethod {
    @Override
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (arr[high] == arr[low]) break;

            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (pos < 0 || pos >= arr.length) break;

            if (arr[pos] == target)
                return pos;
            if (arr[pos] < target)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }
}