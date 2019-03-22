package contactBook;

import contactBook.model.PhoneData;

import java.util.HashSet;
import java.util.Iterator;

public class Manager {
    public HashSet<PhoneData> infoStorage = new HashSet<PhoneData>();
    static Manager inst = null;

    public static Manager createManagerInst()
    {
        if(inst == null)
            inst = new Manager();
        return inst;
    }

    public boolean deleteData(String name){
        Iterator<PhoneData> iterator = infoStorage.iterator();
        while (iterator.hasNext()){
            PhoneData curInf = iterator.next();
            if(name.compareTo(curInf.name) == 0){
                iterator.remove();
            }
        }
        return false;
    }

    public String surchData(String name){
        PhoneData inf = surch(name);
        if (inf == null) {
            return null;
        } else {
            return inf.toString();
        }
    }

    private PhoneData surch(String name){
        Iterator<PhoneData> iterator = infoStorage.iterator();
        while (iterator.hasNext()){
            PhoneData curInf = iterator.next();
            if (name.compareTo(curInf.name) == 0){
                return curInf;
            }
        }
        return null;
    }
}