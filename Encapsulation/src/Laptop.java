public class Laptop {
    static String logo;
    Processor processor;
    RAM ram;
    Hardisk hardisk;

    public Laptop() {

    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Hardisk getHardisk() {
        return hardisk;
    }

    public void setHardisk(Hardisk hardisk) {
        this.hardisk = hardisk;
    }
}
