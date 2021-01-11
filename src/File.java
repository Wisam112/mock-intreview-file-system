public class File extends FileSystem {

    public File(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
