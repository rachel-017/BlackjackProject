package com.skilldistillery.cards.blackjack;

public class BlackjackDealer extends BlackjackPlayer{
	
	public BlackjackDealer() {
	}
	private String victoryShout;
	
	
	public BlackjackHand play(BlackjackHand hand) {
		BlackjackDealer dealer = new BlackjackDealer();
		if(hand.getHandValue()<17) {
			do {
				hand = dealer.hit(hand);
			}while(hand.getHandValue()<17);
		}
		if(hand.getHandValue()>=17 && hand.getHandValue()< 21) {
			hand = dealer.stay(hand);
		}
		if(hand.getHandValue()==21) {
			System.out.println(declareVictory());
		}
		if(hand.getHandValue()>21) {
			System.out.println("The dealer has bust! You win!");
		}
		return hand;
	}
	public String declareVictory() {
		victoryShout = "I, the Blackjack Dealer, am victorious!"
				+ "\nThe Dealer won with a score of 21!";
		return victoryShout;
	}

}
