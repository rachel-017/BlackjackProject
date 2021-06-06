package com.skilldistillery.cards.blackjack;

public class BlackjackGuest extends BlackjackPlayer {

	public BlackjackGuest() {

	}

	public boolean checkRules(BlackjackHand hand) {
		if (hand.getHandValue() > 21) {
			System.out.println("You've bust! The dealer wins.");
			return true;
		}
		if (hand.getHandValue() == 21) {
			System.out.println("Blackjack! You win!");
			return true;
		} else {
			return false;
		}
	}
}
