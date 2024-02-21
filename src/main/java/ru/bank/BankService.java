package ru.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает функционирование банковской системы
 * позволяя производить операции создания, удаления и поиска клиентов банка, создания и поиска их счетов,
 * а так же производить переводы средств между счетами
 * @author TVV
 * @version 1.0
 */
public class BankService {
    /**
     * Карта, содержащая сведения о клиентах и их счетах. У каждого клиента может быть множество счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Создает нового клиента банка, если клиент с таким паспортом отсутствует в списке
     * при создании клиенту сразу же присваивается пустой список со счетами.
     * Если клиент уже существует, то ничего не меняется.
     * @param user - клиент, который будет добавлен
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаление клиента с указанными паспортными данными
     * @param passport - паспортные данные удаляемого клиента
     */
    public void deleteUser(String passport) {
        User fakeUser = new User(passport, "fake");
        users.remove(fakeUser);
    }

    /**
     * Создает новый счет для клиента
     * @param passport - паспортные данные клиента, для которого будет открыт счет
     * @param account - открываемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Возвращает клиента с указанными паспортными данными.
     * Возвращает null если поиск неуспешен
     * @param passport - паспортный данные искомого клиента
     * @return - найденный клиент или null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Возвращает счет по паспортным данным клиента реквизитам счета.
     * Возвращает null если данные указаны неверно
     * @param passport - паспортные данные клиента
     * @param requisite - реквизиты искомого счета
     * @return - объект с данными найденного счета или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Переводит деньги с одного счета на другой.
     * @param sourcePassport паспортные данные клиента, осуществляющего перевод
     * @param sourceRequisite реквизиты счета, с которого будут списаны деньги
     * @param destinationPassport паспортные данные получателя перевода
     * @param destinationRequisite реквизиты счета, на который будут зачислены деньги
     * @param amount сумма перевода
     * @return true - если перевод совершен успешно, false - если перевод неудачен.
     */
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

    /**
     * Возвращает список счетов клиента
     * @param user - клиент, чей список счетов запрошен
     * @return список счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
