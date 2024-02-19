package ru.bank;

import ru.bank.Account;
import ru.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        User fakeUser = new User(passport, "fake");
        users.remove(fakeUser);
    }

    public void addAccount(String passport, Account account) {
        User fakeUser = new User(passport, "fake");
        List<Account> accounts = users.get(fakeUser);
        if (accounts == null || accounts.contains(account)) {
            return;
        }
        accounts.add(account);
    }

    public User findByPassport(String passport) {
        User fakeUser = new User(passport, "fake");
        for (User user : users.keySet()) {
            if (user.equals(fakeUser)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account fakeAccount = new Account(requisite, 0);
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        for (Account account : users.get(user)) {
            if (account.equals(fakeAccount)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}