package forms;

import javax.swing.*;


public class UserAdmin extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTable table1;

    public UserAdmin(){
        setContentPane(panel1);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    };

}
