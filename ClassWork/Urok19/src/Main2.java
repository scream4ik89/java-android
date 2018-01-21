import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main2 {
    private Student student = new Student(); // сильная ссылка которую нельзя удалить сборщиком мусора
    private WeakReference<Student> studentWeakReference = new WeakReference<Student>(student);
    //можно удалить эту ссылку, если не осталось сильных
    private SoftReference<Student> studentSoftReference = new SoftReference<Student>(student);
    //мягкая ссылка, которая может удалиться, если не будет хватать памяти

    public void main(){
        Student student = studentSoftReference.get(); // выдаст null, если ссылка будет удалена
        Main main = new Main();
    }
}
