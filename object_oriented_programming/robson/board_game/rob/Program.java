package zad1.rob;

import java.util.*;

public class Program {
    private int dl_programu;
    private final ArrayList<SpisInstrukcji> program;
    private final double pr_usuniecia_inst;
    private final double pr_dodania_instr;
    private final double pr_zmiany_instr;

    public void wypisz_program() {
        for (SpisInstrukcji spisInstrukcji : program) {
            System.out.print(spisInstrukcji);
        }
    }

    public Program mutuj(ArrayList<SpisInstrukcji> spis_instr) {
        Program nowy_program = new Program(this.program, pr_usuniecia_inst, pr_dodania_instr, pr_zmiany_instr);

        Random rand = new Random();
        double pr = rand.nextDouble();

        if(pr <= pr_usuniecia_inst) {
            if(this.program.size() > 0) {
                int ind_to_remove = rand.nextInt(this.program.size());
                nowy_program.program.remove(ind_to_remove);
                nowy_program.dl_programu--;
            }
        }

        if(pr <= pr_dodania_instr) {
            SpisInstrukcji nowa_instr = spis_instr.get(new Random().nextInt(spis_instr.size()));
            nowy_program.program.add(nowa_instr);
            nowy_program.dl_programu++;
        }

        if(pr <= pr_zmiany_instr) {
            if(this.program.size() > 0) {
                SpisInstrukcji zmieniona_instr = spis_instr.get(new Random().nextInt(spis_instr.size()));
                int ind_to_change = rand.nextInt(this.program.size());
                nowy_program.program.set(ind_to_change, zmieniona_instr);
            }
        }

        return nowy_program;
    }

    public Program(ArrayList<SpisInstrukcji> program, double pr_usuniecia_inst,
                   double pr_dodania_instr, double pr_zmiany_instr) {
        this.program = new ArrayList<>(program);
        this.pr_usuniecia_inst = pr_usuniecia_inst;
        this.pr_dodania_instr = pr_dodania_instr;
        this.pr_zmiany_instr = pr_zmiany_instr;
        this.dl_programu = program.size();
    }

    public int getDl_programu() {
        return dl_programu;
    }

    public SpisInstrukcji daj_instrukcje(int i) {
        return program.get(i);
    }
}
