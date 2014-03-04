package algorithm.sorting.basic;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = { 102, 12, 6, 50, 26, 40, 209, 27 };
		SelectionSort ss = new SelectionSort();
		ss.selectionSort(arr);
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private int[] selectionSort(int[] arr) {
		for (int j = 0, largest = 0; j < arr.length - 1; j++) {
			for (int i = 1; i < arr.length - j; i++) {
				if (arr[i] > arr[largest]) {
					largest = i;
				}
			}
			int temp = arr[largest];
			arr[largest] = arr[arr.length - 1 - j];
			arr[arr.length - 1 - j] = temp;
			largest = 0;
		}
		return arr;
	}
}
