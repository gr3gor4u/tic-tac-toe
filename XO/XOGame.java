package XO;

import java.util.Scanner;

public class XOGame {
    Field gameField;
    Scanner scanner=new Scanner(System.in);
    char whoMakeNextTurn;
    boolean gameOver=false;
    void SetupNewGame(){
        System.out.println("Will play new game XO");
        this.gameField=new Field();
        this.gameField.initField();
    }
    void play(){
        this.SetupNewGame();
        System.out.println("who first make turn?");
        char first=this.scanner.next().charAt(0);
        if(first=='X'||first=='O'){
            this.whoMakeNextTurn=first;
        }else {
            System.out.println("isnt X or O go move another guy");
            this.whoMakeNextTurn='X';
        }
        while(!gameOver){
            turn();
            this.gameOver=this.gameField.isGameOver(whoMakeNextTurn);
            if(this.gameOver){
                System.out.println(this.whoMakeNextTurn+" winner");
            }
            if(this.whoMakeNextTurn=='X'){
                this.whoMakeNextTurn='O';
            }else{
                this.whoMakeNextTurn='X';
            }
        }
        System.out.println("game over");
    }
    void turn(){
        System.out.println(this.whoMakeNextTurn+", your turn");
        System.out.print("chose row");
        int rowNumber=this.scanner.nextInt();
        System.out.print("chose col ");
        int colNumber=this.scanner.nextInt();
        int rowIndex=rowNumber-1;
        int colIndex=colNumber-1;
        if(this.gameField.isPlaceFree(rowIndex,colIndex)){
            this.gameField.setValue(rowIndex,colIndex,whoMakeNextTurn);
            this.gameField.printField();
        }else{
            System.out.println("wrong number(this place isnt free, make ur turn again)");
            turn();
        }
    }
}
