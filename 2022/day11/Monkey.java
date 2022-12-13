import java.util.List;

public class Monkey {
    private List<Integer> items;
    private char inspectOp;
    private int inspectFactor;
    private int trueDest;
    private int falseDest;

    public Monkey (List<Integer> arr, char op, int factor, int trueD, int falseD) {
        items = arr;
        inspectOp = op;
        inspectFactor = factor;
        trueDest = trueD;
        falseDest = falseD;
    }

    private parseOperator() {
        
    }
}
