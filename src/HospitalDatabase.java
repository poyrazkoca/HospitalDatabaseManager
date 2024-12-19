//--------------------------------------------------------------
// Title: HospitalDatabase
// Author: Poyraz Koca
// Description: Manages a database of patients and their information.
//--------------------------------------------------------------
import java.util.*;
public class HospitalDatabase {

    TreeMap<Integer, MyBinaryTree> database;
    public HospitalDatabase() {
        this.database = new TreeMap<>();
    }

    public static void main(String args[])
    {
        HospitalDatabase hd = new HospitalDatabase();
        hd.showAllPatients();
        hd.addPatient("Michael Johnson","Emma Thompson", 19, 12, 2022);
        hd.addPatient("Ethan Lee", "Olivia Sanchez", 8, 9, 2020);
        hd.addPatient("Noah Miller", "Olivia Sanchez", 27, 2, 2019);
        hd.addPatient("Liam Davis", "Isabella Martinez", 3, 4, 2022);
        hd.addPatient("Ava Taylor", "Isabella Martinez", 15, 5, 2024);
        hd.addPatient("Mason Moore", "William Anderson", 7, 6, 2021);
        hd.addPatient("Charlotte Garcia", "Lucas Lewis", 30, 10, 2023);
        hd.addPatient("Noah Miller", "Olivia Sanchez", 27, 2, 2019);
        System.out.println();
        hd.showAllPatients();
        System.out.println();
        hd.removePatient("Ava Taylor");
        System.out.println();
        hd.showAllPatients();
        System.out.println();
        hd.showPatient("Michael Johnson");
        hd.addMember("Mason Moore", "Daniel Roberts", "Nurse");
        hd.addMember ("Mason Moore", "Victoria Stewart", "Radiologist");
        hd.addMember ("Mason Moore", "Tyler Campbell", "Medical Assistant");
        hd.addMember ("Mason Moore", "Hannah Martin", "Paramedic");
        hd.addMember ("Michael Johnson", "Jack Allen", "Patient Care Technician");
        hd.addMember ("Michael Johnson", "Oliver Nelson", "Anesthesiologist");
        hd.addMember ("Michael Johnson", "Sophia Rivera", "Pathologist");
        hd.addMember ("Michael Johnson", "Evan Hall", "Laboratory Technician");
        hd.addMember ("Michael Johnson", "Megan Price", "Nurse");
        hd.addMember ("Ava Taylor", "Brianna Reed", "Dietitian");
        hd.addMember ("Charlotte Garcia", "Oliver Nelson", "Anesthesiologist");
        hd.addMember ("Charlotte Garcia", "Trevor Jenkins", "Medical Equipment Technician");
        hd.addMember ("Charlotte Garcia", "Justin Flores", "Speech-Language Pathologist");
        System.out.println();
        hd.showPatient("Mason Moore");
        System.out.println();
        hd.showPatient("Michael Johnson");
        System.out.println();
        hd.removeMember("Michael Johnson", "Evan Hall");
        System.out.println();
        hd.showPatient("Michael Johnson");
        System.out.println();
        hd.showDoctorPatients("Olivia Sanchez");
        System.out.println();
        hd.showDoctorPatients("Emma Thompson");
        System.out.println();
        hd.showPatients(2022);
        System.exit(0);

    }

    public void addPatient(String patientName, String doctorName,int visitDay, int visitMonth, int visitYear) {
//    		 /--------------------------------------------------------------
        // Summary: Add a new patient to the database.
        // Parameters: patientName ->Name of the patient
        // doctorName ->Name of the doctor
        // visitDay ->Day of the visit
        // visitMonth ->Month of the visit
        // visitYear ->Year of the visit
        // Postcondition:Patient is added to the database.
        //--------------------------------------------------------------
        Patient patient =new Patient(patientName,doctorName,visitDay, visitMonth, visitYear);
        if (!database.containsKey(visitYear)){

            database.put(visitYear, new MyBinaryTree());  }
        if (database.get(visitYear).search(patientName) != null) {
            System.out.println("ERROR: Patient " + patientName + " overwritten");
        } else {
            System.out.println("INFO: Patient " + patientName + " has been added");
        }
        database.get(visitYear).insert(patientName, patient); }

    public void removePatient(String patientName ){
        //--------------------------------------------------------------
        // Summary:Remove a patient from the database .
        // Parameters: patientName ->Name of the patient to be removed
        // Postcondition: If the patient exists,they are removed from the database.
        // Otherwise, show error message.
        //--------------------------------------------------------------
        for (MyBinaryTree patients :database.values()) {
            if (patients.search(patientName) !=null){
                patients.deleteKey(patientName);
                System.out.println("INFO: Patient " + patientName + " has been removed");
                return;
            }
        } System.out.println("ERROR: Patient " +patientName+ " does not exist");
    }

    public void addMember (String patientName, String memberName, String memberRole) {
        //--------------------------------------------------------------
        // Summary: Adds a member to the care team of a patient.
        // Parameters: patientName ->Name of the patient
        // memberName ->Name of the member to be added
        // memberRole ->Role of the member
        // Postcondition: If the patient exists, the member is added to their care team.
        // Otherwise,show error message.
        //-------------------------------------------------------------
        for (MyBinaryTree patients : database.values())
        {
            if (patients.search(patientName)!=null){
                patients.search(patientName).careTeam.put( memberName,new MedicalStaff(memberName, memberRole)) ;
                System.out.println("INFO: " + memberName + " has been added to the patient " +patientName);

                return;
            }
        }System.out.println("ERROR: Patient "+ patientName + " does not exist");
    }

    public void removeMember(String patientName,String memberName) {
        //--------------------------------------------------------------
        // Summary: Removes a member from care team of a patient.
        // Parameters: patientName ->Name of the patient
        // memberName-> Name of the member to be removed
        // Postcondition:If the patient and member exist, the member is removed from the patient's care team.
        // Otherwise, show error message.
        //--------------------------------------------------------------
        for (MyBinaryTree patients :database.values()){
            if (patients.search(patientName) !=null)
            {
                if (patients.search(patientName).careTeam.containsKey(memberName))
                {
                    patients.search(patientName).careTeam.remove(memberName);
                    System.out.println("INFO: " + memberName+ " has been removed from the patient " + patientName);
                    return;
                }    }   }
        System.out.println("ERROR: Member " + memberName + " does not exist for patient " + patientName);
    }
    public void showAllPatients(){
        //--------------------------------------------------------------
        // Summary: Display info for all patients in the database.
        // Postcondition: Info for each patient is displayed using an inorder traversal of the BST.
        //--------------------------------------------------------------
        for (MyBinaryTree patients :database.values()) {
            patients.inOrderTraversal();}
    }

    public void showPatient(String patientName) {
        //--------------------------------------------------------------
        // Summary: Displays information for a specific patient.
        // Parameters: patientName -<Name of the patient to display information for
        // Postcondition: If the patient exists, their information is displayed.
        // Otherwise, "--none--" is displayed.
        //--------------------------------------------------------------
        for (MyBinaryTree patients : database.values()) {
            Patient patient = patients.search(patientName);
            if (patient != null) {
                System.out.println(patient.name);
                System.out.println(patient.visitDay + "/" + patient.visitMonth + "/" + patient.visitYear);
                System.out.println(patient.doctorName);
                for (MedicalStaff member : patient.careTeam.values()) {
                    System.out.println(member.name + ", " + member.role);
                }
                return;
            }
        }
        System.out.println("--none--");
    }


    public void showDoctorPatients(String doctorName) {
        //--------------------------------------------------------------
        // Summary: Displays patients associated with a specific doctor.
        // Parameters: doctorName ->Name of the doctor to display patient information for
        // Postcondition: Patient  information associated with the specified doctor is displayed.
        //--------------------------------------------------------------
        System.out.println(doctorName) ;
        for (MyBinaryTree patients :database.values()) {
            patients.inOrderTraversal(node -> {

                if (node.value.doctorName.equals(doctorName)) {
                    System.out.println(node.value.name + ", " + node.value.visitDay + "/" + node.value.visitMonth + "/" + node.value.visitYear);
                }
            });
        }
    }
    public void showPatients(int visitYear) {
        //--------------------------------------------------------------
        // Summary: Displays patients who visited in a specific year.
        // Parameters: visitYear ->Year for which patient information is displayed
        // Postcondition: Patient information for the specified year is displayed.
        //--------------------------------------------------------------
        System.out.println(visitYear);
        for(MyBinaryTree patients :database.values()) 	{
            patients.inOrderTraversal(node -> {
                if (node.value.visitYear == visitYear)  {
                    System.out.println(node.value.name + ", " +node.value.visitDay+ "/" + node.value.visitMonth);
                }
            });
        }
    }

}
