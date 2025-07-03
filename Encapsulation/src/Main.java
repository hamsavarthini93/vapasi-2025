import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {
        RAM ram = new RAM();
        ram.setGeneration("DDR1");
        ram.setSize("16GB");
        Hardisk hardisk = new Hardisk();
        hardisk.setSize("100GB");
        hardisk.setType("SSD");
        Processor processor = new Processor();
        processor.setGeneration("8th Gen");
        processor.setGigahertz("10 GHz");
        RAM ram1 = new RAM();
        ram1.setGeneration("DDR2");
        ram1.setSize("64GB");
        Hardisk hardisk1 = new Hardisk();
        hardisk1.setSize("200GB");
        hardisk1.setType("DSD");
        Processor processor1 = new Processor();
        processor1.setGeneration("10th Gen");
        processor1.setGigahertz("3.2 GHz");
        Laptop l1 = new Laptop();
        l1.setHardisk(hardisk);
        l1.setProcessor(processor);
        l1.setRam(ram);
        l1.setLogo("MAC");
        Laptop l2 = new Laptop();
        l2.setHardisk(hardisk1);
        l2.setProcessor(processor1);
        l2.setRam(ram1);
        List<Laptop> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.forEach(s -> System.out.println("Logo : " + s.getLogo() +
                "\n" + "Harddisk\n" + s.getHardisk().toString() + "\n" +
                "Processor\n" + s.getProcessor() + "\n" +
                "RAM\n" + s.getRam() + "\n"));
    }
}