package api;

import app.Main;
import entity.Project;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MongoTodoDB implements TodoDB {
    private static final String API_URL = "https://api.todoist.com/rest/v2/projects/";
    public static String getApiToken() {
        return "Bearer " + Main.API_TOKEN;
    }

    @Override
    public Project getProject(String projectID) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.todoist.com/rest/v2/projects/%s", projectID))
                .addHeader("Authorization", getApiToken())
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            if(response.code()==200){
                JSONObject responseBody = new JSONObject(response.body().string());
                return Project.builder()
                        .projectID(responseBody.getString("id"))
                        .projectName(responseBody.getString("name"))
                        .build();
            } else {
                throw new RuntimeException("error");
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
