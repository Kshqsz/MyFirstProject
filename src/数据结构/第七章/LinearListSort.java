package 数据结构.第七章;

public class LinearListSort {
    public static void swap(int [] arr, int i, int j) { //交换函数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void bubbleSort(int [] arr) { //冒泡排序
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void quickSort(int [] arr, int low, int high) { // 快排
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    public static int partition(int [] arr, int low, int high) { // 返回基准值
        int pivot = arr[low];
        int l = low, r = high;
        while (l != r) {
            while (l < r && arr[r] > pivot) {
                r--;
            }
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, low, l);
        return l;
    }

    public static void main(String[] args) {
        int [] arr = {1, 4, 9, 0, 2, 5, 3, 7, 6, -1};
        System.out.print("排序前: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
        quickSort(arr, 0, 9);
        System.out.print("排序后: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
