import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PatientTest {

  @Before
public void setUp() {
  DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/docoffice_test", null, null);
}

@After
public void tearDown() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM patients *;";
    con.createQuery(sql).executeUpdate();
  }
}

  @Test
public void patientsAreTheSame() {
  Patient patient1 = new Patient("Bill", "hurts");
  Patient patient2 = new Patient("Bill", "hurts");
  assertTrue(patient1.equals(patient2));
}

  @Test
public void Patient_checkInstantiatesCorrectly_BobFlu() {
  Patient newPat = new Patient("Bill", "hurts");
  assertEquals(true, newPat instanceof Patient);
  }

@Test
public void getName_taskInstantiatesWithName_String() {
  Patient newPat = new Patient("Bill", "hurts");
  assertEquals("Bill", newPat.getName());
}
@Test
public void save_assignsIdToObject() {
  Patient myPatient = new Patient("Bill", "hurts");
  myPatient.save();
  Patient savedPatient = Patient.all().get(0);
  assertEquals(myPatient.getId(), savedPatient.getId());
}
}
