package OOPsConcept.Poliymorphisum;

public class Main {

    public static void main(String[] args) {
        AdditionCalculator calculator = new AdditionCalculator();
        System.out.println("Addition of 5 and 10: " + calculator.add(5, 10));
        System.out.println("Addition of 5.5 and 10.5: " + calculator.add(5.5, 10.5));

        //Java resolution process - In case of method Overloading
        //Method Overload resolution process - process by which Java compiler decides which method to call and when muiltiple methods are present with same name but different arguments

        //First Java will find the Exact match function and call
        // If there is not exact match then it will type cast by default as implicit type case - int - double(with no data loss)
        // If there is no match then it will give error as Ambiguity error - Java Confused
        // System.out.println("Addition of 5 and 10.5: " + calculator.add(5, 10.5)); // This will give an error

        //Compile time poliymorphisun - same name function with different arguments

        //Method overloading - same name function with different arguments




        //Method overriding - same name function with same arguments - signature of the method is as same as defined in the perant class

        AbstractHunman human = new ActualHunman();
        ActualHunman actualHuman = new ActualHunman();

        human.speak(); // Calls the speak method of ActualHunman
    }   //Which function will be called is decided at runtime
    //In method overloading, the method to be called is determined at compile time based on the method signature (name and parameters).
    //Dynamic method dispatch - In Java, method overriding is a run-time polymorphism feature. It allows a subclass to provide a specific implementation of a method that is already defined in its superclass. When a method is called on an object, the JVM determines which version of the method to execute based on the actual object type at runtime, not the reference type.

}
