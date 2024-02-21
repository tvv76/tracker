package ru.bank;

import java.util.Objects;

/**
 * Класс описывает банковские счета и работу с ними
 * @author TVV
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета и баланс хранятся в этих переменных
     */
    private String requisite;
    private double balance;

    /**
     * Единственный конструктор класса. Создает объект с заданными реквизитами и балансом
     * @param requisite - реквизиты создаваемого счета
     * @param balance - баланс создаваемого счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Позволяет получить строку с реквизитами счета
     * @return - строка с реквизитами счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Позволяется изменить реквизиты счета
     * @param requisite - значение реквизита, которое будет установлено
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает актуальный баланс по счету
     * @return баланс по счету
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Позволяет изменить баланс по счету
     * @param balance значение баланса, которое будет установлено
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает счет с другим счетом, в сравнении участвует только поле requisite объектов
     * @param o - объект с которым будет производиться сравнение
     * @return true - если счета идентичны, false - если счета различаются
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хэш-код объекта, основываясь на значении поля requisite
     * @return - хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
