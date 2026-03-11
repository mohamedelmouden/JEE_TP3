package presentation;
// modifier la classe presentation de package presentation
import metier.IMetier;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan(basePackages = {"metier","dao"})
public class Presentation2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        // Choix 1 (profils) : décommenter un profil pour tester
        // la choix 1 : on decommente la ligne 2 et en obtenue 200 = 100*2
       // ctx.getEnvironment().setActiveProfiles("dev");   // -> DaoImpl2 (150) => 300
       //ctx.getEnvironment().setActiveProfiles("prod");  // -> DaoImpl  (100) => 200
       // ctx.getEnvironment().setActiveProfiles("file");  // -> DaoFile  (180) => 360
       // ctx.getEnvironment().setActiveProfiles("api");   // -> DaoApi   (220) => 440

        // Choix 2 (propriété externe) : laisser les profils vides,
        // PropertyDrivenConfig créera un bean "dao" selon app.properties
        // alors il faut le charger par dao.impl="l implementation soueté"

        ctx.register(Presentation2.class, config.PropertyDrivenConfig.class);
        ctx.refresh();

        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
        ctx.close();
    }
}