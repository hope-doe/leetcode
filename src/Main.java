import union_find.MostStonesRemoved;

public class Main {
    public static void main(String[] args) {
        int[][] stones5 = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};

        MostStonesRemoved solution = new MostStonesRemoved();

        System.out.println(solution.removeStones(stones5));
    }
}
