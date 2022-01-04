import com.google.gson.Gson;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        /*Client cl = new Client();
        try {
            cl.makeRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Patient p = new Patient("Nicolas",1234,5678);
        Gson gson = new Gson();
        String jsonString = gson.toJson(p);

        try {
            cl.makePostRequest(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";

        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        Connection conn= DriverManager.getConnection(dbUrl, "postgres", "PASSWORD");

        try {
            //System.out.println("It reaches here");
            Statement s2=conn.createStatement();
            int timepoint1=1;
            int timepoint2=3;
            String sqlStr = "SELECT signal1[" + timepoint1 + ":" + timepoint2 + "] FROM arraytester WHERE true;";
            ResultSet resset=s2.executeQuery(sqlStr);
            int i=1;
            while(resset.next()){
                System.out.println(resset.getArray(i));
                i++;
            }
            resset.close();
            s2.close();
            conn.close();
        }
        catch (Exception e){
        }

    }
}