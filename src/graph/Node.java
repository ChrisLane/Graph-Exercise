package graph;

import ilist.IList;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;

import java.util.Stack;
import java.util.function.Predicate;

public class Node<A> {
    private A nodeContent;
    private IList<Node<A>> successors;

    public Node(A nodeContent, IList<Node<A>> successors) {
        this.nodeContent = nodeContent;
        this.successors = successors;
    }

    public A getNodeContent() {
        return nodeContent;
    }

    public void setNodeContent(A nodeContent) {
        this.nodeContent = nodeContent;
    }

    public IList<Node<A>> getSuccessors() {
        return successors;
    }

    public void setSuccessors(IList<Node<A>> successors) {
        this.successors = successors;
    }

    public Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {
        Stack<Node<A>> stack = new Stack<>();

        stack.push(x);

        while (!stack.isEmpty()) {
            Node<A> current = stack.pop();

            if (current == p)
                return new Just<>(current);
        }
        return new Nothing<>();
    }
}