package myapp.bean;

public class StudentBean {
    private int ID;
    private String Name;
    private String Surname;

    public int getID() {
        return ID;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setID(int iD) {
        this.ID = iD;
    }
}
