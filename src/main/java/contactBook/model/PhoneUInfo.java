package contactBook.model;


public class PhoneUInfo extends PhoneData {
    int year;
    public  PhoneUInfo(String name, String num, int year){
        super(name,num);
        this.year = year;
    }
    public String toString(){
        return super.toString() + "year: " + year+ '\n';
    }
}
