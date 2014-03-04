package algorithm.sorting.quicksort;

public class QuickSort {

	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public void sort(int[] arr, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pivotIndex = partitionIt(arr, startIndex, endIndex);
			sort(arr, 0, pivotIndex - 1);
			sort(arr, pivotIndex+1, endIndex);
		}
	}

	public int partitionIt(int[] arr, int leftIndex, int rightIndex) {
		int pivotIndex = rightIndex;
		while (true) {

			while (arr[leftIndex] < arr[pivotIndex] && leftIndex <= rightIndex) {
				leftIndex++;
			}
			while (arr[rightIndex] >= arr[pivotIndex] && rightIndex > leftIndex) {
				rightIndex--;
			}
			swap(arr, leftIndex, rightIndex);
			if (leftIndex >= rightIndex) {
				break;
			}
		}
		swap(arr, pivotIndex, rightIndex);
		return rightIndex;
	}

	private void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

}
