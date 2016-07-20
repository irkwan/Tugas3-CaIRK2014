
package mymodule;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * ExtensionFilter
 * Kelas yang akan mengerjakan prosedur filtering ekstensi suatu file.
 * @author Albertus Kelvin
 */
public class ExtensionFilter extends FileFilter {

    String description = "";
    String fileExt = "";

    public ExtensionFilter(String extension) {
        fileExt = extension;
    }

    public ExtensionFilter(String extension, String typeDescription) {
        fileExt = extension;
        this.description = typeDescription;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        return (f.getName().toLowerCase().endsWith(fileExt));
    }

    @Override
    public String getDescription() {
        return description;
    }
}
