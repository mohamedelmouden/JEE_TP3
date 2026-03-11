package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao;
    @PostConstruct
    private void init() {
        System.out.println("[TRACE] DAO injecté = " + dao.getClass().getSimpleName());
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() { return dao.getValue() * 2; }
}