import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ClientPlus extends JFrame implements ActionListener {
Socket sock = null;
DataOutputStream sockOut = null;
DataInputStream sockIn = null;
private final JButton jbtGetMoy = new JButton("Qui est le major ?");
private final JTextField jtfNom = new JTextField();
private final JTextField jtfMoy = new JTextField();

public ClientPlus(){
JPanel panneau = new JPanel(); 
panneau.setLayout(new GridLayout(2, 2));
panneau.add(new JLabel("Section"));
panneau.add(jtfNom);
panneau.add(new JLabel("Major de promo")); 
panneau.add(jtfMoy);
add(panneau, BorderLayout.CENTER);
add(jbtGetMoy, BorderLayout.SOUTH);
jbtGetMoy.addActionListener (this);
}

public void init() {     
    try {sock = new Socket("localhost", 7777); 
      sockOut = new DataOutputStream(sock.getOutputStream()); 
      sockIn = new DataInputStream(sock.getInputStream());
    } catch (UnknownHostException e) {
      System.err.println("Host non atteignable : localhost");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Connexion impossible avec : localhost");
      System.exit(1);
    }
 }


 @Override
 public void actionPerformed (ActionEvent e) {
 String score="Erreur";
 try {
 sockOut.writeUTF(jtfNom.getText().trim());
 sockOut.flush(); 
} catch (IOException ex) {}
 try {score = sockIn.readUTF();} catch (IOException ex) {}
    jtfMoy.setText(score);
 }
 
public static void main(String[] args) { 
Client a = new Client();
a.setTitle("Rechercher le Major");
a.setSize(350, 150);
a.init();
a.setLocationRelativeTo(null);
a.setVisible(true);
 } 
}
