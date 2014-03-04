package algorithm.sorting.mergesort;

public class MergeSort {
	int[] workspace;

	public void sort(int[] arr) {
		workspace = new int[arr.length];
		sort(arr, 0, arr.length - 1);
		System.out.println("");
		for (int i : workspace) {
			System.out.println(i + "\t");
		}
	}

	public void sort(int[] arr, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			return;
		} else {
			int midPoint = (startIndex + endIndex) / 2;
			System.out.println("startIndex :" + startIndex + " midPoint:"
					+ midPoint + " endIndex:" + endIndex);
			sort(arr, startIndex, midPoint);
			sort(arr, midPoint + 1, endIndex);
			merge(arr, startIndex, midPoint + 1, endIndex);
		}
	}

	private void merge(int[] arr, int lowerIndex, int higherIndex, int endIndex) {
		int j = lowerIndex;
		int lowerBound = higherIndex;
		while (true) {
			if (lowerIndex < lowerBound && arr[lowerIndex] < arr[higherIndex]) {
				workspace[j++] = arr[lowerIndex++];
			} else if (higherIndex <= endIndex
					&& arr[higherIndex] < arr[lowerIndex]) {
				workspace[j++] = arr[higherIndex++];
			} else {
				break;
			}
		}

		while (lowerIndex < lowerBound) {
			workspace[j++] = arr[lowerIndex++];
		}
		while (higherIndex <= endIndex) {
			workspace[j++] = arr[higherIndex++];
		}

	}
}
