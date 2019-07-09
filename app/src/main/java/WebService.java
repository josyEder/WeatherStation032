import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class WebService {
    final static  String url = "jdbc:mysql://localhost:3306/weatherstation";
    final static  String user = "josy";
    final static String password = "unicorn4life#1";


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String login(@FormParam("email") String email, @FormParam("password") String password){
        String result="false";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement("select * from user where userEmail=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                result = "true";
            }

            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }


    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String register(@FormParam("email") String email, @FormParam("password") String password){
        String result="false";
        int x = 0;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement("insert into login(email, password) values(?,?)");
            ps.setString(1, email);
            ps.setString(2, password);

            x = ps.executeUpdate();

            if(x==1){
                result = "true";
            }

            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }

}
