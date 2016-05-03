import org.sql2o.*;
import java.util.List;
public class Doctor {
  private String name;
  private String speciality;
  private int id;

  @Override
  public boolean equals(Object otherDoctor){
    if(!(otherDoctor instanceof Doctor)){
      return false;
    }else {
    Doctor newDoctor = (Doctor) otherDoctor;
    return this.getName().equals(newDoctor.getName()) &&
    this.getId() == newDoctor.getId();
    }

  }

  public Doctor(String name, String speciality){
    this.name = name;
    this.speciality = speciality;
  }

  public String getName(){
    return name;
  }
  public String getCondition(){
    return speciality;
  }

  public int getId(){
    return id;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO doctors(speciality, name) VALUES (:speciality, :name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("speciality", this.speciality)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Doctor>all(){
    String sql = "SELECT id, speciality FROM doctors";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Doctor.class);
    }
  }

}
