package main;

import com.formdev.flatlaf.FlatDarculaLaf;
import forms.BranchAdminForm;
import sql.BranchCRUD;
import sql.ConnectSQL;


public class App
{
    public static void main( String[] args )
    {
        // Here can use in a try UIManager.SetLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName())
        FlatDarculaLaf.setup();

        ConnectSQL connect = new ConnectSQL();
        connect.setUser("luisf");
        connect.setPassword("4051");
        connect.setDatabase("carnitas_db");
        connect.testConnection();
        BranchCRUD branchCRUD = new BranchCRUD(connect);

        new BranchAdminForm(branchCRUD);
    }
}
