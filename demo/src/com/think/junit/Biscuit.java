package com.think.junit;

/**
 * Created by borney on 11/28/16.
 */
public class Biscuit {
    private String ginger;

    public Biscuit(String ginger) {
        this.ginger = ginger;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Biscuit)) {
            return false;
        }

        Biscuit b = (Biscuit) obj;
        if (b.ginger == null) {
            return this.ginger == null;
        }
        return b.ginger.equals(this.ginger);
    }

    @Override
    public int hashCode() {
        if (ginger == null) {
            return super.hashCode();
        } else {
            return ginger.hashCode();
        }
    }

    public int getChocolateChipCount() {
        return 10;
    }

    public int getHazelnutCount() {
        return 4;
    }
}
