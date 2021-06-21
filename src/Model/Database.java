package Model;

import javafx.scene.control.PasswordField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {
    private static Database instance = null;

    static
    {
        instance = new Database();
    }

    public static Database getInstance()
    {
        return instance;
    }

    private Database() {
        loadUsers();
    }

    List<User> users = new ArrayList<User>();

    private void loadUsers()
    {
        try
        {
            String[] args;
            String line;
            User user;

            File file = new File("users.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            line = br.readLine();

            while (line != null)
            {
                args = line.split(",");

                user = new User(args[0], args[1], args[2], args[3]);
                users.add(user);

                line = br.readLine();
            }
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    public void writeDatabasetoDisk()
    {
        try
        {
            File file = new File("users.txt");
            FileWriter fw = new FileWriter(file, false);

            for (User user : users)
            {
                fw.append(user.toString());
            }

            fw.close();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    public boolean addUser(User o)
    {
        if (users.contains(o))
        {
            return false;
        }
        return users.add(o);
    }

    public boolean userExists(String username)
    {
        for (User user : users)
        {
            if (user.getUsername().equals(username))
            {
                return true;
            }
        }
        return false;
    }

    public Optional<User> verifyUser(String username, String password)
    {
        return users.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst();
    }

    public List<User> getUsers() {
        return users;
    }
}
