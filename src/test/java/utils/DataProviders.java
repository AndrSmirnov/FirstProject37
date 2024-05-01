package utils;

import org.testng.annotations.DataProvider;
import tests.DemoWebShop.dto.UserDTO;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Bill", "Clinton", "bill@mail.ru", "12345BC$"});
        list.add(new Object[]{"Bill1", "Clinton", "bill1@mail.ru", "12345BC$"});
        list.add(new Object[]{"Bill2", "Clinton", "bill2@mail.ru", "12345BC$"});
        list.add(new Object[]{"Bill3", "Clinton", "bill3@mail.ru", "12345BC$"});
        list.add(new Object[]{"Bill4", "Clinton", "bill4@mail.ru", "12345BC$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactCSVFile() {
        List<Object[]> list = new ArrayList<>();
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("src/test/resources/contacts.csv")));
            line = reader.readLine();

            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{new UserDTO().setFirstName(split[0]).setLastName(split[1])
                        .setEmail(split[2]).setPassword(split[3])});
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}