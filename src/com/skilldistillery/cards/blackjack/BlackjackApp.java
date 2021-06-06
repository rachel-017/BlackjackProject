package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	private Deck deck = new Deck();
	private BlackjackGuest player = new BlackjackGuest();
	private BlackjackDealer dealer = new BlackjackDealer();

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		Scanner input = new Scanner(System.in);
		app.run(input);
		input.close();

	}

	public void run(Scanner input) {
		BlackjackApp app = new BlackjackApp();
		int selection = 0;
		deck.shuffle();
		BlackjackHand pHand = new BlackjackHand();
		BlackjackHand dHand = new BlackjackHand();

		Card aCard = deck.dealCard();
		pHand.addCard(aCard);
		Card bcard = deck.dealCard();
		dHand.addCard(bcard);
		Card cCard = deck.dealCard();
		pHand.addCard(cCard);
		Card dCard = deck.dealCard();
		dHand.addCard(dCard);

		System.out.println("You Are Now Playing:\n");
		System.out.println("\tBLACKJACK\n");

		System.out.println("The dealer has been given two cards\n");
		System.out.print("Your cards are: ");
		pHand.displayHand();
		System.out.println("\nYour card total is: " + pHand.getHandValue());

		do {
			System.out.println("\n1 = Hit\t 2 = Stay");
			try {
				selection = input.nextInt();
				if (selection >= 3) {
					System.out.println("Your selection must be 1 or 2");
				}
				if (selection == 2) {
					pHand = player.stay(pHand);
					chooseWinner(pHand, dHand);
					break;
				}
				if (selection == 1) {
					pHand = app.hitHand(pHand);
					// player.hit(pHand);
					System.out.print("Your cards are: ");
					pHand.displayHand();
					System.out.println("\nYour card total is: " + pHand.getHandValue());
					if (player.checkRules(pHand) == true) {
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Your selection must be 1 or 2");
			}
		} while (player.checkRules(pHand) == false && dHand.getHandValue()<21);

	}

	public BlackjackHand hitHand(BlackjackHand pHand) {
		player.hit(pHand);
		return pHand;
	}


	public void chooseWinner(BlackjackHand pHand, BlackjackHand dHand) {
		player.checkRules(pHand);
		dHand = dealer.play(dHand);
		int playerHandTotal = pHand.getHandValue();
		int dealerHandTotal = dHand.getHandValue();
		if (playerHandTotal > dealerHandTotal) {
			System.out.println("Congrats, you're closer to 21!\nYou win Blackjack!");
		} else if (playerHandTotal > dealerHandTotal) {
			System.out.println("Unfortunatly, the dealer won this round with a total of " + dHand.getHandValue());
		}
		else if(playerHandTotal == dealerHandTotal) {
			System.out.println("You and the Dealer have the same total value\nGame Tied");
		}
	}
}
