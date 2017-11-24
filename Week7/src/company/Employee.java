package company;

public class Employee {
    private String name;
    private Sex sex;
    private Position position;
    private SkillLevel skillLevel;
    private int yearsOfService;
    private int salary;

    public Employee(String name, Sex sex, Position position, SkillLevel skillLevel, int yearsOfService, int salary) {
        this.name = name;
        this.sex = sex;
        this.position = position;
        this.skillLevel = skillLevel;
        this.yearsOfService = yearsOfService;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", position=" + position +
                ", skillLevel=" + skillLevel +
                ", yearsOfService=" + yearsOfService +
                ", salary=" + salary +
                '}';
    }
}
