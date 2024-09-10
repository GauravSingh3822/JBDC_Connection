import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/mydatabase ";
        String username="root";
        String password="Gaurav@123";
        String query ="DELETE FROM employee where id=9";


        // Load the drivers
        try{
            Class.forName("com.mysql.jdbc.Driver"); // Calling the Drivers
            System.out.println("Drivers Loaded Sucessfully !!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        // establish the connection
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection established Successfully !!!");
            Statement stmt=con.createStatement(); // No arguments
            int Rows_Affrected=stmt.executeUpdate(query);

            if(Rows_Affrected>0){
                System.out.println("Deletion Sucessful.."+ Rows_Affrected +"rows affected..");
            }else {
                System.out.println("Deletion Failed !!!");
            }

            // Close the Connection

            stmt.close();
            con.close();
            System.out.println("connection Close Successfully !!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());

        }

    }
}