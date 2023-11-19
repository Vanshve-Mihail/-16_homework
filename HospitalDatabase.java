import java.util.ArrayList;
import java.util.List;

class HospitalDatabase {
    private List<Department> departments;
    private List<Patient> patients;
    public List<Patient> getPatients() {
        return patients;
    }
    public List<Department> getDepartments(){
        return departments;
    }
    public HospitalDatabase() {
        this.departments = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    public void addDepartment(Department department) {
        departments.add(department);
    }
    public void removeDepartment(Department department) {
        departments.remove(department);
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }
    public void editDepartment(Department oldDepartment, Department newDepartment) {
        int index = departments.indexOf(oldDepartment);
        if (index != -1) {
            departments.set(index, newDepartment);
        }
    }
    public void editPatient(Patient oldPatient, Patient newPatient) {
        int index = patients.indexOf(oldPatient);
        if (index != -1) {
            patients.set(index, newPatient);
        }
    }
    public void addPatientToDepartment(Patient patient, Department department) {
        int index = departments.indexOf(department);
        if (index != -1) {
            Department currentDepartment = departments.get(index);
            currentDepartment.setPatientCount(currentDepartment.getPatientCount() + 1);
        }
    }
    public void removePatientFromDepartment(Patient patient, Department department) {
        int index = departments.indexOf(department);
        if (index != -1) {
            Department currentDepartment = departments.get(index);
            currentDepartment.setPatientCount(currentDepartment.getPatientCount() - 1);
        }
    }
    public void printDepartmentsInfo() {
        for (Department department : departments) {
            System.out.println("Отделение: " + department.getName() + ", Пациенты: " + department.getPatientCount());
        }
    }
    public void printPatientsInfo() {
        for (Patient patient : patients) {
            System.out.println("Пациент: " + patient.getFullName() + ", Возраст: " + patient.getAge() + ", Пол: " + patient.getGender());
        }
    }
}
