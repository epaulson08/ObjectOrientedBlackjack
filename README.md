## Object-Oriented Blackjack

### Description
This is a command-line blackjack game written in Java in order to practice object-oritented programming principles.

### How to Run
Run BlackjackApplication.java.

### Topics and Technologies Implemented
* Object oriented programming: abstract classes, polymorphism, inheritance, encapsulation
* Basic control flow logic
* Java enumerations
* ASCII art creation using a for-each loops

### Lessons Learned
* A model of a deck of cards can be created conveniently by using enumerations for Suit and Rank, and then implementing a nested for-each loop to create all possible cards of unique suit/rank combinations. The enumerations are also helpful when associating a numeric value to be used for each rank in the Blackjack sum calculations. Finally, a field for the unicode symbol for each suit can be added to the enumeration and then used to generate an ASCII-art depiction of each card.

* Abstraction: Classes for Deck and Card, and abstract classes for Dealer, Hand, and Player were created within a Cards package. Since Dealer, Hand, and Player are abstract, a more specific subclass implementation needs to be created for BlackjackDealer, BlackjackHand, and BlackjackPlayer. Abstraction allows for future re-use of the same classes in any card game application (e.g., one could create a `HeartsHand` and `HeartsDealer` extending the respective `Hand` and `Dealer` abstract classes). 

* Inheritance: an example is the `BlackjackDealer` class extending the abstract `Dealer` class, allowing `BlackjackDealer` to inherit behavior common to `Dealer`s in all card games.

* Polymorphism: a `BlackjackDealer` implements additional behavior unique to blackjack, via additional method implementations or via overriding inherited methods.

* Encapsulation: all fields are private and must be accessed via getter and setter methods. The only way for an object's state to change is by applying methods to the object. Each object is a "black box" that fulfills a contract of expected behavior. The user of the object does not need to know about the specific implementation.