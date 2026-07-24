import java.util.ArrayList;
import java.util.List;

// the parent class that branches out to Fan and Artist classes
public abstract class Person {
    private String name;
    private String email;

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getEmail() {
        return this.email;
    }

    // every person has a role but only the child classes actually know what it is
    public abstract String getRole();

    public String toString() {
        return getRole() + ": " + this.name + " (" + this.email + ")";
    }
}


