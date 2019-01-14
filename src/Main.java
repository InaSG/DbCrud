import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Knyga knyg = new Knyga("Jurgita", "Baltrukonyte", 2009, 3, "Torčiukas ant debesėlio");
        user1.setSalary(777.77);
        user1.setName("Antanas");
//      EmployeeDAO.insert(user1);

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList = EmployeeDAO.searchById(5);
        Employee user = employeeList.get(0);

        user.setName("Antanas2");
        //EmployeeDAO.edit(user);

        EmployeeDAO.delete(5);

    }
}


/*
1. Kiek is viso lenteleje "knygos" yra knygu:
SELECT COUNT(Id)
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

