package hms;

import java.util.*;

public class HMS {
    public static void main(String[] args) {
        // TODO code application logic here
      PatientList pList=new PatientList();
      DoctorsList dList=new DoctorsList();
      Scanner s=new Scanner(System.in);
      String choice;
      while(true){
          MainMenu();
          choice=s.nextLine();
          if(choice.equals("1")){
              System.out.println("\n Doctor ID");
              String id=s.nextLine();
              System.out.println("\n Doctor Name");
              String name=s.nextLine();
              System.out.println("\n Doctor Contact");
              String contact=s.nextLine();
              System.out.println("\n Doctor Speciality");
              String spec=s.nextLine();
              System.out.println("\n Doctor Fees");
              int fee=s.nextInt();
              s.nextLine();
              Doctor d=new Doctor(id,name,contact,spec,fee);
              dList.Insert(d);
          }
          else if(choice.equals("2")){
              System.out.println("\n Patient ID");
              String id=s.nextLine();
              System.out.println("\n Patient Name");
              String name=s.nextLine();
              System.out.println("\n Patient Contact");
              String contact=s.nextLine();
              Patient patient=new Patient(id,name,contact);
              pList.Insert(patient);
          }
          else if(choice.equals("3")){
              dList.PrintData();
          }
          else if(choice.equals("4")){
              pList.PrintData();
          }
          else if(choice.equals("5")){
              System.out.println("\nWelcome To CheckUp Menu \n");
              CheckUpList[] clist=new CheckUpList[dList.size()];
              for(int i=0;i<clist.length;i++){
                  clist[i]=new CheckUpList();
                  Doctor doctor=dList.getAtIndex(i);
                  System.out.println("\n\nEnter Patient for Doctor ");
                  System.out.println("Name      : "+doctor.getName());
                  System.out.println("Speciality      : "+doctor.getSpeciality());
                  System.out.println("Fees      : "+doctor.getFees());
                  
                  
                  System.out.println("All Patients : ");
                  pList.PrintData();
                  while(true){
                      System.out.println("Enter Patient ID or type null to STOP");
                      String id=s.nextLine();
                      if(id.equals("null")){
                          break;
                      }
                      System.out.println("Priority  3 for Emergency  2 for Intermediate  any other key for normal");
                      String prio=s.nextLine();
                      int p=i;
                      if(prio.equals("3")){
                          p=3;
                      }else if(prio.equals("2")){
                          p=2;
                      }
                      Patient patient=pList.searchByID(id);
                      if(patient==null){
                          System.out.println("\nInvalid Patient ID : \n");
                      }else{
                          CheckUp cup=new CheckUp(doctor,patient,p,"",""+java.util.Calendar.getInstance().getTime().toString());
                          clist[i].Enqueue(cup);
                      }
                  }
              }
              for(int i=0;i<clist.length;i++){
                  System.out.println("\n\n Patient "+(i+1)+" In Queue For Doctor "+dList.getAtIndex(i).getName());
                  for(int j=0;j<clist[i].size();j++){
                      System.out.println("Enter Recommendation For Patient : "+clist[i].getPatient(j));
                      String rec=s.nextLine();
                      clist[i].addRecomendation(j, rec); 
                  }
              }
          }
      }
    }
    public static void MainMenu(){
        System.out.println("\n\n ||     *****   HMS  *****      ||");
        System.out.println("        || Main Menu ||");
        System.out.println("\nEnter 1 for Insert New Doctor");
        System.out.println("Enter 2 for Insert Patient  ");
        System.out.println("\nEnter 3 for Print All Doctor");
        System.out.println("Enter 4 for Print All Patient  ");
        System.out.println("Enter 5 for CheckUp Menu");
        System.out.println("Enter 0 for EXIT  ");
    }
    
}
