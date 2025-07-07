package org.tw.splitwise;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class SplitWiseStrategy {

    public static String runSplitter(Properties props) throws PropertiesNotFoundException {
        Logger logger = Logger.getLogger(SplitWiseStrategy.class.getName());

        if (props.isEmpty()) {
            throw new PropertiesNotFoundException("splitwise.properties file is found empty");
        }
        Map<String, Double> groupeTransactions = new LinkedHashMap<>();

        AtomicInteger counter = new AtomicInteger(1);
        while (true) {
            String prefix = "expense." + counter;

            String paidBy = props.getProperty(prefix + ".paidBy");
            String amountStr = props.getProperty(prefix + ".amount");
            String sharedMembersStr = props.getProperty(prefix + ".sharedMembers");

            if (paidBy == null && amountStr == null && sharedMembersStr == null)
                break;

            if (paidBy == null || amountStr == null || sharedMembersStr == null) {
                return "Required properties are not found in the file";
            }
            double amount = Double.parseDouble(amountStr);
            List<String> sharedMembers = Arrays.stream(sharedMembersStr.split(","))
                    .map(String::trim)
                    .toList();

            double share = amount / sharedMembers.size();

            for (String member : sharedMembers) {
                if (!member.equals(paidBy)) {
                    String key = member + " pays " + paidBy;
                    groupeTransactions.merge(key, share, Double::sum);
                }
            }

            counter.incrementAndGet();
        }
        groupeTransactions.forEach((key, value) ->
                logger.info(key + " " + value)
        );

        return "Grouped transactions calculated.";
    }

    public static void checkFileExists(InputStream input) throws IOException, PropertiesNotFoundException {
        Properties props = new Properties();
        if (input == null) {
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
