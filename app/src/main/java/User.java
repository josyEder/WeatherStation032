import java.util.SimpleTimeZone;

public class User {
    //Properties
    private static String _usernmae;
    private static String _useremail;
    private static String _userpassword;
    private static Boolean _userIsAdmin;
    private static String _userFirstName;
    private static String _userLastName;


    public User() {
    }

    public User(String username, String useremail, String userpassword, Boolean admin, String fn, String ln) {
        this._usernmae = username;
        this._useremail = useremail;
        this._userpassword = userpassword;
        this._userFirstName = fn;
        this._userIsAdmin = admin;
        this._userLastName = ln;
    }

    public static Boolean get_userIsAdmin() {
        return _userIsAdmin;
    }

    public static void set_userIsAdmin(Boolean _userIsAdmin) {
        User._userIsAdmin = _userIsAdmin;
    }

    public static String get_userFirstName() {
        return _userFirstName;
    }

    public static void set_userFirstName(String _userFirstName) {
        User._userFirstName = _userFirstName;
    }

    public static String get_userLastName() {
        return _userLastName;
    }

    public static void set_userLastName(String _userLastName) {
        User._userLastName = _userLastName;
    }

    public static String get_usernmae() {
        return _usernmae;
    }

    public static void set_usernmae(String _usernmae) {
        User._usernmae = _usernmae;
    }

    public static String get_useremail() {
        return _useremail;
    }

    public static void set_useremail(String _useremail) {
        User._useremail = _useremail;
    }

    public static String get_userpassword() {
        return _userpassword;
    }

    public static void set_userpassword(String _userpassword) {
        User._userpassword = _userpassword;
    }


    @Override
    public String toString() {
        return "FirstName: " + get_userFirstName() + " Lastname: " + get_userLastName() + " Admin: "+ get_userIsAdmin() + " Username : " + get_usernmae() + " Email: " + get_useremail() + " Password: " + get_userpassword();}
}
