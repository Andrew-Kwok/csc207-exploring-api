package app;

import api.TodoDB;
import api.MongoTodoDB;
import entity.Project;
import use_case.*;

public class Main {
    public static final String API_TOKEN = "8c47054a630e68f180ea9a3c2d87436c4850d4c5";

    public static void main(String[] args) {
        Config config = new Config();
        GetProjectUseCase demoCase = config.getProjectUseCase();

        // all the project IDs
        String[] defaultProjects = {
                "2320965992",
                "2320965999",
                "2320966000"
        };

        // make GET request to API to retrieve the project information
        // save them as Project objects and print them out
        for(String projectID: defaultProjects){
            Project project =demoCase.getProject(projectID);
            System.out.println(project);
        }

    }
}
