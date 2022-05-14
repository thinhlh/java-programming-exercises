package src;

import src.helper.DBConnection;
import src.presentation.Menu;

class Main {
    public static void main(String[] args) {

        DBConnection.init(args[0], args[1], args[2]);
        new Menu();
        DBConnection.getInstance().closeConnection();
    }
}
