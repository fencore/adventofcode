import java.util.ArrayList;

public class Directory {
    private String dirName;
    private String parentDirName;
    private ArrayList<Integer> files;
    private ArrayList<Directory> subDirs;
    
    public Directory(String name,  String parent) {
        this.dirName = name;
        this.parentDirName = parent;
    }

    /*public Directory (String name,  String parent, int[] filesList, String[] dirsList){
        this.dirName = name;
        this.parentDirName = parent;
        files.add(filesList);
        subDirs.add();
    } this is a really bad idea we'll leave it for later*/

    public int getDirSize() {
        int size = 0;
        for (Directory dir : this.subDirs) {
            size += dir.getDirSize();
        }
        for (int i : this.files) {
            size += i;
        }
        return size;
    }

    public void addDir(String s) {
        this.subDirs.add(new Directory(s, this.dirName));
    }

    public void addFile(int i) {
        this.files.add(i);
    }

    public String getParentDir() {
        return this.parentDirName;
    }

    public String getDirName() {
        return this.dirName;
    }

    public ArrayList<> getAllSubDirs() {

    }
}