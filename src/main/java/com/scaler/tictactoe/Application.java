package com.scaler.tictactoe;

import com.scaler.tictactoe.controllers.GameController;
import com.scaler.tictactoe.factories.player.PlayerFactory;
import com.scaler.tictactoe.models.*;
import com.scaler.tictactoe.strategies.botplayingstrategies.RandomBotPlayingStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategies.GameWinningStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategies.OrderOneGameWinningStrategy;

import java.util.List;

public class Application {
    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        Player humanPlayer = PlayerFactory.getHuman(new Symbol('X'), new User());
        Player botPlayer = PlayerFactory.getBot(new Symbol('0'), new RandomBotPlayingStrategy());
        List<Player> players1 = List.of( humanPlayer, botPlayer );

        List<GameWinningStrategy> gameWinningStrategies1 = List.of(
                new OrderOneGameWinningStrategy(players1.size())
        );

        Game game1 = gameController.createGame(3, players1, gameWinningStrategies1);

        gameController.makeMove(game1, new Move(0,0, humanPlayer ));
        gameController.makeMove(game1, new Move(1,3, humanPlayer));

        // g2 move 1 2 X


    }

    // Board withBoard(BoardFactory.getBoardWithDimensions(n))
    // Builder - Board.create().withDimension(n).build()
    // Board.getBoardOfDimension(n)
    // new Board(dimension)
}

// BotFactory.getBotForStrategy(RANDOM).setSymbol(symbol).build()
// PlayerFactory.createBot(Symbol, Strategy)
// PlayerFactory.createHuman(Sumbol, User)

// controllers
// GameController
//   - createGame
//   - makeMove(Game, Move)
//   - checkState(Game)

// Actions over a game:
// Start a game
// Make a move
// Undo
// CheckWinner
// GetCurrentState