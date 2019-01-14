public class Employee {
    private String name;
    private String surname;
    private double salary;
    private int id;
    private String data;

    public Employee() {

    }
    // skirtas naujo įrašo kūrimui.
    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    // skirtas darbui su egzistuojančiais duomenų bazės įrašais.
    public Employee(int id, String name, String surname, double salary, String data) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.id = id;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}