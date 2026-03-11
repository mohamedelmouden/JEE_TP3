import config.PropertyDrivenConfig;
import metier.IMetier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import presentation.Presentation2;
import static org.junit.Assert.assertEquals;

public class OcpSelectionTest {

    private AnnotationConfigApplicationContext ctx;

    @Before
    public void setUp() {
        System.clearProperty("dao.target");
    }

    @After
    public void tearDown() {
        System.clearProperty("dao.target");
        if (ctx != null) ctx.close();
    }

    @Test
    public void devProfile_choisitDao2_300() {
        ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(Presentation2.class);
        ctx.scan("dao");
        ctx.refresh();
        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(300.0, m.calcul(), 1e-6);
    }

    @Test
    public void prodProfile_choisitDao_200() {
        ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(Presentation2.class);
        ctx.scan("dao");
        ctx.refresh();
        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(200.0, m.calcul(), 1e-6);
    }

    @Test
    public void propertyDriven_daoApi_440() {
        System.setProperty("dao.target", "dao.DaoApi");
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(PropertyDrivenConfig.class);
        ctx.scan("metier");
        ctx.refresh();
        assertEquals(440.0, ctx.getBean(IMetier.class).calcul(), 1e-6);
    }
}