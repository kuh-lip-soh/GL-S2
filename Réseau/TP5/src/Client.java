



import java.awt.*;

import java.awt.event.*;

import java.io.*;

import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener {

Socket sock = null;

DataOutputStream sockOut = null;

DataInputStream sockIn = null;

private JButton jbtGetMoy = new JButton("Afficher les nombre de fois ");

private JTextField jtfNom = new JTextField();

private JTextField jtfMoy = new JTextField();

public Client(){

JPanel panneau = new JPanel();

panneau.setLayout(new GridLayout(2, 2));

panneau.add(new JLabel("symptome"));

panneau.add(jtfNom);

panneau.add(new JLabel("nombre de fois "));

panneau.add(jtfMoy);

add(panneau, BorderLayout.CENTER);

add(jbtGetMoy, BorderLayout.SOUTH);

jbtGetMoy.addActionListener (this);

}

public void init() {

try {sock = new Socket("localhost", 5555);

sockOut = new DataOutputStream(sock.getOutputStream());

sockIn = new DataInputStream(sock.getInputStream());

} catch (UnknownHostException e) {

System.err.println("host non atteignable : localhost");

System.exit(1);

} catch (IOException e) {

System.err.println("connection impossible avec : localhost");

System.exit(1);

}

}

@Override

public void actionPerformed(ActionEvent e) {
    int result = 0;
    try {
        sockOut.writeUTF(jtfNom.getText().trim());
        sockOut.flush();
        result = sockIn.readInt();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    jtfMoy.setText(Integer.toString(result));
}

public static void main(String[] args) {

Client a = new Client();

a.setTitle("traitement des symptome ");

a.setSize(350, 150);

a.init();

a.setLocationRelativeTo(null);

a.setVisible(true);

}

}