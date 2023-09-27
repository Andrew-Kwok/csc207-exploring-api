package use_case;

import entity.Project;
import api.TodoDB;

public final class GetProjectUseCase {
    private final TodoDB todoDB;

    public GetProjectUseCase(TodoDB todoDB) {
        this.todoDB = todoDB;
    }
}
