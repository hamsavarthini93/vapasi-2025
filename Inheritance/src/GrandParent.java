public class GrandParent {
    String name;
    int age;

    GrandParent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public GrandParent() {

    }

    void displayGrantParent() {
        GrandParent grandParent = new GrandParent("Hamsi", 32);
        System.out.println("Name" + " " + grandParent.name);
        System.out.println("Age" + " " + grandParent.age);
    }
}
