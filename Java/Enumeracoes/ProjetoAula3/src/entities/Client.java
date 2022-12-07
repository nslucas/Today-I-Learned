package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private String name;
    private String email;
    private Date birthDate;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Client(){}

    public Client(String name, String email, Date birthDate){
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }
    public Date getBirthDate(){
        return this.birthDate;
    }

    public void setName(String name){this.name = name;}

    public void setEmail(String email){this.email = email;}

    public void setBirthDate(Date date){this.birthDate = date;}

    @Override
    public String toString() {
        return name + " (" + sdf.format(birthDate) + ") - " + email;
    }
}

