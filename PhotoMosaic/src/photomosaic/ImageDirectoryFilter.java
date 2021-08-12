package photomosaic;

import java.io.File;
import java.io.FileFilter;
/**
 *
 * @author Daniel Neves Camargo 
 * Fluminense Federal University
 * 21031151
 * 18/03/2013
 */
class ImageDirectoryFilter implements FileFilter{

    @Override
    public boolean accept(File file) {
        
        return file.isFile() && !file.isHidden();
    }
    
}
