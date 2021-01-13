package graphTheoryYoutube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DFSAlgorithm{
	int n;//number of nodes
	HashMap<Integer, ArrayList<Integer>> adj ;
	HashMap<Integer, Boolean> visited;
	public DFSAlgorithm(int n) {
		// TODO Auto-generated constructor stub
		this.n=n;
		visited=new HashMap<Integer, Boolean>();
		adj=new HashMap<Integer, ArrayList<Integer>>();
	}
	public void addEdge(int start, int end) {
		if(!adj.containsKey(start)) addVertex(start);
		if(!adj.containsKey(end)) addVertex(end);
		adj.get(start).add(end);
		adj.get(end).add(start);
	}
	public void addVertex(int data) {
		adj.put(data, new ArrayList<Integer>());
		visited.put(data, false);
	}
	public void print() {
		Set<Integer> keys=adj.keySet();
		for(int element: keys) {
			System.out.println("node:"+element+" connections:"+adj.get(element));
		}
		for(int element: keys) {
			System.out.print(visited.get(element));
		}
		System.out.println();
	}
	private void dfsHelper(int at) {
		if(visited.get(at)) return;
		visited.put(at,true);
		System.out.print(at+" ");
		ArrayList<Integer> neighbours=new ArrayList<Integer>(adj.get(at));
		for(int next: neighbours) {
			dfsHelper(next);
		}
		
	}
	public void dfs(int at) {
		dfsHelper(at);
		System.out.println();
	}
	
	public static void main(String[] args) {
		DFSAlgorithm graph=new DFSAlgorithm(6);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(0,3);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(4,1);
		graph.addEdge(4,2);
		graph.addEdge(6, 6);
		graph.print();
		int startNode=2;
		graph.dfs(startNode);
		graph.print();
	}
	
}
//class Edge{
//	int b,e,cost;
//	public Edge(int b, int e, int cost) {
//		// TODO Auto-generated constructor stub
//		this.b=b;
//		this.e=e;
//		this.cost=cost;
//	}
//}
