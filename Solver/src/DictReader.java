import java.util.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

class DictReader {

	private Path filePath;
	private final Charset ENCODING = StandardCharsets.UTF_8;
	private Tree dictionary = new Tree();

	DictReader(String fileName) {
		filePath = Paths.get(fileName);
	}

	public void getFileName(String fileName) {
	    filePath = Paths.get(fileName);
	}

	//Mengambil nilai dari file eksternal per baris
	public final void processLineByLine() throws IOException {
		try (Scanner scanner =  new Scanner(filePath, ENCODING.name()))
		{
	    	//Algoritma
	    	while (scanner.hasNextLine())
	    	{
	    		dictionary.addWord(scanner.nextLine());
	    	}
	   }
	}

	public Tree getTree() {
		return dictionary;
	}
}
