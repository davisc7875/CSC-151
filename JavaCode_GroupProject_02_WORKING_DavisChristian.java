/*
- St. Justice Youngblood
- Christian Davis
- Tristen Hoffarth
- Braden Johnson
- Nolan Pait
- 2/1/26 - 2/24/26
M3_JavaCode_GroupProject_02
*/
import java.io.*;
import javax.swing.JOptionPane;

public class NFLManagerM3 
{
    // Written by:[Braden Johnson] - This method creates the method that allows the CSV to be read from
   public static void readCSVByCategory(String fileName, String categoryFilter)
{
    try
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        String output = categoryFilter + " List\n";
        output += "-----------------------------------\n";

        // Skip header
        br.readLine();

        while ((line = br.readLine()) != null)
        {
            if(line.trim().isEmpty()) continue;

            String[] values = line.split(",");

            if(values.length >= 3)
            {
                String category = values[0].trim();
                String position = values[1].trim();
                String name = values[2].trim();

                if(category.equalsIgnoreCase(categoryFilter))
                {
                    output += "Position: " + position +
                              " | Name: " + name + "\n";
                }
            }
        }

        br.close();

        // Sends data to the popup window
        JOptionPane.showMessageDialog(null, output);

    }
    catch(IOException e)
    {
        JOptionPane.showMessageDialog(null,
                "Error reading file.");
        e.printStackTrace();
    }
}

  public static void main(String[] args)
{
    boolean running = true;

    while (running)
    {
        String menu =
                "Carolina Panthers Information\n" +
                "------------------------------\n" +
                "1. Coaches\n" +
                "2. Players\n" +
                "3. Support Staff\n" +
                "4. Medical Staff\n" +
                "5. Add Player\n" +
                "6. Exit\n";

        String choice = JOptionPane.showInputDialog(menu);

        if (choice == null)
        {
            running = false;
        }
        else
        {
            choice = choice.trim();
            // Writen by: Tristen Hoffarth - Modified the main method to read from the CSV file instead of hard coded data
            switch (choice)
            {
                case "1":
                    readCSVByCategory("data.csv", "Coach");
                    break;

                case "2":
                    readCSVByCategory("data.csv", "Player");
                    break;

                case "3":
                    readCSVByCategory("data.csv", "Front Office");
                    break;

                case "4":
                    readCSVByCategory("data.csv", "Medical");
                    break;

                
                // Written by: [Christian Davis & Nolan Pait] – This method adds people to the different categories on the list.
                case "5":
                    String category = JOptionPane.showInputDialog("Enter category:");
                    String position = JOptionPane.showInputDialog("Enter position:");
                    String name = JOptionPane.showInputDialog("Enter name:");

                    writeCSV("data.csv", category, position, name);

                    JOptionPane.showMessageDialog(null, "Player added!");
                    break;

                case "6":
                    running = false;
                    JOptionPane.showMessageDialog(null,
                            "Thanks for learning about the Carolina Panthers!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid choice. Please enter 1-6.");
            }
        }
    }
}
            // Part 5: Adding a Method To Write to CSV 
            // Written by: St. Justice Youngblood - This method writes to the CSV File
           public static void writeCSV(String fileName, String category, String position, String name)
            {
                try
                {
                    FileWriter fw = new FileWriter(fileName, true);
                    PrintWriter pw = new PrintWriter(fw);

                    pw.println(category + "," + position + "," + name);

                    pw.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error writing file.");
                    e.printStackTrace();
                }
            }
            //            

            public static class Coaches {

                static void showCoaches() {
                    String coachesMenu =
                        "Carolina Panthers Coaches\n" +
                        "--------------------------\n" +
                        "Head Coach: Dave Canales\n" +
                        "Offensive Coordinator: Brad Idzik\n" +
                        "Secondary Coach: Renaldo Hill\n" +
                        "Defensive Line: Todd Wash\n" +
                        "Running Backs: Bernie Parmalee\n" +
                        "Senior Defensive Assistant: \n" +
                        "Defensive Coordinator: Ejiro Evero\n";

                    JOptionPane.showMessageDialog(null, coachesMenu,
                            "Coaches", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            public static class Players {

                static void showPlayers(){
                    
                    String playersMenu =
                        "Key Carolina Panthers Players\n" +
                        "------------------------------\n" +
                        "Quarterback: Bryce Young\n" +
                        "Quarterback: Andy Dalton\n" +
                        "Wide Receiver: Brycen Tremayne\n" +
                        "Wide Receiver: David Moore\n" +
                        "Wide Receiver: Tetairoa McMillan\n" +
                        "Wide Receiver: Xavier Legette\n" +
                        "Wide Receiver: Jimmy Horn Jr.\n" +
                        "Wide Receiver: Jalen Coker\n" +
                        "Tight End: Tommy Tremble\n" +
                        "Tight End: James Mitchell\n" +
                        "Tight End: Mitchell Evans\n" +
                        "Defensive Tackle: Derrick Brown\n" +
                        "Defensive Tackle : Bobby Brown III\n" +
                        "Defensive Tackle : Cam Jackson\n";

                     JOptionPane.showMessageDialog(null, playersMenu,
                    "Players", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            public static class FrontOffice {
                
                static void showFrontOffice(){
                    String staffMenu =
                    "Carolina Panthers Front Office\n" +
                    "-------------------------------\n" +
                    "Chairman: David A. Tepper\n" +
                    "Chief Executive Officer: Kristi Coleman\n" +
                    "Chief Administrative Officer: Nicole Tepper\n" +
                    "Presient of Football Operations/General Manager: Dan Morgan\n";

        JOptionPane.showMessageDialog(null, staffMenu,
                "Support Staff", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            public static class MedicalStaff {
                static void showMedicalStaff() {
                    String medicalMenu =
                    "Carolina Panthers Athletic Trainers and Medical Staff\n" +
                    "------------------------------------------------------\n" +
                    "Head Athletic Trainer: Kevin King\n" +
                    "Assistant Athletic Trainer: Melissa Carter\n" +
                    "Team Physician: Dr. James Thompson\n" +
                    "Orthopedic Specialist: Dr. Ryan Mitchell\n" +
                    "Strength and Conditioning Coach: Mark Davis\n" +
                    "Physical Therapist: Sarah Collins\n" +
                    "Sports Nutritionist: Emily Roberts\n";

                JOptionPane.showMessageDialog(null, medicalMenu,
                        "Medical Staff", JOptionPane.INFORMATION_MESSAGE);
                }