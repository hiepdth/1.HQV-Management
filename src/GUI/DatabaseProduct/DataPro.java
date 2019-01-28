package GUI.DatabaseProduct;

import java.io.*;
import java.util.HashMap;

public class DataPro {
    protected HashMap<String, Integer> list = new HashMap<>();

    public DataPro(){
        update("src\\Data\\data.txt");
    }

    public void update(String path){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));
            String line;
            while ((line = reader.readLine()) != null){
                String info[] = line.split(":");
                int temp = Integer.parseInt(info[1]);
                list.put(info[0], temp);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> getList() {
        return list;
    }

    public void setList(HashMap<String, Integer> list) {
        this.list = list;
    }
}
