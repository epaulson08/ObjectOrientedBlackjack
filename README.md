## Blackjack Project

### Description
This application simulates a blackjack game within a terminal emulator, modeling a deck of cards, a dealer, and a player. If either the dealer's or player's cards add to > 21, they lose. If the cards add to exactly 21, they win. After the initial hand, the player can choose to hit or stay as many times as they like. Then, the dealer responds by hitting on any hand totaling < 17, until a win or loss state is achieved. Finally, the player can choose whether to play another round.

### How to Run
Run BlackjackApplication.java.

### Topics and Technologies Implemented
* Object oriented programming: encapsulation, abstract classes, subclasses, polymorphism
* Java enumerations
* Debugging mode using a boolean flag and System.out.println()
* ASCII art creation using a for-each loops

### Lessons Learned
* A model of a deck of cards can be created conveniently by using enumerations for Suit and Rank, and then implementing a nested for-each loop to create all possible cards of unique suit/rank combinations. The enumerations are also helpful when associating a numeric value to be used for each rank in the Blackjack sum calculations. Finally, a field for the unicode symbol for each suit can be added to the enumeration and then used to generate an ASCII-art depiction of each card.

* A debugging mode is helpful when working through the game win-state logic. A boolean "debug" field can be added to a class and set to true or false. Then, all debugging statements can be printed from within an `if( (debug) {}` block. This could have also been done from the Eclipse debugging feature, without using command-line printouts.

* Classes for Deck and Card, and abstract for Dealer, Hand, and Player were created within a Cards package. This allows for future re-use of the same classes in any card game application. Since Dealer, Hand, and Player are abstract, a more specific subclass implementation needs to be created for BlackjackDealer, BlackjackHand, and BlackjackPlayer. These subclasses can access the fields they inherit from their abstract superclass through getter/setter methods, or by giving the superclass the access modifier `protected`. The specific Blackjack implementations then add extra functionality that is specific to Blackjack rather than all card games.
