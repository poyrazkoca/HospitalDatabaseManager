//-----------------------------------------------------
// Title: Patient
// Author: Poyraz Koca
// Description:Represents a patient with his attributes:name,doctor's name, visit day, month, and year.
// Has a constructor to initialize this attributes and an overridden toString() method for the needed string representation.
//-----------------------------------------------------
import java.util.*;

public class Patient {
    String name;
    String doctorName;
    int visitDay;
    int visitMonth;
    int visitYear;
    TreeMap<String, MedicalStaff> careTeam;

    public Patient (String name, String doctorName, int visitDay, int visitMonth, int visitYear) {
        this.name = name;
        this.doctorName = doctorName;
        this.visitDay = visitDay;
        this.visitMonth = visitMonth;
        this.visitYear = visitYear;
        this.careTeam = new TreeMap<>();
    }
    @Override
    public String toString() {
        return this.name +
                ", " + this.visitYear +
                ", "+ this.doctorName;
    }
}
