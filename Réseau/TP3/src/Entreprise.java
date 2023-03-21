import java.io.Serializable;
public class Entreprise implements Serializable {
private int id;
private String name;
public Entreprise (int id, String name) {
  this.id = id;
  this.name = name;
}
public int getId() {
 return id;
}
public String getName() {
 return name;
}
@Override
public String toString() {
 return "Id = " + getId() + " Name = " + getName();
}
}
