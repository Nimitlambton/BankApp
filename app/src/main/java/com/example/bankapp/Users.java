package com.example.bankapp;

public class Users {



    //ArrayList<String> userList =  new ArrayList<String>();


    //intergers
    int age;
    int Sin;
    int userId;
    int accbal;
    int checkacc;
    int cCbalance;
    int bills;
    int hyrdo;
    int water;
    int gas;

    public Users(int age, int sin, int userId, int accbal, int checkacc, int cCbalance, int bills, int hyrdo, int water, int gas, int phonebill, String userName, String address, String name, String password) {
        this.age = age;
        Sin = sin;
        this.userId = userId;
        this.accbal = accbal;
        this.checkacc = checkacc;
        this.cCbalance = cCbalance;
        this.bills = bills;
        this.hyrdo = hyrdo;
        this.water = water;
        this.gas = gas;
        this.phonebill = phonebill;
        this.userName = userName;
        this.address = address;
        Name = name;
        this.password = password;
    }

    int phonebill;

/*
    public Users(int age, int sin, int userId, int accbal, int checkacc, int cCbalance, int bills, String userName, String address, String name, String password) {
        this.age = age;
        Sin = sin;
        this.userId = userId;
        this.accbal = accbal;
        this.checkacc = checkacc;
        this.cCbalance = cCbalance;
        this.bills = bills;
        this.userName = userName;
        this.address = address;
        Name = name;
        this.password = password;
    }

  */

    String userName;
    String address;
    String Name;
    String password;

/*
  
    public Users(int age, int sin, int userId, int accbal, String userName, String address, String name, String password) {
        this.age = age;
        Sin = sin;
        this.userId = userId;
        this.accbal = accbal;
        this.userName = userName;
        this.address = address;
        Name = name;
        this.password = password;
    }

 */

    // int getter setters

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSin() {
        return Sin;
    }

    public void setSin(int sin) {
        Sin = sin;
    }

    public int getUserId() { return userId; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //String getter setter

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public int getCheckacc() {
        return checkacc;
    }

    public void setCheckacc(int checkacc) {
        this.checkacc = checkacc;
    }

    public int getcCbalance() {
        return cCbalance;
    }

    public void setcCbalance(int cCbalance) {
        this.cCbalance = cCbalance;
    }

    public int getBills() {
        return bills;
    }

    public void setBills(int bills) {
        this.bills = bills;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccbal() {
        return accbal;
    }

    public void setAccbal(int accbal) {
        this.accbal = accbal;
    }


    public int getHyrdo() {
        return hyrdo;
    }

    public void setHyrdo(int hyrdo) {
        this.hyrdo = hyrdo;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getPhonebill() {
        return phonebill;
    }

    public void setPhonebill(int phonebill) {
        this.phonebill = phonebill;
    }
}

