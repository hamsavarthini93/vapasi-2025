public class Parent extends GrandParent {
    int salary;
    String department;

    public Parent(int salary, String department) {
        super();
        this.salary = salary;
        this.department = department;
    }

    public Parent() {

    }

    void parentDisplay() {
        Parent parent = new Parent(400, "IT");
        displayGrantParent();
        System.out.println("Salary" + " " + parent.salary);
        System.out.println("Department" + " " + parent.department);
    }


}
