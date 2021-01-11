public class main {

    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder a = new Folder("A");
        File f_a = new File("a.txt");
        File f_b = new File("b.txt");
        File f_c = new File("c.txt");
        File f_d = new File("d.txt");
        File f_a_d = new File("a.txt");
        root.addFileSystem(f_c);
        a.addFileSystem(f_a);
        root.addFileSystem(f_d);
        a.addFileSystem(f_b);
        root.addFileSystem(a);
        a.addFileSystem(f_a_d);
        System.out.println(root);
        System.out.println(a);
    }
}
