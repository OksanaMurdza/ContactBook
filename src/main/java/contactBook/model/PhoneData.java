package contactBook.model;

import java.io.Serializable;

public class PhoneData implements Serializable {
    public String phone;
    public String name;

    public PhoneData(String name, String num){
        this.name = name;
        phone = num;
    }

    public void showPanel(){
        System.out.println("Name: " + name);
        System.out.println("Number: " + phone);
    }

    public String toString()
    {
        return "name: "+name+'\n'+"phone: "+phone+'\n';
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public boolean equals(Object obj){
        PhoneData tmp = (PhoneData) obj;
        if(name.compareTo(tmp.name) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
