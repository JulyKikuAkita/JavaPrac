import java.io.Serializable;
import java.util.HashMap;

/* http://coderevisited.com/singleton/
 * 
 * A singleton is simply a class that is instantiated exactly once
 * 
 * Singletons typically represent a system component that is intrinsically unique, such as Java Runtime, the window manager or file system
 * 
 * There are 2 ways to implement singletons. 
 * In Both ways, We suppress the constructor and don’t allow even a single instance for the class. 
 * But we declare a static member to hold the sole instance of our singleton class
 * 
 * 
Enum Singleton
Enum Singletons are relatively new concept and in practice from Java 5 onwards after introduction of Enum as keyword.

Advantages
easy to write when compared to lazy inititialization approach
Enum Singletons handle serialization by default
Creation of enum instance is thread safe.
 */

public class singleton_all {
	
	public static void main(String[] args){
		
		/*
		 the name is the name that you'd use to dynamically load the class with, 
		 for example, a call to Class.forName with the default ClassLoader.
		 
		the canonical name is the name that would be used in an import statement and uniquely identifies the class. 
		Might be useful during toString or logging operations.
		
		the simple name loosely identifies the class, again might be useful during toString or 
		logging operations but is not guaranteed to be unique.
		 */
		//primitive
		System.out.println(int.class.getName());
		System.out.println(int.class.getCanonicalName());
		System.out.println(int.class.getSimpleName());

		System.out.println();

		//class
		System.out.println(String.class.getName());
		System.out.println(String.class.getCanonicalName());
		System.out.println(String.class.getSimpleName());

		System.out.println();

		//inner class
		System.out.println(HashMap.SimpleEntry.class.getName());
		System.out.println(HashMap.SimpleEntry.class.getCanonicalName());
		System.out.println(HashMap.SimpleEntry.class.getSimpleName());        

		System.out.println();

		//anonymous inner class
		System.out.println(new Serializable(){}.getClass().getName());
		System.out.println(new Serializable(){}.getClass().getCanonicalName());
		System.out.println(new Serializable(){}.getClass().getSimpleName());
		
		
		/* print result
		int
		int
		int

		java.lang.String
		java.lang.String
		String

		java.util.AbstractMap$SimpleEntry
		java.util.AbstractMap.SimpleEntry
		SimpleEntry

		ClassnameTest$1
		null
		// empty line here //
		*/
		
		
	}
	
}

enum SingletonEnum{
	INSTANCE;
	
	public String toString(){
		return getDeclaringClass().getCanonicalName() + "@" + hashCode();
	}
		
	
}

// If your application always creates and uses singleton instance 
// or the overhead of creation and runtime aspects of the singleton are not onerous, 
// this early initialization is preferred.
class SingletonEarly{
	
	private final static SingletonEarly instance = new SingletonEarly();
	
	private SingletonEarly(){};
	
	public static SingletonEarly getInstance(){
		return instance;
	}
}

//Lazy Initialization
class SingletonLazyUnSafe
{
    private static SingletonLazyUnSafe instance;
 
    private SingletonLazyUnSafe()
    {
        // Suppressing creating a new instances
    }
 
    public static SingletonLazyUnSafe getInstance()
    {
        if (instance == null) {
            instance = new SingletonLazyUnSafe();
        }
        return instance;
    }
}

// Creating a static factory method, sole instance gets created. 
// a performance trade off.
class SingletonLazySynchronized
{
    private static SingletonLazySynchronized instance;
 
    private SingletonLazySynchronized()
    {
 
    }
 
    public static synchronized SingletonLazySynchronized getInstance()
    {
        if (instance == null)
            instance = new SingletonLazySynchronized();
        return instance;
    }
}


// Double-checked locking
// Disadvantage of double checking
// This solution will not work in Java 1.4 or earlier. 
// Many JVMs in Java version 1.4 
// and earlier contains implementation of the volatile keyword that allow improper synchronization of double checked locking.
class SingletonLazyDoubleChecked
{
    private volatile static SingletonLazyDoubleChecked instance;
    
    private SingletonLazyDoubleChecked(){}
    
    public static SingletonLazyDoubleChecked getInstance(){
    	
    	if(instance == null){ //first checking
    		synchronized(SingletonLazyDoubleChecked.class){
    			if (instance == null){  //double checking
        			instance = new SingletonLazyDoubleChecked();
    			}
    		}
    	}
    	return instance;
    }
}

/*
Serializable
To make a singleton class serializable, it is not sufficient merely to add implements Serializable to its declaration. 
To maintain the singleton guarantee, you have to declare all instance fields transient and provide a readResolve method. 
Otherwise, each time a serialized instance is deserialized, a new instance will be created
readResolve works only when all fields are transient.

Cloneable
Preferred way is to not to implement Cloneable interface since why do we need another copy of singleton object.

*/
class SingletonLazyHolder
{
    private SingletonLazyHolder()
    {
 
    }
 
    public static SingletonLazyHolder getInstance()
    {
        return LazyHolder.INSTANCE;
    }
 
    private static class LazyHolder
    {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }
 
 
}