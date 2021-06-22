package com.example.siksha;
import com.google.firebase.database.IgnoreExtraProperties ;

@IgnoreExtraProperties
public class StudInfo {




    public String session, mpregno,name, fname , dob, category, gender, mobile, shift, unit, admisiondate, password, email,dgtregno,uid,address, qexam, board, qresut, lastintitute, tcno, hq ;
    public int fees, feesd ;

    public StudInfo() {


    }

    public StudInfo(String session, String mpregno, String name, String fname, String dob, String category, String gender, String mobile, String shift, String unit, String admisiondate, String password, String email, String dgtregno, String uid, String address, String qexam, String board, String qresut, String lastintitute, String tcno, String hq, int fees, int feesd) {
        this.session = session;
        this.mpregno = mpregno;
        this.name = name;
        this.fname = fname;
        this.dob = dob;
        this.category = category;
        this.gender = gender;
        this.mobile = mobile;
        this.shift = shift;
        this.unit = unit;
        this.admisiondate = admisiondate;
        this.password = password;
        this.email = email;
        this.dgtregno = dgtregno;
        this.uid = uid;
        this.address = address;
        this.qexam = qexam;
        this.board = board;
        this.qresut = qresut;
        this.lastintitute = lastintitute;
        this.tcno = tcno;
        this.hq = hq;
        this.fees = fees;
        this.feesd = feesd;
    }


    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getMpregno() {
        return mpregno;
    }

    public void setMpregno(String mpregno) {
        this.mpregno = mpregno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAdmisiondate() {
        return admisiondate;
    }

    public void setAdmisiondate(String admisiondate) {
        this.admisiondate = admisiondate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDgtregno() {
        return dgtregno;
    }

    public void setDgtregno(String dgtregno) {
        this.dgtregno = dgtregno;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQexam() {
        return qexam;
    }

    public void setQexam(String qexam) {
        this.qexam = qexam;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getQresut() {
        return qresut;
    }

    public void setQresut(String qresut) {
        this.qresut = qresut;
    }

    public String getLastintitute() {
        return lastintitute;
    }

    public void setLastintitute(String lastintitute) {
        this.lastintitute = lastintitute;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getHq() {
        return hq;
    }

    public void setHq(String hq) {
        this.hq = hq;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public int getFeesd() {
        return feesd;
    }

    public void setFeesd(int feesd) {
        this.feesd = feesd;
    }

    public String getStudinfo1() {
        return studinfo1;
    }

    public void setStudinfo1(String studinfo1) {
        this.studinfo1 = studinfo1;
    }

    public String studinfo1 ;

public String getinfo(){

    studinfo1 = "Name : "+name+"\nFather Name: "+fname + "\nSession: "+session+"\nDOB: "+dob + "\nCategory: "+category+"\nGender: "+gender+"\nMobile Number: "+mobile+"\nShift: "+shift+"\nUnit: "+unit+"\nAdmission Date: "+admisiondate+"\nDGT Reg No.: "+dgtregno+"\nTotal Fees: "+fees+ "\nDue Fees: "+feesd+"\nUID: "+uid+"\nAddress: "+address+"\nQexam: "+qexam+"\nBoard: "+board+"\nQresult: " +qresut+"\nLast Institute: "+lastintitute+"\nTC Number: "+tcno+ "\nHQ : "+hq +" \n " ;

   return studinfo1 ;

}




}
