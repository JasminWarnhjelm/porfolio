import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame implements ActionListener {
    public Window(Info person) {
        setTitle("Contacts App");
        setSize(700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] headers = {"ID-Number", "First Name", "Last Name", "Phone Number", "Address", "E-Mail"};  //otsikko

        Object[][] data = {
            {person.getIDNumber(), person.getFirstName(), person.getLastName(),
             person.getPhoneNumber(), person.getAddress(), person.getEMail()}
             }; //tiedot

        DefaultTableModel model = new DefaultTableModel(data, headers);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table); //lisätään taulukko scrollpaneliin

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JButton save = new JButton("Save");
        save.addActionListener(this);
        add(save, BorderLayout.SOUTH);

        //toiminto ??
        JMenuBar menuBar = new JMenuBar ();  //valikko
        JMenu fileMenu = new JMenu ("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //save all changes
    }
}