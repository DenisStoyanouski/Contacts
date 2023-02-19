package contacts;

import java.io.*;

public class SerializationUtils {
    /**
     * Serialize the given object and save it to given file
     */
    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        /*use writeObject and readObject methods to serialize and deserialize any objects;*/
        oos.writeObject(obj);
        oos.close();
    }

    /**
     * Deserialize to Object from given file
     */
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        /*use writeObject and readObject methods to serialize and deserialize any objects;*/
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    /**
     * FileOutputStream and FileInputStream are used for working with a file;
     * BufferedInputStream and BufferedOutputStream are optional but useful for speeding up the I/O operations;
     * ObjectOutputStream and ObjectInputStream perform serialization and deserialization of objects and also
     invoke wrapped streams to work with the file;
     * both methods also close the streams to avoid resource leaks.*/
}

