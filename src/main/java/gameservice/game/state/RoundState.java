package gameservice.game.state;

/**
 * Enum representing the states that rounds can be in during a game of Texas Hold'em
 * 
 * @author ianH92
 */
public enum RoundState {
	PRE_FLOP_NO_BETS_STATE,
	PRE_FLOP_BETTING_STATE,
	FLOP_NO_BETS_STATE,
	FLOP_BETTING_STATE,
	TURN_NO_BETS_STATE,
	TURN_BETTING_STATE,
	RIVER_NO_BETS_STATE,
	RIVER_BETTING_STATE,
	ROUND_ENDS_STATE,
	GAME_ENDS_STATE
}
