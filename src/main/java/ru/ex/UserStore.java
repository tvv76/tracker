package ru.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login != null && login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("User " + login + " not found.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("User should be valid.");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Username should be 3 letters or longer.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ivan Ivanov", true)
        };
        User user = null;
        try {
            user = findUser(users, "Ivan Ivanov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException eui) {
            eui.printStackTrace();
        } catch (UserNotFoundException eunf) {
            eunf.printStackTrace();
        }
    }
}
