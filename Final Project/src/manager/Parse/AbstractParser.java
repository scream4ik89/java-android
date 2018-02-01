package manager.Parse;

import manager.Manager;
import model.entity.Pub;

     /*
    в соответствии с полиморфизмом все данные и методы парсера определены в
    абстрактном классе. сам метод parse реализован в конкретных парсерах
     */

public abstract class AbstractParser implements Runnable {
    private Pub pub;
    public abstract void parse();

    @Override
    public void run() {
        parse();
        Manager.getInstance().setPub(pub);
    }

    public void setPub(Pub pub) {
        this.pub = pub;
    }
}
