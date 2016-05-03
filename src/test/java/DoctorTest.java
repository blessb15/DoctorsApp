import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DoctorTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/docoffice_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM doctors *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Test
  public void doctorsAreTheSame() {
    Doctor doctor1 = new Doctor("Bill", "knees");
    Doctor doctor2 = new Doctor("Bill", "knees");
    assertTrue(doctor1.equals(doctor2));
  }

  @Test
  public void Doctor_objectInstantiatesCorrectly_BillKnees() {
    Doctor testDoc = new Doctor("Bill", "Knees");
    assertEquals(true, testDoc instanceof Doctor);
    }

  @Test
  public void getName_taskInstantiatesWithName_String() {
    Doctor newDoc = new Doctor("Bill", "Foots");
    assertEquals("Bill", newDoc.getName());
  }

  @Test
  public void save_assignsIdToObject() {
    Doctor myDoctor = new Doctor("Bill", "Elbow");
    myDoctor.save();
    Doctor savedDoctor = Doctor.all().get(0);
    assertEquals(myDoctor.getId(), savedDoctor.getId());
  }
}
