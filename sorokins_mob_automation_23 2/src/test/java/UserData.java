import dataobjects.User;
import org.testng.annotations.DataProvider;
public class UserData {


    @DataProvider(name = "user-data")
    public static Object[][] createUserData() {
        return new Object[][]{
                {new User("tiweti1200@otanhome.com", "Tiweti1200!","Unregistered User")},
                {new User("wqji321@gqwasd.com", "Warase3459!","Unverified User")},
                {new User("xoheto3034@ngopy.com","qwekwei1932!","Incorrect Password")}
                        };
    }
}