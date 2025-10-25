import java.sql.*;

class DatabaseConnection {

    private  static final String url="jdbc:mysql://localhost:3306/messuser";
    private  static final String username="root";
    private static final String pass="Prem@3405";


    public static Connection getconnection()
    {
        Connection con=null;
        try{

            con= DriverManager.getConnection(url,username,pass);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static boolean adduser(String name,String pass)
    {
      String quer="INSERT INTO user(name,password) values(?,?)";

      try {
          Connection con=getconnection();
          PreparedStatement ps=con.prepareStatement(quer);
          ps.setString(1,name);
          ps.setString(2,pass);

          int row= ps.executeUpdate();

          if(row>0)
          {
              System.out.println("User added successfully");
              return true;
          }
          con.close();
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }
      return false;

    }

    public void getalluser()
    {
        String query="Select * from user";
        try
        {
            Connection con =getconnection();
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery(query);

            System.out.println("ID | Name | Password");
            System.out.println("--------------------");
            while (rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getNString("name");
                String pass=rs.getNString("password");
                System.out.println(id + " | " + name + " | " + pass);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static boolean loginUser(String name, String password) {
        String query = "SELECT * FROM user WHERE name = ? AND password = ?";
        Connection con = getconnection();
        try
        {
             PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            // If a row exists, login is successful
            return rs.next();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return false;
    }
    public static  boolean sendmessage(String sender,String receiver,String text)
    {

        if(!userexists(receiver))
        {
            System.out.println("User not found");
            return false;
        }
        String query="INSERT INTO message( sender,receiver,message) values(?,?,?)";

         try{
             Connection con = getconnection();
             PreparedStatement ps= con.prepareStatement(query);
             ps.setString(1,sender);
             ps.setString(2,receiver);
             ps.setString(3,text);

             int row=ps.executeUpdate();

             if(row>0)
             {
                 System.out.println("Message sends successfully");
                 return true;
             }
         }
         catch (Exception e)
         {
             System.out.println(e);
         }
        return false;
    }

    public static  boolean userexists(String receiver)
    {
        String query="SELECT * FROM user where name = ?";
        try{
            Connection con = getconnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,receiver);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    public static void viewchat(String sender,String receiver)
    {
        String query = "SELECT sender, message, mstime FROM message " +
                "WHERE (sender = ? AND receiver = ?) OR (sender = ? AND receiver = ?) " +
                "ORDER BY mstime";

        try{
            Connection con = getconnection();
            PreparedStatement ps= con.prepareStatement(query);

            ps.setString(1,sender);
            ps.setString(2,receiver);
            ps.setString(3,receiver);
            ps.setString(4,sender);

            ResultSet rs= ps.executeQuery();
            System.out.println("----- Chat History -----");
            while (rs.next())
            {
                System.out.println(rs.getString("sender") +": "+rs.getString("message")+"(" + rs.getTimestamp("mstime")+")");

            }
            System.out.println("______________________________________");

        }
        catch (Exception e)
        {
            System.out.println("Error in fectching the chat"+e.getMessage());
        }
    }
    public static boolean updatestatus(String sender)
    {
        String sql="set ";
        try{
            Connection con= getconnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        return false;
    }
    public  static String viewStatus(String user,String status)
    {
        String query="";
        try
        {
            Connection con =getconnection();
            PreparedStatement ps= con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString(1));
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return status;
    }

}
