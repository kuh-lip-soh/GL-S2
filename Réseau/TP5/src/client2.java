
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class client2 extends JFrame implements ActionListener {
Socket sock = null;
BufferedReader sockIn = null;
PrintWriter sockOut = null;

private JButton jbtGetSympt = new JButton("Afficher les symptômes");
private JTextField jtfNom = new JTextField();
private JTextArea jtaSympt = new JTextArea(10, 30);

public client2() {
    JPanel panneau = new JPanel();
    panneau.setLayout(new GridLayout(2, 2));
    panneau.add(new JLabel("Nom du patient"));
    panneau.add(jtfNom);
    panneau.add(new JLabel("Symptômes"));
    JScrollPane scrollPane = new JScrollPane(jtaSympt);
    panneau.add(scrollPane);
    add(panneau, BorderLayout.CENTER);
    add(jbtGetSympt, BorderLayout.SOUTH);
    jbtGetSympt.addActionListener(this);
}

public void init() {
    try {
        sock = new Socket("localhost", 5555);
        sockIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        sockOut = new PrintWriter(sock.getOutputStream(), true);
    } catch (IOException e) {
        System.out.println("Erreur de connexion au serveur");
        e.printStackTrace();
        System.exit(-1);
    }
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtGetSympt) {
        String nomPatient = jtfNom.getText().trim();
        if (nomPatient.equals("")) {
            jtaSympt.setText("Veuillez saisir un nom de patient");
        } else {
            try {
                sockOut.println(nomPatient);
                String line;
                while ((line = sockIn.readLine()) != null) {
                    jtaSympt.append(line + "\n");
                }
                if (jtaSympt.getText().isEmpty()) {
                    jtaSympt.setText("Aucun symptôme trouvé pour ce patient");
                }
            } catch (IOException ex) {
                System.out.println("Erreur lors de la communication avec le serveur");
                ex.printStackTrace();
                System.exit(-1);
            }
        }
    }
}

public static void main(String[] args) {
    client2 client = new client2();
    client.init();
    client.setTitle("Affichage des symptômes");
    client.setSize(400, 300);
    client.setLocationRelativeTo(null);
    client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    client.setVisible(true);
}


}