import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Player currentPlayer;
        Player player1 = new Player();
        Player player2 = new Player();

        Scanner sc = new Scanner(System.in);
        System.out.print("Первый игрок, введите свое имя: ");
        player1.setName(sc.nextLine());

        while (true){
            System.out.print("Второй игрок, введите свое имя: ");
            String name = sc.nextLine();
            if (name.equals(player1.getName())){
                System.out.println("Первый игрок уже выбрал это имя, придумайте другое!");
            }else{
                player2.setName(name);
                break;
            }

        }

        // случайный выбор фигур для игроков
        if ((Math.random() * 10) >= 5) {
            player1.setStatus("X");
            player2.setStatus("0");
            System.out.println(player1.getName() + " играет крестиками");
            System.out.println(player2.getName() + " играет ноликами");
        }else {
            player1.setStatus("0");
            player2.setStatus("X");
            System.out.println(player1.getName() + " играет ноликами");
            System.out.println(player2.getName() + " играет крестиками");
        }

        Game game = new Game();

        while (true){
            game.showField();
            if (player1.getStatus() == game.getPlayerTurn()) {
                currentPlayer = player1;
            }else currentPlayer = player2;
            currentPlayer.move();
            if (game.winCheck(game.getPlayerTurn())) {
                game.showField();
                System.out.println(currentPlayer.getName() + " победил!");
                Player looser = currentPlayer.equals(player1) ? player2 : player1;
                Repo.writeWinner(currentPlayer.getName(), looser.getName());
                break;
            }
            game.playerGetReadyToggle();
        }

    }
}
