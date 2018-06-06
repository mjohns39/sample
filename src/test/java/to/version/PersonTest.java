package to.version;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private Person dee;
    private Person michael;
    private Person richard;
    
    private Map<String, Person> phoneBook = new HashMap<>();

    @Before
    public void setUp() throws Exception {
    	
    	richard = Person.builder().id(1).name("Richard").friends(Collections.unmodifiableSet(Collections.emptySet())).build();
    	
    	dee = Person.builder().id(2).name("Dee").friends(Stream.of(richard).collect(toSet())).build();
    	
    	michael = Person.builder().id(3).name("Michael").friends(Stream.of(dee, richard).collect(toSet())).build();
    	
    	phoneBook.put(richard.getName(), richard);
    	phoneBook.put(dee.getName(), dee);
    	phoneBook.put(michael.getName(), michael);
    }

    @Test
    public void verify_find_by_name() {
    	assertNotNull(dee.findFriendsByName("Richard"));
    }

    @Test
    public void verify_find_like_name() {
    	assertNotNull(dee.findFriendsLikeName("Ric"));
    }

    @Test
    public void find_all_people_with_certain_friend() {
    	Set<Person> result = phoneBook.entrySet().stream()
    			.filter(e -> !e.getValue().findFriendsByName("Dee").isEmpty())
    			.flatMap(e -> Stream.of(e.getValue()))
    			.collect(toSet())
//    			.collect(toMap(Map.Entry::getKey, Map.Entry::getValue))
//    			.values().stream()
//    			.forEach(p -> System.out.println(p.toString()))
    			;
    	
    	assertTrue(result.size() == 1);
    }
    
}