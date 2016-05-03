import org.sql2o.*;

public class Doctor {
  private String name;
  private String speciality;

  @Override
  public boolean equals(Object otherDoctor){
    if(!(otherDoctor instanceof Doctor)){
      return false;
    }else {
    Doctor newDoctor = (Doctor) otherDoctor;
    return this.getName().equals(newDoctor.getName());
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
}
