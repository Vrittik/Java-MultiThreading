package Atomic_volatile_variables;

import java.util.concurrent.atomic.AtomicReference;

public class SharedResource_AtomicReference {
    AtomicReference<User> userAtomicReference = new AtomicReference<>(new User());

    public void setNewUser(User user)
    {
        userAtomicReference.set(user);
    }

    public void getUser(){
        User user = userAtomicReference.get();
        System.out.println("New user properties - Name = " + user.getName() + " Age = " + user.getAge()
        + " HashCode = " + user.hashCode());
    }
}
