package Application;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public <T> List<T> read(String fileName) {
        List<T> list = new ArrayList<T>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return list;
    }

    public <T> void write(String fileName, List<T> list) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private IOFile() {

    }

    private static IOFile instance;

    public static IOFile getInstance() {
        if (instance == null) {
            instance = new IOFile();
        }
        return instance;
    }

}