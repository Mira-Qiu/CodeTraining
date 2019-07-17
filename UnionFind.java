import java.util.Arrays;

public class UF{
    private int[] parent;
    private int[] rank;

    public int find(int i){
        if (i != parent[i]){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if (rank[px] > rank[py]){
            parent[py] = px;
        } else if( rank[px] < rank[py]){
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public UF(int max){
        parent = new int[max];
        rank = new int[max];
        for (int i = 0; i < max; i++){
            parent[i] = i;
        }
    }
    public String toString(){
        return "<UnionFind\np " + Arrays.toString(parent) + "\nr" + Arrays.toString(rank) + "\n>";
    }

    public static void main(String[] args) {

        UF uf = new UF(5);
        System.out.println(uf);
    
        uf.union(1,4);
        System.out.println("union 1 2");
        System.out.println(uf);
    
        uf.union(1,2);
        System.out.println("union 1 2");
        System.out.println(uf);
    
        uf.union(3,4);
        System.out.println("union 3 4");
        System.out.println(uf);
    
        uf.union(1,0);
        System.out.println("union 1 0");
        System.out.println(uf);
    
        uf.union(1,3);
        System.out.println("union 1 3");
        System.out.println(uf);
    
        uf.find(4);
        System.out.println("find 4");
        System.out.println(uf);
    
      }
    
}

/**
<UnionFind
p [0, 1, 2, 3, 4]
r[0, 0, 0, 0, 0]
>
union 1 2
<UnionFind
p [0, 1, 2, 3, 1]
r[0, 1, 0, 0, 0]
>
union 1 2
<UnionFind
p [0, 1, 1, 3, 1]
r[0, 1, 0, 0, 0]
>
union 3 4
<UnionFind
p [0, 1, 1, 1, 1]
r[0, 1, 0, 0, 0]
>
union 1 0
<UnionFind
p [1, 1, 1, 1, 1]
r[0, 1, 0, 0, 0]
>
union 1 3
<UnionFind
p [1, 1, 1, 1, 1]
r[0, 2, 0, 0, 0]
>
find 4
<UnionFind
p [1, 1, 1, 1, 1]
r[0, 2, 0, 0, 0]
>

*/
