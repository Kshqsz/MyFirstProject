package 数据结构.第七章;

import java.util.Scanner;

public class SortingExample {
    public static void swap(int [] arr, int i, int j) { //交换函数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insrtSort(int[] arr) { //插入排序
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int idx = i - 1;
            while (idx >= 0 && arr[idx] > key) {
                arr[idx + 1] = arr[idx];
                idx--;
            }
            arr[idx + 1] = key;
        }
    }
    public static void selectionSort(int[] arr) { //选择排序
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            swap(arr, i, min_idx);
        }
    }
    public static void merge_sort(int [] a, int [] b, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + r >> 1;
        merge_sort(a, b, l, mid); merge_sort(a, b, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        while (i <= mid) b[k++] = a[i++];
        while (j <= r) b[k++] = a[j++];
        for (i = l, j = 0; i <= r; i++, j++) {
            a[i] = b[j];
        }
    }
    public static void quick_sort(int [] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >> 1;
        int x = arr[mid];
        int l = low - 1, r = high + 1;
        while (l < r) {
            do l++; while (arr[l] < x);
            do r--; while (arr[r] > x);
            if (l < r) {
                swap(arr, l, r);
            }
        }
        quick_sort(arr, low, mid); quick_sort(arr, mid + 1, high);
    }
    public static void heapSort(int[] arr) { //堆排序
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int []arr, int n, int i) {
        int largest= i;
        int l = 2 * i;
        int r = 2 * i + 1;
        if (l < n && arr[l] > arr[largest]) {
            largest= l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static int[] insert(int[] arr, int val) { //插入后仍然保持有序 并将数组扩容
        int n = arr.length;
        int[] arr1 = new int[n + 1];
        int i = 0;
        while (i < n && val > arr[i]) {
            arr1[i] = arr[i];
            i++;
        }
        arr1[i] = val;
        while (i < n) {
            arr1[i + 1] = arr[i];
            i++;
        }
        return arr1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入数组大小: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("请输入数组中第" + (i + 1) + "个元素: ");
            arr[i] = sc.nextInt();
        }
        System.out.print("\n");
        System.out.print("排序前: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        heapSort(arr);
        System.out.print("\n");
        System.out.print("排序后: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n");
        System.out.print("请输入要插入的元素: ");
        int val = sc.nextInt();
        arr = insert(arr, val);
        System.out.print("插入后的数组: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
