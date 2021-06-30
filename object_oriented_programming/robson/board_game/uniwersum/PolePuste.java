package zad1.uniwersum;

import zad1.rob.Rob;

public class PolePuste extends Pole {
    public PolePuste(int ind_x, int ind_y) {
        super(ind_x, ind_y);
    }

    public boolean isCzy_jest_jedzenie() {
        return false;
    }

    public void nakarm_roba(Rob rob) {
    }

    public void urosnij_jedzenie() {
    }
}
