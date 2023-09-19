package union_find;

public class MostStonesRemoved {
    int stonesToRemoveCounter = 0;

    public int removeStones(int[][] stones) {
        boolean[] belongsToGroup = new boolean[stones.length];

        for (int i = 0; i < stones.length; i++) {
            if (!belongsToGroup[i]) {
                belongsToGroup[i] = true;

                int x = stones[i][0];
                int y = stones[i][1];

                stonesToRemoveCounter += countForX(belongsToGroup, stones, x) + countForY(belongsToGroup, stones, y);
            }
        }

        return stonesToRemoveCounter;
    }

    private int countForX(boolean[] belongsToGroup, int[][] stones, int x) {
        int localCounter = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!belongsToGroup[i]) {
                int nextX = stones[i][0];
                int nextY = stones[i][1];

                if (x == nextX) {
                    belongsToGroup[i] = true;
                    localCounter++;
                    localCounter += countForY(belongsToGroup, stones, nextY);
                }
            }
        }

        return localCounter;
    }

    private int countForY(boolean[] belongsToGroup, int[][] stones, int y) {
        int localCounter = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!belongsToGroup[i]) {
                int nextX = stones[i][0];
                int nextY = stones[i][1];

                if (y == nextY) {
                    belongsToGroup[i] = true;
                    localCounter++;
                    localCounter += countForX(belongsToGroup, stones, nextX);
                }
            }
        }
        return localCounter;
    }

}
