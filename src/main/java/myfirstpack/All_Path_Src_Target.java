
/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */

package myfirstpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class All_Path_Src_Target {
  public static List<List<Integer>> allPathsSourceTarget(List<List<Integer>> graph) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    path.add(0);
    dfsSearch(graph, 0, res, path);

    return res;
  }

  private static void dfsSearch(List<List<Integer>> graph, int node, List<List<Integer>> res, List<Integer> path) {
    if (node == graph.size() - 1) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int nextNode : graph.get(node)) {
      path.add(nextNode);
      dfsSearch(graph, nextNode, res, path);
      path.remove(path.size() - 1);
    }
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Please enter number of nodes : ");
    int n = sc.nextInt();
    //int[][] graph = new int[n][];
    List<List<Integer>> graph=new ArrayList<>();
    for(int i=0;i<n;i++)
    {
      System.out.println("Please enter number of edges from this node : ");
      int m = sc.nextInt();
      List<Integer> tmp=new ArrayList<>();
      for(int j=0;j<m;j++)
      {
        int x = sc.nextInt();
        tmp.add(x);
      }
      graph.add(tmp);
    }
    List<List<Integer>> ans=allPathsSourceTarget(graph);

    System.out.println(ans);


  }

}
