package libiada.EventTheory;

import libiada.Root.IBaseObject;
import libiada.Root.IBin;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class DimensionBin implements IBin {
    private long max;
    private long min;

    long getMin() {
        return min;
    }

    long getMax() {
        return max;
    }

    public IBaseObject GetInstance() {
        return null;  //TODO: "????????? ?????"
    }

    public void setMin(long min) {
        this.min = min;
    }

    public void setMax(long max) {
        this.max = max;
    }
}
