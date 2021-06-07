# Blackjack Project

## Overview
This project is designed to simulate a game of Blackjack between one player and a dealer.

## Usage
The BlackjackApp class is used to play the game. When the app is run, it deals two cards to the dealer and two cards to the player. The player's cards are displayed, while the dealers cards are kept secret. Next, the player must decide whether to "hit" their hand or "stay" by selecting 1 or 2 respectively. If they select 1, a card will be added to their hand, and they will have the choice to select hit or stay again. Once stay is selected the total values of both the player's and the dealer's hand are compared. Whichever hand's total is closer to 21 is declared winner. Unless, a hand's total value equals 21, then the game is over and that player is declared winner. Additionally, if either player's hand value goes over 21, the game is over and the opposite player wins the game.

## Technologies Used
* Java
* Enums
* Object-Oriented Design
* Abstracts
* While Loops

## Lessons Learned
I learned the importance of using a detailed UML diagram to plan out my Object-Oriented design. When I first designed the layout of my project, I didn't go into detail about which class would do which method. Because of this, I ended up creating classes and methods that I didn't end up using once the project was complete. It also made it tougher for me to decide which classes should do which methods, and made it harder to keep track of my pass-by-values. Next time I will spend more time designing the project in the beginning. And by doing so, creating the project will go smoother and be more organized overall.
