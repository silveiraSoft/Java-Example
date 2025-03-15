import java.net.IDN;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class OrderbyAge {
    public static void main(String[] args) {
        
        Person[] persons = new Person[5];
        persons[0] = new Person(1L, "John", 20);
        persons[1] = new Person(2L, "Jane", 30);
        persons[2] = new Person(3L, "Jack", 25);
        persons[3] = new Person(3L, "Jack", 25);
        persons[4] = new Person(4L, "Jill", 40);
        System.out.println("************V1***************");    
        for (int i = 0; i < persons.length; i++) {
            for (int j = i + 1; j < persons.length; j++) {
                if (persons[i].getAge() > persons[j].getAge()) {
                    Person temp = persons[i];
                    persons[i] = persons[j];
                    persons[j] = temp;
                }
            }
        }

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].getName() + " " + persons[i].getAge());
        }
        System.out.println("make a copy of persons without duplicate person with same ID");
        List<Person> personList2 = Arrays.asList(persons);
        personList2.stream().distinct().forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );
        //make a copy of persons without duplicates person with same ID use Stream use set and compare with ID
        //create clase pererson and implemenmte the method equals and hashcode
        
        //List<Person> personList2 = Arrays.asList(persons);

        System.out.println("make a copy of persons without duplicate person with same ID using set");
        Set<Person> personSet6 = new HashSet<>(personList2);
        personSet6.forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );

        System.out.println("Array to stream");
        Stream<Person> personStream = Arrays.stream(persons);
        personStream.forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );


        System.out.println("Array to stream and deleting duplicated by ID using TreeSet"); 
        //Set<Person> personSet81 = personStream.sorted(Comparator.comparing(Person::getAge).reversed())
        Set<Person> personSet81 = Arrays.stream(persons).sorted((p1, p2) -> p2.getAge() - p1.getAge())
        // .forEach(
        //personStream.sorted(Comparator.comparing(Person::getAge)).forEach( 
        //        p -> System.out.println(p.getName() + " " + p.getAge())
        //)
        //distinct por ID
        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getID))));
        //.collect(Collectors.toSet());
        //.forEach(p->System.out::println);
 
        personSet81.stream().forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
        System.out.println("make a copy of persons without duplicate person with same ID");

        Stream<Person> personStream1 = Arrays.stream(persons);
        personStream1.distinct().forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );

        System.out.println("************Ordering usin Arrays.sort***************");

        Arrays.sort(persons, (p1,p2)->Integer.compare(p2.getAge(), p1.getAge()));
        for (Person person : persons) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        System.out.println("************V2 revert***************");
        
        List<Person> personList = Arrays.asList(persons);
        personList.sort((p1, p2) -> p2.getAge() - p1.getAge());
        personList.forEach(
          //System.out::println 
          p -> System.out.println(p.getName() + " " + p.getAge()) 

        );

        //***Convert List to Array*******
        Person[] personsArray = personList.toArray(new Person[personList.size()]);
        
        Stream<Person> personStream5 = Arrays.stream(personsArray);
        personStream5.forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );

        //converting List to stream
        Stream<Person> personStream2 = personList.stream();
        
        personStream2.forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );
        
        //delete duplicared from persons array
        List<Person> personList3 = Arrays.asList(persons);
        personList3.stream().distinct().forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );

        //delete duplicared from persons array storing in a set
        Set<Person> personSet1 = new HashSet<>(personList);
        personSet1.forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );
            
        //delete duplicared from persons array storing in a set and order by age
        List<Person> personList4 = Arrays.asList(persons);
        personList4.stream().distinct().sorted((p1, p2) -> p1.getAge() - p2.getAge()).forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );
        
        //store personList4 in a set
        Set<Person> personSet2 = new HashSet<>(personList4);
        
        /* 
        //use treeSet to store personList
        TreeSet<Person> personTreeSet = new TreeSet<>(personSet2);
        personTreeSet.forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );
        
         
        TreeSet<Person> personTreeSet2 = new TreeSet<>(personList);
        personTreeSet2.forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        );

        */ 
        System.out.println("Ordering by age using TreeSet");
        TreeSet<Person> personTreeSet3 = new TreeSet<>((p1, p2) -> p2.getAge() - p1.getAge());
        //inicialize personList3 with persons array
        personList3.stream().forEach(
                p -> personTreeSet3.add(p)
        );
        personTreeSet3.forEach(
                p -> System.out.println(p.getName() + " " + p.getAge())
        ); 
        
        
        List<Person> personList5 = Arrays.asList(persons);
        List<Person> personList6 = new ArrayList<>(personList5);



        Collections.sort(personList6, (p1, p2) -> p1.getAge() - p2.getAge());
        Collections.sort(personList, (p1,p2)->p1.getAge()-p2.getAge());

        System.out.println("Sorted student1 by age: " + personList);
        System.out.println("------------------");

        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.reverse(list);
        array = list.toArray(new Integer[0]);
        for (Integer integer : array) {
            System.out.println(integer);
        }




        

        

    






    }
}
