package org.tw.splitwise;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class SplitWiseStrategy {

    public static String runSplitter(Properties props) throws PropertiesNotFoundException {
        Logger logger = Logger.getLogger(SplitWiseStrategy.class.getName());

        AtomicInteger counter = new AtomicInteger(1);
        if (!props.isEmpty()) {
            while (true) {
                String personCount = "expense." + counter.get();
                if (props.getProperty(personCount + ".paidBy") == null
                        || props.getProperty(personCount + ".amount") == null
                        || props.getProperty(personCount + ".sharedMembers") == null)
                    return "Required properties are not found in the file";
                Expense expense = new Expense();
                expense.setPaidBy(props.getProperty(personCount + ".paidBy"));
                expense.setAmount(Double.parseDouble(props.getProperty(personCount + ".amount")));
                expense.setSharedMembers(Arrays.stream(props.getProperty(personCount + ".sharedMembers").split(",")).toList());

                double shareOfEach = expense.sharePerPerson(expense.getAmount(), expense.getSharedMembers().size());

                expense.getSharedMembers().stream().filter(isBorrower -> !expense.getPaidBy().equals(isBorrower)).
                        forEach(sharedPerson -> logger.info(sharedPerson + " pays " + shareOfEach + " to " + expense.getPaidBy()));
                counter.incrementAndGet();
            }
        }
        throw new PropertiesNotFoundException("splitwise.properties file is found empty");

    }

    public static void checkFileExists(InputStream input) throws IOException, PropertiesNotFoundException {
        Properties props = new Properties();
        if(input == null){
            throw new IOException("splitwise.properties file does not exist");
        }
        props.load(input);
        runSplitter(props);
    }

    public static void main(String[] args) throws IOException, PropertiesNotFoundException {
        InputStream input = SplitWiseStrategy.class.getClassLoader().
                getResourceAsStream("splitwise.properties");
        checkFileExists(input);


    }

}
