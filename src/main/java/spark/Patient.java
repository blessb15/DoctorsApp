import org.sql2o.*;
import java.util.List;

public class Patient {
  private String name;
  private String condition;
  private int id;

  @Override
  public boolean equals(Object otherPatient){
    if(!(otherPatient instanceof Patient)){
      return false;
    } else {
      Patient newPatient = (Patient) otherPatient;
      return this.getName().equals(newPatient.getName()) &&
      this.getId() == newPatient.getId();
    }
  }

  public Patient(String name, String condition){
    this.name = name;
    this.condition = condition;
  }

  public String getName(){
    return name;
  }

  public String getCondition(){
    return condition;
  }

  public int getId(){
    return id;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO patients(condition) VALUES (:condition)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("condition", this.condition)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Patient>all(){
    String sql = "SELECT id, condition FROM patients";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Patient.class);
    }
  }
}
