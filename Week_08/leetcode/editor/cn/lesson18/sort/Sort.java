package leetcode.editor.cn.lesson18.sort;

public class Sort {

    // 选择排序 (N ^ 2)
    public int[] selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    // 插入排序 (N ^ 2)
    public int[] insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int preIndex, current;
        for (int i = 0; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    // 冒泡排序 (N ^ 2)
    public int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    // 高级排序
    // 快速排序 (N * logN)
    public void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;
        return counter;
    }

    // 归并排序 (N * logN)
    public void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        // 合并两个有序数组 (模板)
        while (i <= mid && j <= right) temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
//        System.arraycopy(temp, 0, arr, left, temp.length);
    }

}
