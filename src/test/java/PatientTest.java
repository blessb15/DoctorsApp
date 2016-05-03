import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PatientTest {

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
}
