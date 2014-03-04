package algorithm.sorting.basic;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 102, 12, 6, 50, 26, 40, 209, 27 };
		//int[] arr = { 102, 12, 209};
		InsertionSort is = new InsertionSort();
		is.insertionSort(arr);
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private int[] insertionSort(int[] arr) {
		for (int i = 1; i <= arr.length - 1; i++) {
			int temp = arr[i], j;
			for (j = i; j >= 1; j--) {
				if (temp < arr[j - 1]) {
					arr[j] = arr[j - 1];
					
				}else{
					break;
				}
			}
			arr[j] = temp;
		}

		return arr;
	}
}
