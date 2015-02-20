package graph;

import ilist.IList;

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
}