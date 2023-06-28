package com.homework02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Person implements Comparable{
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setIdNumber(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return id == other.id;
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            return this.id - ((Person) o).id;
        }
        return 0;
    }
}
class HashSetTest {
    public static void main(String[] args) {
        HashSet<Person> personHashSet = new HashSet<>();
        personHashSet.add(new Person("张三",12310001));
        personHashSet.add(new Person("李四",12320002));
        personHashSet.add(new Person("王五",12330003));

        Person p4 = new Person("王五",12330003);
        personHashSet.add(p4);

        Iterator<Person> it = personHashSet.iterator();

        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println(next);
        }

        TreeSet<Person> personTreeSet = new TreeSet<>();
        personTreeSet.add(new Person("李四",12320002));
        personTreeSet.add(new Person("张三",12310001));
        personTreeSet.add(new Person("王五",12330003));

        for (Person person : personTreeSet) {
            System.out.println(person);
        }
    }
}
