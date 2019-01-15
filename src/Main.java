import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Knyga knygaNr1 = new Knyga("Jurgita", "Baltrukonyte", 2009, 3, "Torčiukas ant debesėlio");
       // knygaNr1.setLeidimas(7);
       // knygaNr1.setVardas("Aldutė");
       KnygaDAO.insert(knygaNr1);

        ArrayList<Knyga> knygaList = new ArrayList<>();
        knygaList = KnygaDAO.searchById(2);
        Knyga knygaNr = knygaList.get(0);

        knygaNr.setVardas("Antanas");
        KnygaDAO.edit(knygaNr);

        //KnygaDAO.delete(8);

        int knyguSkaicius = KnygaDAO.knyguIsleidimoMetai(2010);
        System.out.println("Knygu skaicius: " + knyguSkaicius);

    }
}


/*
1. Kiek is viso lenteleje "knygos" yra knygu:
SELECT COUNT(id)
 FROM Biblioteka.knygos;

 2. Isveskite visus pirmu knygu versiju pavadinimus, surikiuotus pagal isleidimo metus (nuo naujausios iki seniausios).
 SELECT pavadinimas, isleidimo_metai
FROM Biblioteka.knygos
WHERE leidimas = 1
ORDER BY isleidimo_metai desc;

3. Isvesti visas knygas, isleistas iki 2010.
SELECT *
FROM Biblioteka.knygos
WHERE isleidimo_metai <2010;

4. Isvesti kiek kokio leidimo knygu isleista.
SELECT leidimas, Count(*)
FROM Biblioteka.knygos
GROUP BY leidimas;

5. Isvesti populiariausios knygos pavadinima (t.y. ta, kuria isleido daugiausia autoriu).
SELECT pavadinimas, COUNT(*) AS isleido_autoriu
FROM Biblioteka.knygos
GROUP BY pavadinimas
ORDER BY isleido_autoriu DESC
LIMIT 1;
*/

