package to.version;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private long id;
    private String name;
    private Set<Person> friends;

//    public Person(long id) {
//        this.id = id;
//    }
//
//    public Person(String name, Set<Person> friends) {
//        this.name = name;
//        this.friends = friends;
//    }


    /**
     * Where friends who have the exact name
     */
    public Collection<Person> findFriendsByName(String name) {
        return friends.stream().filter(f -> f.getName().equals(name)).collect(toSet());
    }

    /**
     * Where friends who have a name starting with the name provided
     */
    public Collection<Person> findFriendsLikeName(String name) {
        return friends.stream().filter(f -> f.getName().startsWith(name)).collect(toSet());
    }

}
