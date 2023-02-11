import dataobjects.User;
import org.testng.annotations.DataProvider;
public class UserData {


    @DataProvider(name = "valid-user-data")
    public static Object[][] createUserData() {
        return new Object[][]{
                {new User("nivoxop429@fsouda.com", "Nivoxop429!")},
                        //Valid user data
                        {new User("wqji321@gqwasd.com", "lweqlwqe")}
                        //UnRegistered user data
                        };
    }
}