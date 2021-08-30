package backend.users;

public class UserController implements UserFunctions {

    public static User user = new User();

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserController.user = user;
    }

    @Override
    public void logOut() {
        user.setUsername(null);
        user.setPassword(null);
        user.setEmail(null);
        user.setCity(null);
        user.setFirstName(null);
        user.setLastName(null);
        user.setMasterCard(null);
        user.setVisa(null);
        user.setCredit(null);
    }

    @Override
    public void paymentLimit() {

    }

    @Override
    public void withdrawalLimit() {

    }
}
