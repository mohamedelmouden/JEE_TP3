# Projet springdi
----------------


Description :
---
Projet Maven démontrant l'Injection de Dépendances (DI) avec Spring Framework 5.3.30.
L'objectif principal est de respecter le principe OCP (Open/Closed Principle) :

MetierImpl ne change jamais — seule la configuration détermine quelle implémentation IDao est injectée.

Prérequis :
---

- JDK 21 (ou 11+)
- Maven 3.x
- IntelliJ IDEA (ou autre IDE)
- Spring Context 5.3.30

# Modes d'exécution :
----
Choix 1 — Par profil Spring (@Profile)
------
Dans Presentation2.java, décommenter une seule ligne :

- ctx.getEnvironment().setActiveProfiles("prod");  // DaoImpl  (100) → 200.0
- // ctx.getEnvironment().setActiveProfiles("dev");    // DaoImpl2 (150) → 300.0
- // ctx.getEnvironment().setActiveProfiles("file");   // DaoFile  (180) → 360.0
- // ctx.getEnvironment().setActiveProfiles("api");    // DaoApi   (220) → 440.0

ctx.register(Presentation2.class);
ctx.refresh();

==> résultat :
-----
<img width="960" height="540" alt="test choix 1 decommenter un ligne et il donne toujours ka m resulta 200" src="https://github.com/user-attachments/assets/9b2b95a6-ff6a-45af-bbbb-174d5c65985a" />


Choix 2 — Par propriété externe (app.properties)
-----
Dans app.properties, changer la valeur :

pour avoir 200.0

dao.target=dao.DaoImpl

pour avoir 300.0

dao.target=dao.DaoImpl2

pour avoir 360.0

dao.target=dao.DaoFile

pour avoir 440.0

dao.target=dao.DaoApi




https://github.com/user-attachments/assets/1c0c432f-e7b8-4c3f-bce6-c4fd26e9d1de



l'effet de  @Primary :
------

<img width="960" height="540" alt="leffet de primary" src="https://github.com/user-attachments/assets/dfb939b0-4f86-4eed-9293-74f7dd4b3688" />




l'ancement des test :
----




https://github.com/user-attachments/assets/8212f1f0-3fdc-4c23-a144-04334ed0697f









