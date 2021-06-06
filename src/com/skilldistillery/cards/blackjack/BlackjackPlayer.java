package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public abstract class BlackjackPlayer {
	private Deck deck = new Deck();
	private BlackjackHand hand = new BlackjackHand();
	
	public BlackjackHand hit(BlackjackHand hand) {
		deck.shuffle();
		Card card = deck.dealCard();
		hand.addCard(card);
		return hand;
	}
	public BlackjackHand stay(BlackjackHand hand) {
		hand = this.hand;
		return hand;
	}

}
