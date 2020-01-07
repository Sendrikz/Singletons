package utils;

import task.ProtectedSingleton;
import task.Singleton;

import java.io.*;

public class Utils {

    public static void serializeSingleton(Singleton singleton) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("out1.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        objectOutputStream.writeObject(singleton);
        objectOutputStream.close();
        fileOut.close();
    }

    public static Singleton deserializeSingleton(Singleton singleton) throws IOException, ClassNotFoundException {
        Singleton singleton2 = null;

        FileInputStream fileInputStream = new FileInputStream("out1.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        singleton2 = (Singleton) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        return singleton2;
    }

    public static void serializeSingleton(ProtectedSingleton singleton) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("out2.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        objectOutputStream.writeObject(singleton);
        objectOutputStream.close();
        fileOut.close();
    }

    public static ProtectedSingleton deserializeSingleton(ProtectedSingleton singleton) throws IOException, ClassNotFoundException {
        ProtectedSingleton singleton2 = null;

        FileInputStream fileInputStream = new FileInputStream("out2.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        singleton2 = (ProtectedSingleton) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        return singleton2;
    }
}
