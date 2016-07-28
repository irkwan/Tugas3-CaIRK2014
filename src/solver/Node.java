
package solver;

/**
 *
 * @author Albertus Kelvin
 */
public class Node {

    private boolean word;
    private Node[] branches = new Node[26];

    public boolean isWord() {
        return word;
    }

    public void setWord(boolean word) {
        this.word = word;
    }

    public Node getNode(char c) {
        int i = c - 'a';
        return branches[i];
    }

    public Node createOrGet(char c) {
        Node n = getNode(c);
        if (n == null) {
            n = new Node();
            branches[c - 'a'] = n;
        }

        return n;
    }
}