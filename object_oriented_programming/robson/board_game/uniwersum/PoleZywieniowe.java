package zad1.uniwersum;

import zad1.rob.Rob;

public class PoleZywieniowe extends Pole {
    private final int ile_daje_jedzenie;
    private final int ile_rosnie_jedzenie;
    private boolean czy_rosnie_jedzenie;
    private int od_ilu_tur_rosnie_jedzenie;
    private boolean czy_jest_jedzenie;

    public PoleZywieniowe(int ind_x, int ind_y, int ile_daje_jedzenie, int ile_rosnie_jedzenie) {
        super(ind_x, ind_y);
        this.ile_daje_jedzenie = ile_daje_jedzenie;
        this.ile_rosnie_jedzenie = ile_rosnie_jedzenie;
        this.czy_jest_jedzenie = true;
        this.czy_rosnie_jedzenie = false;
        this.od_ilu_tur_rosnie_jedzenie = 0;
    }

    public boolean isCzy_jest_jedzenie() {
        return czy_jest_jedzenie;
    }

    public void nakarm_roba(Rob rob) {
        czy_jest_jedzenie = false;
        od_ilu_tur_rosnie_jedzenie = 0;
        czy_rosnie_jedzenie = true;

        rob.zjedz(ile_daje_jedzenie);
    }

    public void urosnij_jedzenie() {
        if(czy_rosnie_jedzenie) {
            od_ilu_tur_rosnie_jedzenie++;
            if (od_ilu_tur_rosnie_jedzenie >= ile_rosnie_jedzenie) {
                czy_jest_jedzenie = true;
                od_ilu_tur_rosnie_jedzenie = 0;
                czy_rosnie_jedzenie = false;
            }
        }
    }
}
