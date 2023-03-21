import java.io.Serializable;
public class Joueur implements Serializable {
private int id;
private String nom;
private String equipe;
public Joueur (int id, String nom, String equipe) {
  this.id = id;
  this.nom = nom;
  this.equipe = equipe;
}
public int getId() {
 return id;
}
public String getName() {
 return nom;
}
public String getTeam() {
 return equipe;
}
@Override
public String toString() {
 return "id = " + getId() + " Name = " + getName() + " Équipe : " + getTeam();
}
}
