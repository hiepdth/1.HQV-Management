package BackEnd;

public class Currency extends Production {
    protected String name;

    public Currency(){
        name = null;
        setPath(null);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
