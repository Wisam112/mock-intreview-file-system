import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileSystem that = (FileSystem) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
