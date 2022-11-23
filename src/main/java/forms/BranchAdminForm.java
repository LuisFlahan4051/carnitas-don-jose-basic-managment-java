package forms;

import objects.Branch;
import sql.BranchCRUD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BranchAdminForm extends JFrame{
    private final BranchCRUD branchCRUD;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel1;
    private JTable table1;

    public BranchAdminForm(BranchCRUD branchCRUD){
        this.branchCRUD = branchCRUD;
        setContentPane(panel1);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawTable();
    }

    private void clearInputs(){

    }

    private void drawTable(){
        DefaultTableModel newModel = new DefaultTableModel();
        Branch[] branches = branchCRUD.getBranchesList();

        newModel.setColumnIdentifiers(new Object[]{"ID","NOMBRE","DIRECCIÓN"});
        for (Branch branch : branches) {
            newModel.addRow(new Object[]{
                    branch.getId(),
                    branch.getName(),
                    branch.getAddress()
            });
        }
        table1.setModel(newModel);

        clearInputs();
    }

}
