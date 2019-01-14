package BackEnd;

import java.util.ArrayList;

public abstract class Production {
    private String path;
    private String name;
    public abstract String readDatabase();
    public abstract void updateProduction();


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
