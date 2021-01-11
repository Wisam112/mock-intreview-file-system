import java.util.ArrayList;

public class Folder extends FileSystem {
    private final ArrayList<FileSystem> subFiles;

    public Folder(String name) {
        super(name);
        subFiles = new ArrayList<FileSystem>();
    }

    private int findIndexToInsertTo(String name) {
        int index_to_insert = 0;
        for(FileSystem sub_file : subFiles) {
            String curr_name = sub_file.getName();
            if(curr_name.compareTo(name) >= 0) {
                break;
            }
            index_to_insert++;
        }
        return index_to_insert;
    }

    public void addFileSystem(FileSystem to_insert) {
        int index_to_insert = findIndexToInsertTo(to_insert.getName());
        subFiles.add(index_to_insert, to_insert);
    }

    public void deleteFileSystem(String name) {

    }

    private String toStringHelper(String spaces) {
        StringBuilder output = new StringBuilder(spaces + this.getName() + "\n");
        for(FileSystem sub_file : subFiles) {
            if(sub_file instanceof Folder) {
                output.append(((Folder) sub_file).toStringHelper(spaces + "\t"));
            } else {
                output.append(spaces).append("\t").append(sub_file).append("\n");
            }
        }
        return output.toString();
    }

    @Override
    public String toString() {
        return this.toStringHelper("");
    }

    private String searchHelper(String path) {
        return "";
    }

    public String search() {
        return searchHelper("");
    }
}
