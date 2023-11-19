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
        hospitalDatabase.addPatient(patient1);
        hospitalDatabase.addPatient(patient2);
        hospitalDatabase.addPatientToDepartment(patient1, department1);
        hospitalDatabase.addPatientToDepartment(patient2, department1);
        hospitalDatabase.editPatient(patient1, patient2);
        hospitalDatabase.printPatientsInfo();
        try {
            String url = "jdbc:mysql://localhost:3306/practica";
            String username = "11";
            String password = "416256";
            Connection connection = DriverManager.getConnection(url, username, password);
            String createDepartmentsTable = "CREATE TABLE IF NOT EXISTS departments (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "patient_count INT DEFAULT 0" +
                    ")";
            Statement createDepartmentsStatement = connection.createStatement();
            createDepartmentsStatement.execute(createDepartmentsTable);
            String createPatientsTable = "CREATE TABLE IF NOT EXISTS patients (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "full_name VARCHAR(100) NOT NULL," +
                    "age INT," +
                    "gender VARCHAR(10)" +
                    ")";
            Statement createPatientsStatement = connection.createStatement();
            createPatientsStatement.execute(createPatientsTable);
            for (Department department : hospitalDatabase.getDepartments()) {
                String insertDepartmentQuery = "INSERT INTO departments (name, patient_count) VALUES (?, ?)";
                PreparedStatement insertDepartmentStatement = connection.prepareStatement(insertDepartmentQuery);
                insertDepartmentStatement.setString(1, department.getName());
                insertDepartmentStatement.setInt(2, department.getPatientCount());
                insertDepartmentStatement.executeUpdate();
            }
            for (Patient patient : hospitalDatabase.getPatients()) {
                String insertPatientQuery = "INSERT INTO patients (full_name, age, gender) VALUES (?, ?, ?)";
                PreparedStatement insertPatientStatement = connection.prepareStatement(insertPatientQuery);
                insertPatientStatement.setString(1, patient.getFullName());
                insertPatientStatement.setInt(2, patient.getAge());
                insertPatientStatement.setString(3, patient.getGender());
                insertPatientStatement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
