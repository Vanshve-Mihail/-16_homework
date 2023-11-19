class Patient {
    private String fullName;
    private int age;
    private String gender;
    public Patient(String fullName, int age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }
    public String getFullName() {
        return fullName;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
}
