package backend.users;

import java.math.BigDecimal;

public class UserController {

    public static User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        UserController.user = user;
    }

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
}
