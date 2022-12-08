import java.util.ArrayList;

public class Directory {
    private String dirName;
    private String parentDirName;
    private ArrayList<Integer> files = new ArrayList<Integer>();
    private ArrayList<Directory> subDirs = new ArrayList<Directory>();
    private int dirSize;
    
    public Directory() {
            
    }

    public Directory(String name,  String parent) {
        this.dirName = name;
        this.parentDirName = parent;
    }

    public int getDirSize() {
        this.dirSize = this.calcDirSize();
        return this.dirSize;
    }

    private int calcDirSize() {
        int size = 0;
        for (Directory dir : this.subDirs) {
            size += dir.calcDirSize();
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

    public String getDirName() {
        return this.dirName;
    }

    public Directory moveToSubDir(String s) {
        Directory retDir = new Directory();
        Boolean foundFlag = false;
        for (Directory d : subDirs) {
            if (d.getDirName().compareTo(s) == 0) {
                retDir = d;
                foundFlag = true;
                break;
            }
        }
        if (!foundFlag) {
            this.addDir(s);
        }
        return retDir;
    }

    public ArrayList<Integer> sizeHierarchy() {
        ArrayList<Integer> s = new ArrayList<Integer>();
        s.add(this.getDirSize());
        for (Directory d : subDirs) {
            s.addAll(d.sizeHierarchy());
        }
        return s;
    }
}