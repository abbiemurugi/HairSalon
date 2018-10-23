import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ClientsTest {

    @Before
    public void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "kingcubby", "murugi254A");
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

    @Test
    public void equals_returnsTrueIfNamesAretheSame() {
        Clients firstClients = new Clients("Jane", "Muthoni", "Mwangi", "janemuthoni@gmail.com", "40", "Nairobi");
        Clients secondClients = new Clients("Jack", "Ochieng", "Otieno", "jackochieng@gmail.com", "36", "Nairobi");
        assertTrue(firstClients.equals(secondClients));
    }

    @Test
    public void save_savesIntoDatabase_true() {
        Clients myClients = new Clients("Jane", "Muthoni", "Mwangi", "janemuthoni@gmail.com", "40", "Nairobi");
        myClients.save();
        assertTrue(Clients.all().get(0).equals(myClients));
    }

    @Test
    public void all_returnsAllInstancesOfClients_true() {
        Clients firstClients = new Clients("Jane", "Muthoni", "Mwangi", "janemuthoni@gmail.com", "40", "Nairobi");
        firstClients.save();
        Clients secondClients = new Clients("Jack", "Ochieng", "Otieno", "jackochieng@gmail.com", "36", "Nairobi");
        secondClients.save();
        assertEquals(true, Clients.all().get(0).equals(firstClients));
        assertEquals(true, Clients.all().get(1).equals(secondClients));
    }

    @Test
    public void save_assignsIdToObject() {
        Clients myClients = new Clients("Jane", "Muthoni", "Mwangi", "janemuthoni@gmail.com", "40", "Nairobi");
        myClients.save();
        Clients savedClients = Clients.all().get(0);
        assertEquals(myClients.getId(), savedClients.getId());
    }

    @Test
    public void getId_ClientsInstantiateWithAnId_1() {
        Clients testClients = new Clients("Jane", "Muthoni", "Mwangi", "janemuthoni@gmail.com", "40", "Nairobi");
        testClients.save();
        assertTrue(testClients.getId() > 0);
    }

    @Test
    public void find_returnsClientsWithSameId_secondClients() {
        Clients firstClients = new Clients("Jane", "Muthoni", "Mwangi", "janemuthoni@gmail.com", "40", "Nairobi");
        firstClients.save();
        Clients secondClients = new Clients("Jack", "Ochieng", "Otieno", "jackochieng@gmail.com", "36", "Nairobi");
        secondClients.save();
        assertEquals(Clients.find(secondClients.getId()), secondClients);
    }

//    @Test
//    public void getTasks_retrievesALlStylistsFromDatabase_StylistsList() {
//        Clients myClients = new Clients("Jane", "Muthoni", "Mwangi", "janemuthoni@gmail.com", "40", "Nairobi");
//        myClients.save();
//        Stylists firstStylists = new Stylists("Rose", "Karanu", "Karis", "rosekaris@gmail.com", "28", "Kiambu", myClients.getId());
//        firstStylists.save();
//        Stylists secondStylists = new Stylists("Cate", "Kalolia", "Chali", "catekalolia@gmail.com", "23", "South-B", myClients.getId());
//        secondStylists.save();
//        Stylists[] Stylists = new Stylists[] { firstStylists, secondStylists };
//        assertTrue(myClients.getStylists().containsAll(Arrays.asList(Stylists)));
//    }
}