package algorithm.sorting.basic;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 102, 12, 6, 50, 26, 40, 209, 27 };
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(arr);
		for(int i: arr){
			System.out.print(i+"\t");
		}
	}

	private int[] bubbleSort(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					// swap
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}

			}
		}

		return arr;
	}
}
