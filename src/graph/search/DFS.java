package graph.search;

import graph.Node;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.Predicate;

public class DFS<A> {

    public Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {
        Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
        Stack<Node<A>> stack = new Stack<Node<A>>();

        stack.push(x);

        while (!stack.isEmpty()) {
            Node<A> current = stack.pop();

            if (visited.contains(current)) {
                if (current.getContents() == p)
                    return new Just<Node<A>>(current);
                visited.add(current);
                for (int i = 0; i < current.getSuccessors().size(); i++) {
                    stack.push((Node<A>) current.getSuccessors());
                }
            }
        }
        return new Nothing<Node<A>>();
    }
}
