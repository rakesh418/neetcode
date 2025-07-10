package graph;

import java.net.ConnectException;
import java.util.Arrays;

public class ConnectedComponents {
    int[] parent;
    int[] rank;

    ConnectedComponents(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public void findConnectedComponents(int[][] edges, int n){
        int count=n;
        for(int[] edge : edges){
            if(isUnion(edge[0], edge[1])){
               count--;
            }
        }
        System.out.println(count);
    }

    public int findParent(int u){
        int curr = u;
        while(parent[curr]!=curr){
            curr=parent[curr];
        }
        return curr;
    }

    public boolean isUnion(int u, int v){
        int pu=findParent(u);
        int pv=findParent(v);
        if(pu==pv){
            return false;
        }
        if(rank[pu]<rank[pv]){
            int temp= rank[pu];
            rank[pu]=rank[pv];
            rank[pv]=temp;
        }
        parent[pv]=pu;
        rank[pu]+=rank[pv];
        return true;
    }


    public static void main(String[] args) {
        int n=6;
        int[][] edges={ {0,1}, {1,2}, {2,3}, {4,5}, {0,5}};
        ConnectedComponents connectedComponents = new ConnectedComponents(n);
        connectedComponents.findConnectedComponents(edges, n);
    }
}
