import java.util.*;
import java.util.function.IntBinaryOperator;

public class Set {
    private final ArrayList<Integer> a;

    public Set() {
        a = new ArrayList<Integer>();
    }

    public int[] toArray() {
        int[] ia = new int[a.size()];
        for (int i = 0; i < ia.length; i++) {
            ia[i] = a.get(i);

        }
        return ia;
    }

    public void insert(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > x) {
                a.add(i, x);
                return;
                // was break here
            } else {
                if (a.get(i) == x) {
                    return;
                   // was break here
                }
            }
        }
        a.add(x);
    }

    public boolean member(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > x) {
                return false;
            } else {
                if (a.get(i) == x) {
                    return true;
                }
            }
        }
        return false;
    }

    public void intersect(Set s) {
        int i = 0;
        for(int j = 0 ; i < a.size() && j < s.a.size();) {
            if (a.get(i).equals(s.a.get(j))){
                i++;
                j++;
            } else {
                if (a.get(i) < s.a.get(j)) {
                    a.remove(i);
                    i++;
                } else {
                    j++;
                }
            }
        }
        for (int k = i; k < a.size();) {
            a.remove(k);
        }
    }

    // Try with:
    //   (a, b) -> a + b;
    //   (a, b) -> a - b;

    // for every element in the set, return true if f(x, y) is in the set

    public boolean distinctClosed(IntBinaryOperator f) {
        if (a.size() < 2) {
            System.out.println("Set is too small");
            return false;
        }
        int vi,vj;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                vi = a.get(i);
                vj = a.get(j);
                if (!(member(f.applyAsInt(vi, vj))) && (vi != vj)) return false;
            }
        }
        return true;
    }
}