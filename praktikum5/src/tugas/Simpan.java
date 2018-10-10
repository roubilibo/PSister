
package tugas;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Simpan {
    public void serialize(List<Mahasiswa> pList, String fileName)
    {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(pList);
         } catch (IOException e) {
             System.out.println("gsgal serialize "+e);
        }
    }
    
    public List<Mahasiswa> deserialize(String fileName) {
        List<Mahasiswa> pList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            pList = (List<Mahasiswa>) in.readObject();
        } catch(Exception ex) {
            System.out.println(ex);
        }
        return pList;
    }
}
