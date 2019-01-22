package com.example.mavsapp.sefinal;

public class Student {

    //Private Variable
    int _id;
    String _name;
    String _password;

    //empty constructor
    public Student() {
    }

    //all parameter in Constructor
    public Student(int _id, String _name, String _password){
        this._id = _id;
        this._name = _name;
        this._password = _password;
    }

    public String get_name() {
        return _name;
    }

    public String get_password() {
        return _password;
    }

}
