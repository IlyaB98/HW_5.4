import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private int age;

    private List<User> users = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<User> deleteCopy() {
        List<User> newListUsers = users.stream()
                .sorted()
                .distinct()
                .toList();
        return newListUsers;
    }

    public List<User> sortedListUsers() {
        List<User> sortedListUsers = users.stream()
                .sorted()
                .toList();
        return sortedListUsers;
    }

    public User oldUser() {
        User oldUser = users.stream()
                .max(Comparator.comparing(User::getAge))
                .get();
        return oldUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
