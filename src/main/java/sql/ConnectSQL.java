package sql;
import java.sql.*;

public class ConnectSQL {
    private String typeOfDatabase;
    private String user;
    private String host;
    private int port;
    private String password;
    private String database;
    private String url;
    public ConnectSQL(){
        typeOfDatabase="postgresql";
        user="postgres";
        host="localhost";
        port=5432;
        password="";
        database="postgres";
        url="jdbc:"+typeOfDatabase+"://"+host+":"+port+"/"+database+"?serverTimezone=UTC";
    }

    public void setTypeOfDatabase(String typeOfDatabase) {
        this.typeOfDatabase = typeOfDatabase;
        url = "jdbc:"+typeOfDatabase+"://"+host+":"+port+"/"+database+"?serverTimezone=UTC";
    }

    public void setDatabase(String database) {
        this.database = database;
        url = "jdbc:"+typeOfDatabase+"://"+host+":"+port+"/"+database+"?serverTimezone=UTC";
    }

    public void setHost(String host) {
        this.host = host;
        url = "jdbc:"+typeOfDatabase+"://"+host+":"+port+"/"+database+"?serverTimezone=UTC";
    }

    public void setPort(int port) {
        this.port = port;
        url = "jdbc:"+typeOfDatabase+"://"+host+":"+port+"/"+database+"?serverTimezone=UTC";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void testConnection() {
        try {
            Connection connection = DriverManager.getConnection(this.url,this.user,this.password);
            System.out.println("Connected to: " + connection.getClientInfo().getProperty("ApplicationName"));
            connection.close();
        } catch (SQLException exception) {
            System.out.println(exception.toString());
            System.exit(1);
        }
    }
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException exception) {
            System.out.println(exception.toString());
        }
        return null;
    }

    public int countRowsOfTable(String name, Connection connection){
        int size = 0;
        Statement statement;
        ResultSet results;
        try{
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT COUNT(*) FROM "+name+";");
            while (results.next()){
                size = results.getInt(1);
            }
            return size;
        }catch (SQLException exception){
            System.out.println(exception.toString());
        }
        return size;
    }

    public int countColumnsOfTable(String name, Connection connection){
        int size = 0;
        Statement statement;
        ResultSet results;
        try{
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_catalog = '"+this.database+"' AND table_name = '"+name+"';");
            while (results.next()){
                size = results.getInt(1);
            }
            return size;
        }catch (SQLException exception){
            System.out.println(exception.toString());
        }
        return size;
    }



    }
