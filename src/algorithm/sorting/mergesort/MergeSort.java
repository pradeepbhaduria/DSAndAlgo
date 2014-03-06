package algorithm.sorting.mergesort;

public class MergeSort {
	int[] workspace;

	public void sort(int[] arr) {
		workspace = new int[arr.length];
		sort(arr, 0, arr.length - 1);
	}

	public void sort(int[] arr, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			return;
		} else {
			int midPoint = (startIndex + endIndex) / 2;
			sort(arr, startIndex, midPoint);
			sort(arr, midPoint + 1, endIndex);
			merge(arr, startIndex, midPoint + 1, endIndex);
		}
	}

	private void merge(int[] arr, int lowerIndex, int higherIndex, int endIndex) {
		int j = lowerIndex;
		int startIndex = lowerIndex;
		int lowerBound = higherIndex;
		while (lowerIndex < lowerBound && higherIndex <= endIndex) {
			if (arr[lowerIndex] < arr[higherIndex]) {
				workspace[j++] = arr[lowerIndex++];
			} else if (arr[higherIndex] < arr[lowerIndex]) {
				workspace[j++] = arr[higherIndex++];
			}
		}

		while (lowerIndex < lowerBound) {
			workspace[j++] = arr[lowerIndex++];
		}
		while (higherIndex <= endIndex) {
			workspace[j++] = arr[higherIndex++];
		}
		for (int i = startIndex; i <= endIndex; i++) {
			arr[i] = workspace[i];
		}
	}
}
