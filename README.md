# Challenge

Answer # 1

  Abstract Class
  
    •	In design, you want the base class to present only an interface for its derived classes. This means, you don’t want anyone to actually instantiate an object of the base class. You only want to upcast to it so that its interface can be used. This is accomplished by making that class abstract using the abstract keyword. If anyone tries to make an object of an abstract class, the compiler prevents it.
    
    •	Abstract class has executable methods & Abstract methods.
    
    •	Can only subclass one abstract class.
  e.g
    
    public abstract Animal {
       public void eat(Food food) {
            // do something with food.... 
       } 

       public abstract void makeNoise();
    }

    public Cow extends Animal {
       public void makeNoise() { Toast.show ("Moo! Moo!"); }
    }

  Interface
  
    •	The interface keyword takes this concept of an abstract class a step further by preventing any method or function implementation at all. You can only declare a method or function but not provide the implementation. The class, which is implementing the interface, should provide the actual implementation. The interface is a very useful and commonly used aspect in OO design, as it provides the separation of interface and implementation.
    
    •	Have no implementation code. All methods are abstract.
    
    •	A class can implement any number of interfaces.

  e.g
    
    Interface Animal  {
      Public void eat();
    }

    Public class Mammal implements Animal {
      Public void eat() {
        Toast.show(“ Mammal eats”);
      }
    }
= = = = = = = = = = = = = = = =

Answer # 3

  Activity
  
    Activities are top-level application components that manage a hierarchy of views. An activity cannot be inserted into a view hierarchy, it must always be the root, and there is always exactly one active Activity at any given time.
  
  Fragment
  
    Fragments are view containers that contain a hierarchy of views. A fragment must be inserted into a view hierarchy, with an Activity as its root. There can be zero or more active fragments at any given time.
    
 = = = = = = = = = = = = = = = =

Answer # 4

  We can use interface to communicate back to hosting activity.
  
= = = = = = = = = = = = = = = =

Answer # 5

  It depends on app and layout of app. We can make app without ever using fragment but by using fragment we can make app more user friendly and efficient. Latest layout designs of applications force developers to use fragments.

= = = = = = = = = = = = = = = =

Answer # 6

  -	On doInBackground method we can’t assess UI components. We can access UI components by running code in UI thread, runOnUiThread(). 
  -	Cancel the AsyncTask run when the user cancels the operation. We can handle this by using onCancelled() overrided method.

