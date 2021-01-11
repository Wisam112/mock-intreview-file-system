public abstract class FileSystem {
    private String name;

    public FileSystem(String name) {
        if(name == null || name.length() == 0) throw new IllegalArgumentException("File name cant be null or empty!");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
