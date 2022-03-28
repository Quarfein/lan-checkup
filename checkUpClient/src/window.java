
import javax.swing.*;

public class window {
    JFrame frame;
    public window() {

        frame = new JFrame("CheckUp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        JTable table = new JTable(Infos.getInfos(), new String[]{"Machine", "OS", "Taille du disque", "Espace libre du disque", "Ram", "Espace libre de la ram", "Nom du CPU", "Fréquence du CPU", "Charge du CPU", "Température"});

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);

        frame.setVisible(true);

        Thread th = new Thread() {
            public void run() {
                while(true){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    table.repaint();
                    System.out.println(Infos.getInfos().toString);
                }
            }
        };

        th.run();
    }
}
