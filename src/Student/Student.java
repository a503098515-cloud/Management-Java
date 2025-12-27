package Student;

public class Student{

private String name;

private Long id;

private double gpa;



public Student(){}



public Student(String name, Long id, double gpa){

this.name=name;

this.id=id;

this.gpa = gpa;

}

public String getName(){

return name;

}

public void setName(String name){

this.name=name;

}

public Long getId(){

return id;

}

public void setID(Long id){

this.id=id;

}

public double getGPA(){

return gpa;

}

public void setgpa(double GPA){

this.gpa=gpa;

}

@Override

public String toString(){

return "Student[name='" +name+"', id="+ id+", gpa="+gpa+"]";

}



}
