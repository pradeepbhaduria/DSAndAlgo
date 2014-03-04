package ds.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
 * Shortest path covering all the vertices.
 * Minimum spanning tree
 */

public class ShortestPath {

	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	private int[][] adjMatrix;

	private ArrayList<VertexPair> output = new ArrayList<VertexPair>();
	PriorityQueue<VertexPair> queue = new PriorityQueue<VertexPair>();

	public static void main(String[] args) {
		ShortestPath thisClass = new ShortestPath();
		thisClass.initialize();
		// thisClass.displayMatrix();
		thisClass.createMinimumSpanningTree(0);
		thisClass.showPath();
	}

	private void showPath() {
		System.out.println("\nShortestPath.showPath()");
		for (VertexPair pair : output) {
			System.out.println(pair.source + "\t" + pair.dest + "\t"
					+ pair.distance);
		}
	}

	private void createMinimumSpanningTree(int startIndex) {
		vertices.get(startIndex).isInTree = true;
		// output.add(startIndex);
		for (int i = 0; i < adjMatrix[startIndex].length; i++) {
			int distance = adjMatrix[startIndex][i];
			if (distance != 0 && !vertices.get(i).isInTree) {
				boolean toAdd = true;
				Iterator<VertexPair> itr = queue.iterator();
				while (itr.hasNext()) {
					VertexPair pair = itr.next();
					if (pair.dest == i) {
						if (pair.distance > distance) {
							queue.remove(pair);
							break;
						} else {
							toAdd = false;
						}
					}
				}
				if (toAdd) {
					queue.add(new VertexPair(startIndex, i, distance));
				}
			}
		}
		if (!queue.isEmpty()) {
			// ==========
			Iterator<VertexPair> itr = queue.iterator();
			System.out.println("");
			while (itr.hasNext()) {
				VertexPair pair = itr.next();
				System.out.print("\t" + pair.dest);
			}
			// =============
			VertexPair pair = queue.poll();
			output.add(pair);
			createMinimumSpanningTree(pair.dest);
		}

	}

	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static final int E = 4;
	public static final int F = 5;

	private void initialize() {
		addVertex(new Vertex("A"));
		addVertex(new Vertex("B"));
		addVertex(new Vertex("C"));
		addVertex(new Vertex("D"));
		addVertex(new Vertex("E"));
		addVertex(new Vertex("F"));
		adjMatrix = new int[vertices.size()][vertices.size()];
		addEdge(A, B, 6);// AB6
		addEdge(A, D, 4);// AD4
		addEdge(B, D, 7);// BD7
		addEdge(B, C, 10);// BC10
		addEdge(B, E, 7);// BE7
		addEdge(D, E, 12);// DE12
		addEdge(D, C, 8);// DC8
		addEdge(C, E, 5);// CE5
		addEdge(C, F, 6);// CF6
		addEdge(E, F, 7);// EF7

	}

	private void displayMatrix() {
		for (int[] arr : adjMatrix) {
			System.out.println("");
			for (int item : arr) {
				System.out.print(item + "\t\t");
			}
		}

	}

	private int getAdjacentVertex(int source) {
		int returnValue = -1;
		for (int i = 0; i < adjMatrix[source].length; i++) {
			if (adjMatrix[source][i] != 0 && !vertices.get(i).isInTree) {
				returnValue = i;
				break;
			}
		}
		return returnValue;
	}

	public void addEdge(int source, int dest, int distance) {
		adjMatrix[source][dest] = distance;
		adjMatrix[dest][source] = distance;
	}

	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
	}

	class Vertex {
		public Vertex(String name2) {
			this.name = name2;
		}

		String name;
		boolean isInTree;

	}

	class VertexPair implements Comparable<VertexPair> {
		int source;
		int dest;
		int distance;

		public VertexPair(int source, int dest, int distance) {
			super();
			this.source = source;
			this.dest = dest;
			this.distance = distance;
		}

		@Override
		public int compareTo(VertexPair o) {
			return distance - o.distance;
		}
	}

	class VertexPairComparator implements Comparator<VertexPair> {

		@Override
		public int compare(VertexPair o1, VertexPair o2) {
			return o1.distance - o2.distance;
		}

	}

}
