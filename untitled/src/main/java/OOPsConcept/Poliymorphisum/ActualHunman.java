package OOPsConcept.Poliymorphisum;

public class ActualHunman extends AbstractHunman {
    @Override
    public void speak() {
        System.out.println("Hello, I am an actual human.");
    }
}

//Method Overriding - same name function with same arguments - signature of the method is as same as defined in the perant class

//In method overriding, the child class provides a specific implementation of a method that is already defined in its parent class.