package to.version;

import java.util.Collection;
import java.util.Set;

import static java.util.Collections.emptyList;

public class Person {

    private long id;
    private String name;
    private Set<Person> friends;

    public Person(long id) {
        this.id = id;
    }

    public Person(String name, Set<Person> friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    /**
     * Where friends who have the exact name
     */
    public Collection<Person> findFriendsByName(String name) {
        return emptyList();
    }

    /**
     * Where friends who have a name starting with the name provided
     */
    public Collection<Person> findFriendsLikeName(String name) {
        return emptyList();
    }

}
