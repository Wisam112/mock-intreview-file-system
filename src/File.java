public class File extends FileSystem {

    /**
     * File class constructor
     * @param  name the name of the file
     */
    public File(String name) {
        super(name);
    }

    /**
     * toString override function
     * @return      a string to print
     */
    @Override
    public String toString() {
        return getName();
    }
}
