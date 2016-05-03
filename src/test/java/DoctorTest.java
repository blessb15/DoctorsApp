import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DoctorTest {

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
}
