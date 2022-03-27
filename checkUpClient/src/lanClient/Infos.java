package lanClient;

public class Infos {
    private static String[][] infos;

    public Infos(int nbMachines) {
        infos = new String[nbMachines][];
        for (int i = 0; i < nbMachines; i++) {
            infos[i] = new String[10];
        }
    }

    public static void setInfos(int index, String[] info) {
        infos[index] = info;
    }

    public static String[][] getInfos() {
        return infos;
    }

    public static int getNbMachines() {
        return infos.length;
    }
}
