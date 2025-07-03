public class Processor {
    String generation;
    String gigahertz;

    public Processor() {

    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getGigahertz() {
        return gigahertz;
    }

    public void setGigahertz(String gigahertz) {
        this.gigahertz = gigahertz;
    }
    @Override
    public String toString(){
        return "Generation :"+generation+"\n"
                +"Gigahertz :"+gigahertz;
    }
}
