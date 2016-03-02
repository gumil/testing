# Test App Using Clean Architecture

**Clean architecture** is divided into layers. The inner layers should not know anything about the outer layers. It has a dependency rule that dependencies should only point **inwards**.

<img src="https://blog.8thlight.com/assets/posts/2012-08-13-the-clean-architecture/CleanArchitecture-81565aba46f035911a5018e77a0f2d4e.jpg" />

By doing this, it makes our code:
* Independent of Frameworks
* Testable.
* Independent of UI.
* Independent of Database.
* Independent of any external agency.

Clean architecture also adheres to the SOLID principle:
* **S - Single Responsibility Principle.** A class should have one, and only one, reason to change.
* **O - Open Closed Principle.** You should be able to extend a classes behavior, without modifying it. 
* **L - Liskov Substitution Principle.** Derived classes must be substitutable for their base classes.
* **I - Interface Segregation Principle.** Make fine grained interfaces that are client specific.
* **D - Dependency Inversion Principle.** Depend on abstractions, not on concretions.

For Android apps, it’s easy to get lost in development. It only takes a while until our code is no longer readable. With this architecture we are making our apps maintainable and scalable.

Further Reading on Clean Architecture:
https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html

**Model-View-Presenter** is an architectural pattern to separate our UI and UI logic. This really works well with Android since the controls is too dependent on UI so there is a need to separate them. Since it’s also tempting to put everything in our activity we need to push the controls to the presenter.

* **Model** is the interface to display or a control that links our view and presenter.
* **View** is out UI, all of our Android objects stays here.
* **Presenter** prepares the business logic to be shown in our view.

####Libraries
#####Retrofit
Retrofit is a typesafe HTTP client for Android. It takes care of consuming APIs and parses ready to be used as models for our architecture. Good thing is that it supports **observables** which we can use together with **RxJava**.

Retrofit is great by the fact that it saves us time in parsing **JSON**. We only need to create an interface and Retrofit takes care of it all. Retrofit uses **Gson** to parse JSON into POJOs.

Further Reading on Retrofit:
http://square.github.io/retrofit/

#####RxJava
RxJava  a library for composing asynchronous and event-based programs by using observable sequences. This prevents us from using asynctasks and having callback hells. With RxJava we can play with observables through **operators** and return objects that is ready for our app to use. 

* Operators are used to transform our data from our entity layer to objects ready to use by our **Interactors** to be passed to our **Presenters**. I’ve mentioned that Retrofit can return observables. RxJava takes care of this observables to subscribe onto our presenters.*

Also, **RxAndroid**, to take care of Android lifecycles while using RxJava.

Further Reading on RxJava:
https://github.com/ReactiveX/RxJava

#####Dagger 2
Before going into the next library, we need to understand the **Dependency Inversion** I’ve mentioned earlier.

Dependency Inversion refers to a specific form of decoupling software modules. Our classes should have interfaces independent on the implementations and classes should use these interfaces instead of the implementations.

To further increase the modularity and of our app we use **Inversion of Control** - describes a design in which custom-written portions of a computer program receive the flow of control from a generic, reusable library. This also further strengthens our dependency inversion since we only have to use our abstractions and let **dependency injection** do the instantiation for us. This way we avoid the `new` operator, removing dependencies.

**Dependency injection** is a software design pattern that implements inversion of control for resolving dependencies. A dependency is an object that can be used (a service). An injection is the passing of a dependency to a dependent object (a client) that would use it. The service is made part of the client's state. Passing the service to the client, rather than allowing a client to build or find the service, is the fundamental requirement of the pattern.

**Dagger** is a fully static, compile-time dependency injection framework for both Java and Android. It’s the library that I use to implement the concepts above. Honestly, dagger has a very steep learning curve. I needed to understand the concepts to understand and know how to use the library. In dagger, we have modules where we instantiate needed classes to expose in our dependency graph. Good thing, dagger uses annotations and it generates our graph at compile time.

Dagger has also custom scoping which work well with our Android lifecycle. We could make instances like singletons and instantiate them in a module that is injected in our Application class. This way, we avoid singletons and to avoid unnecessary dependencies caused by regular singletons.

Further Reading on Dagger:
http://google.github.io/dagger/

#####Conclusion
Using these concepts and libraries changed the way I look at Android and changed the way I look and create my code. It’s an eye opener that bad code really destroys everything. Coupled classes makes it hard to maintain.

This project even though it’s simple as it is, it grasps the concept of everything I’ve mentioned here. I might be wrong in some. But this is my take on the Clean Architecture.

Let’s build better apps. :)

References:

http://fernandocejas.com/2015/07/18/architecting-android-the-evolution/
http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
