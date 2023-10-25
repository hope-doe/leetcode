package stack_and_queue;

import java.util.LinkedList;

class HitCounter {

    LinkedList<Integer> hits;
    int fiveMinutes = 300;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.addFirst(timestamp);
    }

    public int getHits(int timestamp) {
        int count = 0;
        int fiveMinutesBeforeTimestamp = timestamp - fiveMinutes;

        int index = 0;
        while (hits.size() > index && hits.get(index) > fiveMinutesBeforeTimestamp) {
            index ++;
            count ++;
        }

        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
