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

		System.out.println("\nYou Are Now Playing:\n");
		System.out.println("\tBLACKJACK\n");

		System.out.println("The dealer has been given two cards\n");
		System.out.print("Your cards are: ");
		pHand.displayHand();
		System.out.println("\nYour card total is: " + pHand.getHandValue());

		do {
			if (player.checkRules(pHand) == true) {
				break;
			}
			System.out.println("\n1 = Hit\t 2 = Stay");
			try {
				selection = input.nextInt();
				if (selection >= 3) {
					System.out.println("Your selection must be 1 or 2");
				}
				if (selection == 2) {
					pHand = player.stay(pHand);
					chooseWinner(pHand, dHand);
					if (player.checkRules(pHand) == true) {
						break;
					}
					break;
				}
				if (selection == 1) {
					pHand = app.hitHand(pHand);
					// player.hit(pHand);
					System.out.print("Your cards are: ");
					pHand.displayHand();
					System.out.println("\nYour card total is: " + pHand.getHandValue());
					if (player.checkRules(pHand) == true) {
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Your selection must be 1 or 2");
			}
		} while (player.checkRules(pHand) == false && dHand.getHandValue() < 21);
		playAgain(input);
	}

	public BlackjackHand hitHand(BlackjackHand pHand) {
		player.hit(pHand);
		return pHand;
	}

	public void chooseWinner(BlackjackHand pHand, BlackjackHand dHand) {
		//dHand = dealer.play(dHand);
		player.checkRules(pHand);
		int playerHandTotal = pHand.getHandValue();
		int dealerHandTotal = dealer.play(dHand);
		
		if (pHand.getHandValue() > dealerHandTotal && playerHandTotal < 21 && dealerHandTotal < 21) {
			System.out.println("Congrats, you're closer to 21!\nYou win Blackjack!");
		} if (pHand.getHandValue() < dealerHandTotal && playerHandTotal < 21 && dealerHandTotal < 21) {
			System.out.println("Unfortunatly, the dealer won this round with a total of " + dHand.getHandValue());
		} if (pHand.getHandValue() == dealerHandTotal && playerHandTotal < 21 && dealerHandTotal < 21) {
			System.out.println("You and the Dealer have the same total value\nGame Tied");
		}
	}

	public void playAgain(Scanner input) {
		BlackjackApp app = new BlackjackApp();

		System.out.println("\nWould you like to play again? ");
		System.out.print("Yes/Y\tNo/N ");
		String selection = input.next();
		if (selection.equalsIgnoreCase("Yes") || selection.equalsIgnoreCase("Y")) {
			app.run(input);
		} else if (selection.equalsIgnoreCase("No") || selection.equalsIgnoreCase("N")) {
			System.out.println("\nThanks for playing BLACKJACK!\n");
		}
	}
}
