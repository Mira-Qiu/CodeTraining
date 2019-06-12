// Union find solution in Java

class UnionFind{
    private int[] father = null;
    private int count;
    
    private int find(int x){
        if (father[x] == -1)
            return x;
        return father[x] = find(father[x]);
    }
    
    public UnionFind(int n){
        father = new int[n];
        for (int i = 0; i < n; i++)
            father[i] = -1;
    }
    
    public void connect(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b){
            father[root_a] = root_b;
            count--;
        }
    }
    
    public int query(){
        return count;
    }
    public void set_count(int total){
        count = total;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length, m = grid[0].length;
        int count = 0;
        UnionFind uf = new UnionFind(n * m);
        int total = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == '1')
                    total++;
            }
        }
        uf.set_count(total);
        for (int i = 0; i < n;i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    if (i > 0 && grid[i - 1][j] == '1') 
                        uf.connect(i * m + j, (i - 1) * m + j);
                    if (j > 0 && grid[i][j - 1] == '1') 
                        uf.connect(i * m + j, i * m + j - 1);
                }
            }
        }
        return uf.query();
    }
    
}
