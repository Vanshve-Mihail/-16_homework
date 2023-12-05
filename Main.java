import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
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
        hospitalDatabase.addPatientToDepartment(patient3, department1);
        /*hospitalDatabase.printPatientsInfo();
        hospitalDatabase.printDepartmentsInfo();
         */
        ConnectionUtil db = new ConnectionUtil();
        Connection conn = db.connect_to_db("test_db", "postgres", "416256");
        // добавление пациента
        /*PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO Patients(full_name, age, gender) VALUES(?,?,?)");
        insertStmt.setString(1,patient2.getFullName());
        insertStmt.setInt(2,patient2.getAge());
        insertStmt.setString(3,patient2.getGender());
        insertStmt.executeUpdate();
         */


        // добавление отделения
        /*PreparedStatement insertStmt1 = conn.prepareStatement("INSERT INTO Departments(full_name, patients) VALUES(?,?)");
        insertStmt1.setString(1,department1.getName());
        insertStmt1.setInt(2,department1.getPatientCount());
        insertStmt1.executeUpdate();
         */

        //удаление
        /*PreparedStatement deletStmt = conn.prepareStatement("DELETE FROM patients WHERE full_name = ?");
        deletStmt.setString(1, "Жора ЫЫЫ");
        deletStmt.executeUpdate();
         */
        //вывод данных в терминал
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM patients");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("full_name:%s age:%s gender:%s%n", rs.getString("full_name"), rs.getInt("age"), rs.getString("gender"));
        }
        PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM departments");
        System.out.println();
        ResultSet rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            System.out.printf("full_name:%s patients:%s%n", rs1.getString("full_name"), rs1.getInt("patients"));
        }
    }
}
