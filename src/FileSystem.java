import java.util.Objects;

public abstract class FileSystem {
    private String name;

    /**
     * Class constructor.
     * @param  name the name of the file system
     * @return      an object of type FileSystem
     */
    public FileSystem(String name) {
        if(name == null || name.length() == 0) throw new IllegalArgumentException("File name cant be null or empty!");
        this.name = name;
    }

    /**
     * name field getter
     * @return      the name of the object
     */
    public String getName() {
        return name;
    }

    /**
     * name field setter
     * @param  name the new name of the file system
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Check if the given object is equal to this object
     * @param  o the object that we want to compare to
     * @return      true of they are equals false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileSystem that = (FileSystem) o;
        return Objects.equals(name, that.name);
    }

    /**
     * @return      the hash code of the class
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
