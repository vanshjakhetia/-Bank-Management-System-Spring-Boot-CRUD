package com.example.demo;


import jakarta.persistence.*;

@Entity
@Table(name="Accounts")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="bank_balance")
    private int balance;

    @Column(name="honor_score")
    private int honorScore;

    @Column(name="Loan Given")
    private boolean isLoanGiven;

    public Account() {
    }

    public Account(String firstName, String lastName, String email, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.balance = balance;
    }

    public Account(int id, String firstName, String lastName, String email, int balance, int honorScore, boolean isLoanGiven) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.balance = balance;
        this.honorScore = honorScore;
        this.isLoanGiven = isLoanGiven;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getHonorScore() {
        return honorScore;
    }

    public void setHonorScore(int honorScore) {
        this.honorScore = honorScore;
    }

    public boolean isLoanGiven() {
        return isLoanGiven;
    }

    public void setLoanGiven(boolean loanGiven) {
        isLoanGiven = loanGiven;
    }

    public String toString(){
        return "AccountDetails{" +
                "id" + id +
                ", name: " + firstName +" "+lastName+"\'"+
                "email: " + email + "\'" +
                "balance" + balance + "\'"+
                "}";
    }

}
