package Atomic_volatile_variables;

public class User {
    public String name;
    public int age;
    public User()
    {
        name = "Mukesh";
        age = 18;
    }

    public User(String n, int a)
    {
        name = n;
        age = a;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
