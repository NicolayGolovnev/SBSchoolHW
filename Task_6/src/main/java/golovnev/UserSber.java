package golovnev;

import java.util.Arrays;
import java.util.Objects;

public class UserSber {
    private String username;
    private String email;
    private byte[] passwordHash;


    /**
     * Конструктор пользователя Сбера с двумя параметрами: имя пользователя и его почта
     * @param username имя пользователя
     * @param email электронная почта
     */
    public UserSber(String username, String email) {
        this.username = username;
        this.email = email;
        this.passwordHash = username.getBytes();
    }

    /**
     * Геттер для имени пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для имени пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Геттер для почты
     * @return электронная почта
     */
    public String getEmail() {
        return email;
    }

    /**
     * Сеттер для почты
     * @param email электронная почта
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Геттер для пароля
     * @return пароль
     */
    public byte[] getPasswordHash() {
        return passwordHash;
    }

    /**
     * Сеттер для пароля
     * @param passwordHash пароль
     */
    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Метод сравнения двух пользователей Сбера
     * @param o объект сравнения
     * @return true - если объекты одинаковые, false - разные
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSber userSber = (UserSber) o;
        return Objects.equals(username, userSber.username) && Objects.equals(email, userSber.email) && Arrays.equals(passwordHash, userSber.passwordHash);
    }

    /**
     * Метод генерации хэш-кода
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(username, email);
        result = 31 * result + Arrays.hashCode(passwordHash);
        return result;
    }
}
