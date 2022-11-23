package sql;

import objects.Branch;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BranchCRUD {
    // -------------------- GENERAL -------------------------
    private final ConnectSQL connect;
    private int branchesTableRows;

    public BranchCRUD(ConnectSQL connect){
        this.connect = connect;
        branchesTableRows = 0;
    }

    // --------------------- CRUD ---------------------------
    public Branch[] getBranchesList(){
        Connection connection = connect.getConnection();
        if (connection != null) {
            Statement statement;
            ResultSet results;
            branchesTableRows = connect.countRowsOfTable("branches",connection);
            Branch[] branches = new Branch[branchesTableRows];
            try {
                statement = connection.createStatement();
                results = statement.executeQuery("SELECT * FROM branches;");

                int index = 0;
                while (results.next()){
                    Branch newBranch = new Branch();
                    newBranch.setId(results.getInt("id_branch"));
                    newBranch.setName(results.getString("name_branch"));
                    newBranch.setAddress(results.getString("address_branch"));
                    Array.set(branches,index,newBranch);
                    index++;
                }
                return branches;
            } catch (SQLException exception) {
                System.out.println(exception.toString());
            }

            try {
                connection.close();
            } catch (SQLException exception){
                System.out.println(exception.toString());
            }
        }
        return null;
    }

}
