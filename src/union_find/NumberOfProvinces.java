package union_find;

public class NumberOfProvinces {
    private int provincesCounter = 0;

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i ++) {
            if (!visited[i]) {
                provincesCounter++;
                markProvince(isConnected, i, visited);
            }
        }

        return provincesCounter;
    }

    private void markProvince(int[][] isConnected, int index, boolean[] visited) {
        visited[index] = true;

        for (int j = 0; j < isConnected.length; j ++) {
            if (isConnected[index][j] == 1 && !visited[j]) {
                markProvince(isConnected, j, visited);
            }
        }
    }
}
