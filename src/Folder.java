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

    private Folder getDirectoryFromPath(String[] path, int index) {
        if(index >= path.length) return null;
        if(!path[index].equals(this.getName())) return null;
        if(index == path.length-2) return this;
        for(FileSystem subFile : subFiles) {
            if(subFile instanceof Folder) {
                Folder temp = ((Folder) subFile).getDirectoryFromPath(path, index + 1);
                if(temp != null) {
                    return temp;
                }
            }
        }
        return null;
    }

    public void addFileSystem(FileSystem to_insert) {
        int index_to_insert = findIndexToInsertTo(to_insert.getName());
        subFiles.add(index_to_insert, to_insert);
    }

    public void addFileSystem(String path, int type) {
        if(type != 0 && type != 1) throw new IllegalArgumentException("Type should be 0 (File) or 1 (Folder)");
        String[] sub_paths = path.split("/");
        String name = sub_paths[sub_paths.length - 1];
        Folder folder = getDirectoryFromPath(sub_paths, 0);
        if(folder == null) throw new RuntimeException("Folder does not exists!");
        int index_to_insert = folder.findIndexToInsertTo(name);
        if(type == 0) {
            folder.subFiles.add(index_to_insert, new File(name));
        } else {
            folder.subFiles.add(index_to_insert, new Folder(name));
        }
    }

    public void deleteFileSystem(String path) {
        String[] sub_paths = path.split("/");
        String name = sub_paths[sub_paths.length - 1];
        Folder folder = getDirectoryFromPath(sub_paths, 0);
        if(folder == null) throw new RuntimeException("Folder does not exists!");
        FileSystem to_delete = null;
        for(FileSystem subFile : folder.subFiles) {
            if(subFile.getName().equals(name)) {
                to_delete = subFile;
                break;
            }
        }
        if(to_delete == null) throw new RuntimeException("File or folder doesnt exists!");
        folder.subFiles.remove(to_delete);
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

    private void searchHelper(ArrayList<String> paths, String path, String name) {
        if(this.getName().equals(name)) {
            paths.add(path);
        }
        for(FileSystem subFile : subFiles) {
            if(subFile instanceof Folder) {
                ((Folder)subFile).searchHelper(paths, path + "/" + subFile.getName(), name);
            } else {
                if(subFile.getName().equals(name)) {
                    paths.add(path);
                }
            }
        }
    }

    public String search(String name) {
        StringBuilder output = new StringBuilder();
        ArrayList<String> paths = new ArrayList<String>();
        searchHelper(paths, this.getName(), name);
        for(String path : paths) {
            output.append(path).append("\n");
        }
        return output.toString();
    }
}
