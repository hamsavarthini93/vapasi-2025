package org.example;

import java.util.List;

public class Expense {
    String paidBy;
    Double amount;
    List<String> sharedMembers;

    public Expense() {
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<String> getSharedMembers() {
        return sharedMembers;
    }

    public void setSharedMembers(List<String> sharedMembers) {
        this.sharedMembers = sharedMembers;
    }

    public double sharePerPerson(Double amount, Integer groupSize) {
        return amount / groupSize;
    }

}
