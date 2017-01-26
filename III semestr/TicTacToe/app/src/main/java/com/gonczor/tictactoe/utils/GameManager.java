package com.gonczor.tictactoe.utils;

import android.widget.Button;

import java.util.Random;


public class GameManager {
    private boolean player1active;
    private boolean player2active;
    private boolean isMultiplayer;
    private boolean playerOneWon;
    private boolean playerTwoWon;
    private boolean isDraw;
    private int size;
    private Button[][] buttonGrid;
    private Button[] winningButtonStreak;

    public GameManager(int size, Boolean isMultiplayer, Button[][] buttonGrid){
        this.size = size;
        this.buttonGrid = buttonGrid;
        this.player1active = true;
        this.player2active = false;
        this.isDraw = false;
        this.playerOneWon = false;
        this.playerTwoWon = false;
        this.isMultiplayer = isMultiplayer;
    }

    public boolean makeMove(Button buttonClicked){
        buttonClicked.setText(getMarker());
        this.checkWinner();
        this.togglePlayer();
        if(!isMultiplayer  && !gameOver()){
            makeComputerMove();
            this.checkWinner();
            this.togglePlayer();
        }
        return gameOver();
    }

    private void togglePlayer(){
        player1active = !player1active;
        player2active = !player2active;
    }

    private String getMarker(){
        if (player1active)
            return "X";
        else
            return "O";
    }

    private String clearMarker(){
        return "";
    }

    private void makeComputerMove(){
        if(!setMarkerIfCanWinInCurrentMove()){
            Random r = new Random();
            int i, j;
            do{
                i = r.nextInt(size);
                j = r.nextInt(size);
            }while(!buttonGrid[i][j].getText().equals(""));

            buttonGrid[i][j].setText(getMarker());
        }
    }

    private boolean setMarkerIfCanWinInCurrentMove(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(buttonGrid[i][j].getText().equals("")) {
                    buttonGrid[i][j].setText(getMarker());
                    if(hitHorizontally())
                        return true;

                    if(hitVertically())
                        return true;

                    if(hitRightDown())
                        return true;

                    if(hitLeftDown())
                        return true;

                    buttonGrid[i][j].setText(clearMarker());
                }
            }
        }
        return false;
    }

    /**
     * @return true if any end condition met: one of the players has won or board is full
     */
    private boolean gameOver(){
        return playerOneWon || playerTwoWon || isDraw;
    }

    private void checkWinner(){
        if(hitHorizontally())
            return;

        if(hitVertically())
            return;

        if(hitRightDown())
            return;

        if(hitLeftDown())
            return;

        hitDraw();
    }

    private boolean hitHorizontally(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size-2; j++){
                if(checkStreak(buttonGrid[i][j], buttonGrid[i][j+1], buttonGrid[i][j+2])){
                    if(buttonGrid[i][j].getText().equals("X"))
                        playerOneWon = true;
                    else if(buttonGrid[i][j].getText().equals("O"))
                        playerTwoWon = true;
                    Button[] buttons = {buttonGrid[i][j], buttonGrid[i][j+1], buttonGrid[i][j+2]};
                    setWinningButtonStreak(buttons);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hitVertically(){
        for(int i = 0; i < size-2; i++){
            for(int j = 0; j < size; j++){
                if(checkStreak(buttonGrid[i][j], buttonGrid[i+1][j], buttonGrid[i+2][j])){
                    if(buttonGrid[i][j].getText().equals("X"))
                        playerOneWon = true;
                    else if(buttonGrid[i][j].getText().equals("O"))
                        playerTwoWon = true;
                    Button[] buttons = {buttonGrid[i][j], buttonGrid[i+1][j], buttonGrid[i+2][j]};
                    setWinningButtonStreak(buttons);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hitRightDown(){
        for(int i = 0; i < size-2; i++){
            for(int j = 0; j < size-2; j++){
                if(checkStreak(buttonGrid[i][j], buttonGrid[i+1][j+1], buttonGrid[i+2][j+2])){
                    if(buttonGrid[i][j].getText().equals("X"))
                        playerOneWon = true;
                    else if(buttonGrid[i][j].getText().equals("O"))
                        playerTwoWon = true;
                    Button[] buttons = {buttonGrid[i][j], buttonGrid[i+1][j+1], buttonGrid[i+2][j+2]};
                    setWinningButtonStreak(buttons);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hitLeftDown(){
        for(int i = 0; i < size-2; i++){
            for(int j = 2; j < size; j++){
                if(checkStreak(buttonGrid[i][j], buttonGrid[i+1][j-1], buttonGrid[i+2][j-2])){
                    if(buttonGrid[i][j].getText().equals("X"))
                        playerOneWon = true;
                    else if(buttonGrid[i][j].getText().equals("O"))
                        playerTwoWon = true;
                    Button[] buttons = {buttonGrid[i][j], buttonGrid[i+1][j-1], buttonGrid[i+2][j-2]};
                    setWinningButtonStreak(buttons);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkStreak(Button b1, Button b2, Button b3){
        return b1.getText().equals(b2.getText()) &&
                b1.getText().equals(b3.getText()) &&
                !b1.getText().equals("");
    }

    private void hitDraw(){
        boolean hasEmptyField = false;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(buttonGrid[i][j].getText().equals(""))
                    hasEmptyField = true;
            }
        }

        if(!hasEmptyField)
            isDraw = true;
    }

    private void setWinningButtonStreak(Button[] buttons){
        winningButtonStreak = buttons;
    }

    public Button[] getWinningButtonStreak(){
        return winningButtonStreak;
    }
}
