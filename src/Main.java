import task.ProtectedSingleton;
import task.Singleton;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static utils.Utils.deserializeSingleton;
import static utils.Utils.serializeSingleton;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {
        Singleton singleton = Singleton.getSingleton();
        List<Singleton> listOfDifferentSingletons = new ArrayList<>();

        singleton.setValue(1);

        System.out.println("Create collection with different Singletons");
        System.out.println("### Using serializable interface");
        try {
            serializeSingleton(singleton);

            singleton.setValue(2);

            Singleton singletonCopy = deserializeSingleton(singleton);

            if (singleton == singletonCopy) {
                System.out.println("Objects are the same");
            } else {
                System.out.println("Object different");
            }

            System.out.println(singleton.getValue());
            System.out.println(singletonCopy.getValue());

            for (int i = 0; i < 5; i++) {
                listOfDifferentSingletons.add(i, deserializeSingleton(singleton));
            }

            System.out.println(listOfDifferentSingletons);

            System.out.println(listOfDifferentSingletons.get(0) == listOfDifferentSingletons.get(1));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("### Using reflection");

        Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);

        Singleton singletonReflection = (Singleton) constructor.newInstance();

        singletonReflection.setValue(3);

        if (singleton == singletonReflection) {
            System.out.println("Objects are the same");
        } else {
            System.out.println("Object different");
        }

        listOfDifferentSingletons.add(singletonReflection);

        System.out.println("### Using cloning");

        Singleton singletonClone = (Singleton) singleton.clone();
        System.out.println("singletons hashCode:- "
                + singleton.hashCode());
        System.out.println("singletonClone hashCode:- "
                + singletonClone.hashCode());

        listOfDifferentSingletons.add(singletonClone);

        boolean allEquals = listOfDifferentSingletons.isEmpty() ||
                listOfDifferentSingletons.stream().allMatch(listOfDifferentSingletons.get(0)::equals);
        // listOfDifferentSingletons.stream().distinct().limit(2).count() <= 1
        System.out.println("Is all singletons same: " + allEquals);

        System.out.println("----------------------------------------------------");
        System.out.println("Protected singletons");

        ProtectedSingleton protectedSingleton = ProtectedSingleton.getSingleton();
        List<ProtectedSingleton> listOfSameSingletons = new ArrayList<>();

        protectedSingleton.setValue(1);

        System.out.println("Create collection with same Singletons");
        System.out.println("### Using serializable interface");
        try {
            serializeSingleton(protectedSingleton);

            protectedSingleton.setValue(3);

            ProtectedSingleton serializeProtectedSingleton = deserializeSingleton(protectedSingleton);

            if (protectedSingleton == serializeProtectedSingleton) {
                System.out.println("Objects are the same");
            } else {
                System.out.println("Object different");
            }

            System.out.println(protectedSingleton.getValue());
            System.out.println(serializeProtectedSingleton.getValue());

            for (int i = 0; i < 5; i++) {
                listOfSameSingletons.add(i, deserializeSingleton(protectedSingleton));
            }

            System.out.println(listOfSameSingletons);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        boolean allSame = listOfSameSingletons.isEmpty() ||
                listOfSameSingletons.stream().allMatch(listOfSameSingletons.get(0)::equals);

        System.out.println("Is all singletons same: " + allSame);
    }
}
