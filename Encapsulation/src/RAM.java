public class RAM {
    String size;
    String generation;

    public RAM() {

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }
    @Override
    public String toString(){
        return "Size :"+size+"\n"
                +"Generation :"+generation;
    }
}
