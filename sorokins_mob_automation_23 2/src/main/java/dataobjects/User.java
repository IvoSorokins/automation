package dataobjects;

public class User {
    private  String email;
    private  String password;

    private String expectedErrorMessage;

    public User(String email, String password, String expectedErrorMessage) {
        this.email = email;
        this.password = password;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    public  String getEmail() {return email;}

    public  String getPassword() {return password;}

    public String getErrorMessage(){return expectedErrorMessage;}

    @Override
    public String toString() {
        return "User{" +
                "  email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", errormessage'" +expectedErrorMessage + '\''+
                '}';
    }
}
