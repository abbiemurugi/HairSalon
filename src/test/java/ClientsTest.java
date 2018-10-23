import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientsTest {

    @Before
    public void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", kingcubby, murugi254A);
    }

    @After
    public void tearDown() {
        try (Connection con = DB.sql2o.open()) {
            String deleteStylistsQuery = "DELETE FROM Stylists *;";
            String deleteClientsQuery = "DELETE FROM Clients *;";
            con.createQuery(deleteStylistsQuery).executeUpdate();
            con.createQuery(deleteClientsQuery).executeUpdate();
        }
    }
}