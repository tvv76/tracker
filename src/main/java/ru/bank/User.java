package ru.bank;

import java.util.Objects;

/**
 * Класс описывает клиентов банка и работу с ними
 * @author TVV
 * @version 1.0
 */
public class User {
    /**
     * Паспортные данные и имя клиента
     */
    private String passport;
    private String username;

    /**
     * Единственный конструктор класса. Создает объект с указанными паспортными данными и именем
     * @param passport - данные паспорта клиента
     * @param username - имя клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает паспортные данные клиента
     * @return - паспортные данные клиента
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Позволяет изменить паспортные данные клиента
     * @param passport - новые паспортные данные
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя клиента
     * @return имя клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * Позволяет изменить имя клиента
     * @param username - новое имя клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает текущего клиента с другим объектом.
     * Сравнение учитывает только паспортные данные, поскольку
     * они однозначно идентифицируют клиента, а имя может меняться
     * @param o - объект с которым будет производиться сравнение
     * @return - true, если объекты равны, false - если объекты различаются
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хэш-код объекта, основываясь на значении поля requisite
     * @return - хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
