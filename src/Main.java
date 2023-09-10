import union_find.CountIslands;

public class Main {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}
        };

        CountIslands solution = new CountIslands();

        System.out.println(solution.numIslands(grid));
    }
}
