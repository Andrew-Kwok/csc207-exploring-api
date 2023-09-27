package app;

import api.TodoDB;
import api.MongoTodoDB;
import use_case.*;

public class Main {
    public static final String API_TOKEN = "8c47054a630e68f180ea9a3c2d87436c4850d4c5";

    public static void main(String[] args) {
        final TodoDB todoDB = new MongoTodoDB();
        GetProjectUseCase demoCase1 = new GetProjectUseCase(todoDB);


    }
}
