package lanClient;

import java.util.Arrays;

public class Infos {
    private String[][] infos;

    public Infos(int nbMachines) {
        infos = new String[nbMachines][];
        for (int i = 0; i < nbMachines; i++) {
            infos[i] = new String[10];
        }
    }

    public void setInfos(int index, String[] info) {
        infos[index] = info;
    }

    public void getInfos() {
        for (int i = 0; i < infos.length; i++) {
            System.out.println(Arrays.toString(infos[i]));
        }
    }
}
