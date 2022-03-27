package lanClient;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class window {
    JFrame frame;
    public window() {
        //String[][] data = Infos.getInfos();

        /* Thread th = new Thread(){
            public void run() {
                synchronized(data) {
                    while(true){
                        data = infos.getInfos();
                    }
                }
            }
        }; */

        frame = new JFrame("CheckUp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JTable table = new JTable(Infos.getInfos(), new String[]{"Machine", "OS", "Taille du disque", "Espace libre du disque", "Ram", "Espace libre de la ram", "Nom du CPU", "Fréquence du CPU", "Charge du CPU", "Température"});

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
