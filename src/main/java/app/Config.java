package app;

import api.MongoTodoDB;
import api.TodoDB;
import use_case.GetProjectUseCase;

public class Config {
    private final TodoDB todoDB = new MongoTodoDB();

    public GetProjectUseCase getProjectUseCase(){
        return new GetProjectUseCase(todoDB);
    };
}
