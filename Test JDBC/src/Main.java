import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/mydatabase ";
        String username="root";
        String password="Gaurav@123";
        String query ="select * from employee;";
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
            ResultSet rs=stmt.executeQuery(query); // Query to run
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title =rs.getString("job_title");
                double salary =rs.getInt("salary");
                System.out.println();
                System.out.println("================================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job_tile: "+job_title);
                System.out.println("Salary: "+salary);
                System.out.println();
            }
            // Close the Connection
            rs.close();
            stmt.close();
            con.close();
            System.out.println("connection Close Successfully !!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());

        }

    }
}