import java.sql.*;

public class Main {
    public static void main(String[] args) {
        HospitalDatabase hospitalDatabase = new HospitalDatabase();
        Department department1 = new Department("Кардиологическое", 0);
        Department department2 = new Department("Нейрохирургическое", 0);
        hospitalDatabase.addDepartment(department1);
        hospitalDatabase.addDepartment(department2);
        Patient patient1 = new Patient("Настасья Филипповна", 25, "Женский");
        Patient patient2 = new Patient("Иван Васильевич", 44, "Мужской");
        Patient patient3 = new Patient("Жора ЫЫЫ", 23, "Мужской");
        hospitalDatabase.addPatient(patient1);
        hospitalDatabase.addPatient(patient2);
        hospitalDatabase.addPatient(patient3);
        hospitalDatabase.addPatientToDepartment(patient1, department1);
        hospitalDatabase.addPatientToDepartment(patient2, department1);
        hospitalDatabase.addPatientToDepartment(patient3, department2);
        hospitalDatabase.printPatientsInfo();
        hospitalDatabase.printDepartmentsInfo();
        String url = "jdbc:postgresql://localhost:5432/test_db";
        String user = "postgres";
        String password = "416256";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            ConnectionUtil.displayPatients(conn);
            ConnectionUtil.displayDepartments(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
