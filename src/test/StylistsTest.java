import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TaskTest {

    @Before
    public void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", kingcubby, murugi254A);
    }

    @After
    public void tearDown() {
        try(Connection con = DB.sql2o.open()) {
            String deleteStylistsQuery = "DELETE FROM Stylists *;";
            String deleteClientsQuery = "DELETE FROM clients *;";
            con.createQuery(deleteStylistsQuery).executeUpdate();
            con.createQuery(deleteClientsQuery).executeUpdate();
        }

        @Test
     public void Stylists_instantiateCorrectly_true() {
            Stylists StylistsTest = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi")
        }


        @Test
        public void getName_StylistsInstantiatesWithFName_Sharon() {
            Stylists testStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            assertEquals("Home", testStylists.getFName());
        }

        Test
        public void getName_StylistsInstantiatesWithMiddleName_Sharon() {
            Stylists testStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            assertEquals("Home", testStylists.getmiddleName());
        }

        Test
        public void getName_StylistsInstantiatesWithLName_Sharon() {
            Stylists testStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            assertEquals("Home", testStylists.getLName());
        }

        Test
        public void getName_StylistsInstantiatesWithEmail_Sharon() {
            Stylists testStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            assertEquals("Home", testStylists.getEmail());
        }

        Test
        public void getName_StylistsInstantiatesWithAge_Sharon() {
            Stylists testStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            assertEquals("Home", testStylists.getAge());
        }

        Test
        public void getName_StylistsInstantiatesWithAddress_Sharon() {
            Stylists testStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            assertEquals("Home", testStylists.getAddress());
        }

        @Test
         public void save_returnTrueIfNameAreTheSame() {
            Stylists myStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            myStylists.save();
            assertTrue(Stylists.all().get(0).equals(myStylists));
        }

        @Test
        public void all_returnsAllInstancesOfStylists_true() {
            Stylists firstStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            firstStylists.save();
            Stylists secondStylists = new Task("Mercy", "Musenya", "Wanjiku", "mercymusenya@gmail.com", "22", "Machakos");
            secondStylists.save();
            assertEquals(true, Stylists.all().get(0).equals(firstStylists));
            assertEquals(true, Stylists.all().get(1).equals(secondStylists));
        }

        @Test
        public void save_assignsIdToObject() {
            Stylists myStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            myStylists.save();
            Stylists savedStylists = Stylists.all().get(0);
            assertEquals(myStylists.getId(), savedStylists.getId());
        }

        @Test
        public void getId_StylistsInstantiateWithAnID() {
            Stylists myStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            myStylists.save();
            assertTrue(myStylists.getId() > 0);
        }

        @Test
        public void find_returnsStylistsWithSameId_secondStylists() {
            Stylists firstStylists = new Stylists("Sharon", "Mumbi", "Mwangi", "sharonmwangi@gmail.com", "25", "Nairobi");
            firstStylists.save();
            Stylists secondStylists = new Task("Mercy", "Musenya", "Wanjiku", "mercymusenya@gmail.com", "22", "Machakos");
            secondStylists.save();
            assertEquals(Stylists.find(secondStylists.getId()), secondStylists);
        }

    }