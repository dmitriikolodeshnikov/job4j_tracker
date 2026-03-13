package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

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
        User user = findByPassport(passport);
        users.remove(user);

    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> userAccounts = users.get(user);
        if (!userAccounts.contains(account)) {
            userAccounts.add(account);
        }

    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> userAccounts = users.get(user);
        for (Account account : userAccounts) {
            if (requisite.equals(account.getRequisite())) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        if (amount <= 0) {
            return false;
        }

        User sourceUser = findByPassport(sourcePassport);
        User destinationUser = findByPassport(destinationPassport);
        if (sourceUser == null || destinationUser == null) {
            return false;
        }

        List<Account> sourceAccounts = users.get(sourceUser);
        List<Account> destinationAccounts = users.get(destinationUser);
        if (sourceAccounts == null || destinationAccounts == null) {
            return false;
        }

        Account sourceAccount = null;

        for (Account account : sourceAccounts) {
            if (sourceRequisite.equals(account.getRequisite())) {
                sourceAccount = account;
                break;
            }
        }

        Account destinationAccount = null;
        for (Account account : destinationAccounts) {
            if (destinationRequisite.equals(account.getRequisite())) {
                destinationAccount = account;
                break;
            }
        }

        if (sourceAccount == null || destinationAccount == null) {
            return false;
        }

        if (sourceAccount.getBalance() < amount) {
            return false;
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}