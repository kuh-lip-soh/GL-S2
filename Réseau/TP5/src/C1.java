
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C1 extends JFrame implements ActionListener {
    private JComboBox<String> dataTypeComboBox;
    private JTextField filePathField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton sendButton;

    public C1() {
        super("IHM Client");

        // Cr�er les �l�ments de l'IHM
        JLabel dataTypeLabel = new JLabel("Type de donnee :");
        String[] dataTypes = {"Image", "Fichier Texte"};
        dataTypeComboBox = new JComboBox<>(dataTypes);
        dataTypeComboBox.setPreferredSize(new Dimension(200, 20));
        JLabel filePathLabel = new JLabel("Chemin du fichier :");
        filePathField = new JTextField(18);
        JLabel usernameLabel = new JLabel("Nom d'utilisateur :");
        usernameField = new JTextField(18);
        JLabel passwordLabel = new JLabel("Mot de passe :");
        passwordField = new JPasswordField(18);
        sendButton = new JButton("Envoyer");

        // Cr�er les layouts
        FlowLayout layout1 = new FlowLayout();
        FlowLayout layout2 = new FlowLayout();
        FlowLayout layout3 = new FlowLayout();
        FlowLayout layout4 = new FlowLayout();
        FlowLayout layout5 = new FlowLayout();

        // Ajouter les �l�ments aux layouts
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GRAY);
        panel1.setLayout(layout1);
        panel1.add(dataTypeLabel);
        panel1.add(dataTypeComboBox);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GRAY);
        panel2.setLayout(layout2);
        panel2.add(filePathLabel);
        panel2.add(filePathField);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GRAY);
        panel3.setLayout(layout3);
        panel3.add(usernameLabel);
        panel3.add(usernameField);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.GRAY);
        panel4.setLayout(layout4);
        panel4.add(passwordLabel);
        panel4.add(passwordField);

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.GRAY);
        panel5.setLayout(layout5);
        panel5.add(sendButton);

        // Ajouter les panels � l'IHM
        setLayout(new GridLayout(5, 1));
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);

        // Ajouter les gestionnaires d'�v�nements
        sendButton.addActionListener(this);

        // Afficher l'IHM
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            // R�cup�rer le type de donn�e, le chemin du fichier, le nom d'utilisateur et le mot de passe
            String type = (String) dataTypeComboBox.getSelectedItem();
            String filePath = filePathField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Cr�er une instance de la classe Client et l'ex�cuter dans un thread
            Client3 client = new Client3(type, filePath, username, password);
            Thread thread = new Thread(client);
            thread.start();
        }
    }

    public static void main(String[] args) {
        new C1();
    }
}

