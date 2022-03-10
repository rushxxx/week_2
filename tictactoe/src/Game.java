public class Game {
    private static final String [][] field = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
    private String playerTurn = "X";

    public static String[][] getField() {
        return field;
    }
    public static void setField(int row, int col, String status) {
        field[row][col] = status;
    }

    public String getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Выводит на экран поле с текущим расположением крестиков и ноликов
     */
    public void showField() {
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (col == 1) System.out.print("|");
                System.out.print(field[row][col]);
                if (col == 1) System.out.print("|");
            }
            System.out.println("");
        }
    }

    /**
     * Проверка победы
     * @param symb символ который необходимо проверить
     * @return в случае победы, возвращает true
     */
    public boolean winCheck (String symb){
        boolean cols;
        boolean rows;
        boolean diagonal1 = true;
        boolean diagonal2 = true;

        // проверка диагоналей
        for (int i = 0; i < 3; i++) {
            diagonal1 &= (field[i][i] == symb);
            diagonal2 &= (field[3-i-1][i] == symb);
        }
        if (diagonal1 || diagonal2) return true;

        // проверка колонок и строк
        for (int col = 0; col < 3; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < 3; row++) {
                cols &= (field[col][row] == symb);
                rows &= (field[row][col] == symb);
            }
            if (cols || rows) return true;
        }
        return false;
    }

    /**
     * Переключает очередь игроков
     * refactor - возможно метод избыточен
     */
    public void playerGetReadyToggle (){
        playerTurn = playerTurn.equals("0") ? "X" : "0";
    }


}
