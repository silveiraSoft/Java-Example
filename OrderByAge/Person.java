import java.util.Objects;
public class Person{

    private Long ID;
    private String name;
    private int age;

    public Person(Long ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }
    /* 
    //implemente methods equal and hashcode to no repetir person by ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(ID, person.ID);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
        */
    
    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
}
