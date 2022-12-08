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

    public Directory (String name,  String parent, ArrayList<Integer> filesList){
        this.dirName = name;
        this.parentDirName = parent;
        this.files.addAll(filesList);
    }

    public Directory (String name,  String parent, String[] dirsList){
        this.dirName = name;
        this.parentDirName = parent;
        for (String s : dirsList) {
            this.addDir(s);
        }
    }

    public Directory (String name,  String parent, ArrayList<Integer> filesList, String[] dirsList){
        this.dirName = name;
        this.parentDirName = parent;
        this.files.addAll(filesList);
        for (String s : dirsList) {
            this.addDir(s);
        }
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

    public ArrayList<Directory> getSubsOfCurrentDir() {
        this.dirSize = this.calcDirSize();
        return this.subDirs;
    }

    public void addDir(String s, ArrayList<Integer> i) {
        this.subDirs.add(new Directory(s, this.dirName));

    }

    public void addFile(int i) {
        this.files.add(i);
    }

    public String getDirName() {
        return this.dirName;
    }

    public ArrayList<Directory> getRecursiveSubDirs() {
        ArrayList<Directory> arr = new ArrayList<Directory>();
        this.dirSize = this.calcDirSize();
        for (Directory dir : subDirs) {
            arr.addAll(dir.getRecursiveSubDirs());
        }
        return arr;
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
        if (foundFlag = false) {
            this.addDir(s);
        }
        return retDir;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Integer i : files) {
            s.append(i.toString()+"\n");
        }
        for (Directory d : subDirs) {
            s.append(d.getDirName()+"\n");
        }
        return s.toString();
    }

    public String fullHierarchyString() {
        StringBuilder s = new StringBuilder();
        for (Integer i : files) {
            s.append(i.toString()+"\n");
        }
        for (Directory d : subDirs) {
            s.append(d.getDirName()+"\n");
        }
        for (Directory d : subDirs) {
            s.append(d.fullHierarchyString());
        }
        return s.toString();
    }
}