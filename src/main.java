public class main {

    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder a = new Folder("A");
        File f_a = new File("a.txt");
        File f_b = new File("b.txt");
        File f_c = new File("c.txt");
        File f_d = new File("d.txt");
        root.addFileSystem(f_c);
        a.addFileSystem(f_a);
        root.addFileSystem(f_d);
        a.addFileSystem(f_b);
        root.addFileSystem(a);
        root.addFileSystem("root/A/f_a_d.txt", 0);
        root.addFileSystem("root/g.txt", 0);
        root.addFileSystem("root/c", 1);
        root.addFileSystem("root/c/z.txt", 0);
        root.deleteFileSystem("root/c/z.txt");
        root.deleteFileSystem("root/c");
        System.out.println(root);
        System.out.println(root.search("a.txt"));
    }
}
