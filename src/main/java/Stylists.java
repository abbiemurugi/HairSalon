import java.util.List;
import org.sql2o.*;

public class Stylists {
    private String fname;
    private String middlename;
    private String lname;
    private String Email;
    private String Age;
    private String Address;
    private int id;

    public Stylists (String fname, String middlename, String lname , String Email, String Age, String Address ) {
        this.fname = fname;
        this.middlename = middlename;
        this.lname = lname;
        this.Email = Email;
        this.Age = Age;
        this.Address = Address;
    }

    public static List<Stylists> all() {
        String sql = "SELECT id, description FROM Stylists";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Stylists.class);
        }
    }

    public String getFName() {
        return fname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public String getLname() {
        return lname;
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

    public static Stylists find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM stylists where id=:id";
            Stylists Stylists = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Stylists.class);
            return Stylists;
        }
    }

    @Override
    public boolean equals(Object otherStylists) {
        if (!(otherStylists instanceof Stylists)) {
            return false;
        } else {
            Stylists newStylists = (Stylists) otherStylists;
            return this.getFName().equals(newStylists.getFName()) &&
            this.getMiddleName().equals(newStylists.getMiddleName()) &&
            this.getLname().equals(newStylists.getLname()) &&
            this.getEmail().equals(newStylists.getEmail()) &&
            this.getAge().equals(newStylists.getAge()) &&
            this.getAddress().equals(newStylists.getAddress()) &&

            this.getId() == newStylists.getId();
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO Stylists (fname, middlename, lname, Email, Age, Address ) VALUES (:fname, :middlename, :lname, :Email, :Age, :Address)";
            this.id = (int) con.createQuery(sql,true)

                    .addParameter("fname", this.fname)
                    .addParameter("middlename", this.middlename)
                    .addParameter("lname", this.lname)
                    .addParameter("Email", this.Email)
                    .addParameter("Age", this.Age)
                    .addParameter("Address", this.Address)
                    .executeUpdate()
                    .getKey();
        }
    }

}
