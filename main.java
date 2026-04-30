import java.util.*;

class Merge {

    public static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static long mergeSort(int[] arr, int[] temp, int left, int right) {
        long invCount = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid, right);
        }

        return invCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🔹 Ask user for size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // 🔹 Ask user for elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] temp = new int[n];

        long result = mergeSort(arr, temp, 0, n - 1);

        // 🔹 Output result
        System.out.println("Number of inversions: " + result);
    }
}
