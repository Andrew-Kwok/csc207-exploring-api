package api;

import entity.Project;

public interface TodoDB {
    Project getProject(String ProjectID);
}
