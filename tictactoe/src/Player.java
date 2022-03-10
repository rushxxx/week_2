import java.util.Scanner;

public class Player {
    private String name;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void move (){
        int col;
        int row;

        System.out.println(name + " ваш ход (1 цифра - номер строки, 2 цифра - номер столбца, через пробел)");
        Scanner sc = new Scanner(System.in);

        while (true){
            row = sc.nextInt();
            col = sc.nextInt();
            if (row >= 0 && row <= 3 && col >= 0 && col <= 3 && Game.getField()[row - 1][col - 1] == "-"){
                Game.setField(row - 1, col - 1, status);
                break;
            }else System.out.println("ошибка, попробуйте заново");
        }
    }
}
