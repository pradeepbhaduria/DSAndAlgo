package algorithm.sorting.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsSort {
	ArrayList<DVDInfo> infos = new ArrayList<DVDInfo>();

	public static void main(String[] arr) {
		CollectionsSort collectionSort = new CollectionsSort();
		collectionSort.initialize();
		collectionSort.doSort(new GenreComparator());
	}

	private void initialize() {
		infos.add(new DVDInfo("Hum Aapke hai", "Family", 1994));
		infos.add(new DVDInfo("DDLJ     ", "Romance", 1996));
		infos.add(new DVDInfo("Sholay   ", "Action", 1975));
		infos.add(new DVDInfo("Alamara  ", "First", 1913));
		infos.add(new DVDInfo("Raja Harischandra", "First with voice", 1933));
		infos.add(new DVDInfo("barfi    ", "Family", 2013));
		infos.add(new DVDInfo("Sarfarosh", "Patriotic", 1995));
	}

	private void doSort(Comparator<DVDInfo> c) {
		printCollection();
		if (c != null) {
			Collections.sort(infos, c);
		} else {
			Collections.sort(infos);
		}
		System.out
				.println("==================Sorting Completed=====================");
		printCollection();
	}

	private void printCollection() {
		System.out.println("Title : " + "\t\t\t Year : " + "\t\t\t Genre : ");
		for (DVDInfo info : infos) {
			System.out.println(info.getTitle() + "\t\t\t " + info.getYear() + "\t\t\t  "
					+ info.getGenre());
		}
	}
}

class YearComparator implements Comparator<DVDInfo> {

	@Override
	public int compare(DVDInfo o1, DVDInfo o2) {
		int returnValue = 0;
		if (o1.getYear() > o2.getYear()) {
			returnValue = 1;
		} else if (o1.getYear() < o2.getYear()) {
			returnValue = -1;
		}
		return returnValue;
	}

}
class GenreComparator implements Comparator<DVDInfo> {

	@Override
	public int compare(DVDInfo o1, DVDInfo o2) {
		return o1.getGenre().compareTo(o2.getGenre());
	}

}

class DVDInfo implements Comparable<DVDInfo> {
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private String title;
	private String genre;
	private int year;

	public DVDInfo(String title, String genre, int year) {
		super();
		this.title = title;
		this.genre = genre;
		this.year = year;
	}

	@Override
	public int compareTo(DVDInfo info) {
		return title.compareTo(info.getTitle());
	}
}
