
package solver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 *
 * @author Albertus Kelvin
 */
public class ModelCreator {

    // location of dictionary
    private final String dictLOC;

    public ModelCreator(String dictLOC) {
        this.dictLOC = dictLOC;
    }

    public Node init() throws IOException {
        LineIterator iterator = FileUtils.lineIterator(new File(dictLOC));

        Node root = new Node();
        root.setWord(false);

        while (iterator.hasNext()) {
            String line = iterator.next().toLowerCase().trim();
            createNodes(line, root, 0).setWord(true);
        }

        return root;
    }

    private static Node createNodes(String line, Node current, int index) {
        if (index != line.length()) {
            Node next = current.createOrGet(line.charAt(index));
            return createNodes(line, next, index+1);
        } else {
            return current;
        }
    }
}
