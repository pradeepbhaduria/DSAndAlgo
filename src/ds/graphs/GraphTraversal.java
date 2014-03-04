package ds.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
	public static final int MAX_VERTICES = 10;
	boolean[][] adjacencyMatrix = null;
	Vertex[] vertices = null;
	int noOfVertices = 0;
	Stack<Integer> stack = new Stack<Integer>();
	Queue<Integer> queue = new LinkedList<Integer>();
	
	GraphTraversal(int noOfVertices) {
		vertices = new Vertex[MAX_VERTICES];
		adjacencyMatrix = new boolean[MAX_VERTICES][MAX_VERTICES];
	}
	
	public static void main(String[] args) {

		GraphTraversal graph = new GraphTraversal(9);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("I");

		graph.addEdge(0, 1);// A,B
		graph.addEdge(0, 2);// A,C
		graph.addEdge(0, 3);// A,D
		graph.addEdge(0, 4);// A,E
		graph.addEdge(1, 5);// B,F
		graph.addEdge(5, 7);// F,H
		graph.addEdge(3, 6);// D,G
		graph.addEdge(6, 8);// G,I
		
		graph.traverseDFS(0);
		//graph.traverseBFS(0);
	}

	void traverseDFS(int beginVertex) {
		vertices[beginVertex].setVisited(true);
		stack.push(beginVertex);
		displayVertex(beginVertex);
		int newVertex = -1;
		while ((newVertex = getAdjacentVertex(beginVertex)) != -1) {
			traverseDFS(newVertex);
		}
		if (!stack.empty()) {
			newVertex = getAdjacentVertex(stack.pop());
			if (newVertex != -1) {
				traverseDFS(newVertex);
			}
		}
	}

	void traverseBFS(int beginVertex) {
		vertices[beginVertex].setVisited(true);
		displayVertex(beginVertex);
		int newVertex;
		while ((newVertex = getAdjacentVertex(beginVertex)) != -1) {
			vertices[newVertex].setVisited(true);
			queue.add(newVertex);
		}
		
		if(queue.peek()!=null){
			traverseBFS(queue.remove());
		}
	}

	void addEdge(int from, int to) {
		adjacencyMatrix[from][to] = true;
		adjacencyMatrix[to][from] = true;
	}

	void addVertex(String name) {
		Vertex vertex = new Vertex(name);
		vertices[noOfVertices++] = vertex;
		
	}

	private int getAdjacentVertex(int vertex) {
		int adjacentVertex = -1;
		for (int i = 1; i < noOfVertices; i++) {
			if (adjacencyMatrix[vertex][i] && !vertices[i].isVisited()) {
				adjacentVertex = i;
				break;
			}
		}
		return adjacentVertex;
	}

	private void displayVertex(int vertex) {
		System.out.print(vertices[vertex].getName());
	}
}

class Vertex {
	String name;
	boolean visited;

	Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
