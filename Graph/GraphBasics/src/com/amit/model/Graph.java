package com.amit.model;

public class Graph {

	int vertices;
	DoublyLinkedList[] adjacencyList;
	
	public Graph(int vertices) {
		this.vertices= vertices;
		adjacencyList= new DoublyLinkedList[vertices];
		for(int i=0; i< vertices; i++)
		{
			adjacencyList[i]= new DoublyLinkedList();
		}
	}
	
	public void addEdge(int source, int destination)
	{
		if(source>=vertices || destination>= vertices)
		{
			System.out.println("source or destination is greated than allowed vertices");
			return;
		}		
		adjacencyList[source].insertAtEnd(destination);
	}
	
	public void printGraph() {
		System.out.println("========== directed graph ==============");
		for (int i = 0; i < vertices; i++) {
			System.out.print(i + "=>");
			if (adjacencyList[i] != null) {
				DoublyLinkedList.Node tempNode = adjacencyList[i].getHead();
				while (tempNode != null) {
					System.out.print(tempNode.data + "->");
					tempNode = tempNode.next;
				}
				System.out.println();
			}
		}
	}

	/**
	 * @return the vertices
	 */
	public int getVertices() {
		return vertices;
	}

	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	/**
	 * @return the adjacencyList
	 */
	public DoublyLinkedList[] getAdjacencyList() {
		return adjacencyList;
	}

	/**
	 * @param adjacencyList the adjacencyList to set
	 */
	public void setAdjacencyList(DoublyLinkedList[] adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
}
