package stack_and_queue;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque(nestedList);
    }

    @Override
    public Integer next() {
        if (stack.isEmpty()) throw new IllegalStateException("Next called on an empty stack.");

        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        return surfaceInteger();
    }

    private boolean surfaceInteger() {
        if (stack.isEmpty()) {
            return false;
        } else {
            if (stack.peek().isInteger()) {
                return true;
            } else {
                List<NestedInteger> nestedList = stack.pop().getList();

                for (int i = nestedList.size() - 1; i >= 0; i --) {
                    stack.addFirst(nestedList.get(i));
                }

                return surfaceInteger();
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
