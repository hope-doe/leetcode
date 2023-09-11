import union_find.NumberOfProvinces;

public class Main {
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        NumberOfProvinces solution = new NumberOfProvinces();

        System.out.println(solution.findCircleNum(isConnected));
    }
}
