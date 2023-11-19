class Department {
    private String name;
    private int patientCount;
    public Department(String name, int patientCount) {
        this.name = name;
        this.patientCount = patientCount;
    }
    public String getName() {
        return name;
    }
    public int getPatientCount() {
        return patientCount;
    }
    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }
}
