public class Child extends Parent {
    String designation;
    String location;

    Child(String designation, String location) {
        super();
        this.designation = designation;
        this.location = location;
    }

    public static void main(String[] args) {
        Child child = new Child("Manager", "Bangalore");
        child.parentDisplay();
        System.out.println("Designation" + " " + child.designation);
        System.out.println("Location" + " " + child.location);
    }

}
