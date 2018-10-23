import org.sql2o.Connection;

import java.util.List;
import java.util.ArrayList;

public class Clients {
    private String firstname;
    private String middlename;
    private String lastname;
    private String Email;
    private String Age;
    private String Address;
    private int id;

    public Clients (String firstname, String middlename, String lastname , String Email, String Age, String Address) {
            this.firstname = firstname;
            this.middlename = middlename;
            this.lastname = lastname;
            this.Email = Email;
            this.Age = Age;
            this.Address = Address;
        }

    public static List<Clients> all() {
        String sql = "SELECT id, description FROM Clients";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Clients.class);
        }
    }

    public String getFirstName() {
        return firstname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public String getLastName() {
        return lastname;
    }

    public String getEmail() {
        return Email;
    }

    public String getAge() {
        return Age;
    }

    public String getAddress() {
        return Address;
    }

    public int getId() {
        return id;
    }

    public static Clients find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM Clients where id=:id";
            Clients Clients = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Clients.class);
            return Clients;
        }
    }

    @Override
    public boolean equals(Object otherClients) {
        if (!(otherClients instanceof Clients)) {
            return false;
        } else {
            Clients newClients = (Clients) otherClients;
            return this.getFirstName().equals(newClients.getFirstName()) &&
                    this.getMiddleName().equals(newClients.getMiddleName()) &&
                    this.getLastName().equals(newClients.getLastName()) &&
                    this.getEmail().equals(newClients.getEmail()) &&
                    this.getAge().equals(newClients.getAge()) &&
                    this.getAddress().equals(newClients.getAddress()) &&

                    this.getId() == newClients.getId();
        }
    }



}