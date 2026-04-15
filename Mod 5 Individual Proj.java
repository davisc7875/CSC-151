import java.util.*;
import java.io.*;

/**
 * Concrete Pad Estimating Application
 * Helps Jim's construction business 
 * calculate concrete pad estimates
 */

class ConcreteEstimatorApp {
    
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ConcreteEstimate> estimates = new ArrayList<ConcreteEstimate>();
    
    public static void main(String[] args) {
        System.out.println("Welcome to Concrete Pad Estimator");
        System.out.println("==================================");
        
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Create New Estimate");
            System.out.println("2. View All Estimates");
            System.out.println("3. Save to File");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            if (choice == 1) {
                createEstimate();
            } else if (choice == 2) {
                viewEstimates();
            } else if (choice == 3) {
                saveToCSV();
            } else if (choice == 4) {
                running = false;
                System.out.println("Goodbye!");
            }
        }
        scanner.close();
    }
    
    public static void createEstimate() {
        System.out.println("\n--- Create New Estimate ---");
        
        // Get project info
        System.out.print("Project name: ");
        String projectName = scanner.nextLine();
        
        System.out.print("Location: ");
        String location = scanner.nextLine();
        
        // Get dimensions
        System.out.print("Length (feet): ");
        double length = scanner.nextDouble();
        
        System.out.print("Width (feet): ");
        double width = scanner.nextDouble();
        
        System.out.print("Thickness (inches): ");
        double thickness = scanner.nextDouble();
        
        // Get concrete price
        System.out.print("Price per cubic yard: $");
        double pricePerYard = scanner.nextDouble();
        
        // Get labor info
        System.out.print("Number of employees: ");
        int employees = scanner.nextInt();
        
        System.out.print("Hours per employee: ");
        double hoursPerEmployee = scanner.nextDouble();
        
        System.out.print("Hourly rate: $");
        double hourlyRate = scanner.nextDouble();
        
        // Get waste percentage
        System.out.print("Waste percentage (e.g., 5 for 5%): ");
        double wastePercent = scanner.nextDouble();
        
        scanner.nextLine(); // Clear buffer
        
        // Calculate values
        double area = length * width;
        double volumeCubicFeet = area * (thickness / 12.0);
        double volumeCubicYards = volumeCubicFeet / 27.0;
        double adjustedVolume = volumeCubicYards * (1 + wastePercent / 100.0);
        
        double concreteCost = adjustedVolume * pricePerYard;
        double totalLaborHours = employees * hoursPerEmployee;
        double laborCost = totalLaborHours * hourlyRate;
        double totalCost = concreteCost + laborCost;
        
        // Create and store estimate
        ConcreteEstimate estimate = new ConcreteEstimate(
            projectName, location, length, width, thickness, 
            area, volumeCubicYards, adjustedVolume, 
            concreteCost, employees, hoursPerEmployee, 
            totalLaborHours, laborCost, totalCost
        );
        
        estimates.add(estimate);
        
        // Display summary
        System.out.println("\n--- Estimate Summary ---");
        System.out.println("Project: " + projectName);
        System.out.println("Location: " + location);
        System.out.println("Area: " + area + " sq ft");
        System.out.println("Concrete Volume: " + String.format("%.2f", adjustedVolume) + " cubic yards");
        System.out.println("Concrete Cost: $" + String.format("%.2f", concreteCost));
        System.out.println("Labor Hours: " + String.format("%.2f", totalLaborHours));
        System.out.println("Labor Cost: $" + String.format("%.2f", laborCost));
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
    }
    
    public static void viewEstimates() {
        if (estimates.isEmpty()) {
            System.out.println("\nNo estimates yet.");
            return;
        }
        
        System.out.println("\n--- All Estimates ---");
        for (int i = 0; i < estimates.size(); i++) {
            ConcreteEstimate est = estimates.get(i);
            System.out.println((i + 1) + ". " + est.projectName + " - $" + 
                String.format("%.2f", est.totalCost));
        }
    }
    
    public static void saveToCSV() {
        try {
            FileWriter fw = new FileWriter("estimates.csv");
            fw.write("ProjectName,Location,Length,Width,Thickness,Area,Volume,ConcreteCost,LaborHours,LaborCost,TotalCost\n");
            
            for (ConcreteEstimate est : estimates) {
                fw.write(est.projectName + "," + est.location + "," + 
                    est.length + "," + est.width + "," + est.thickness + "," +
                    est.area + "," + est.adjustedVolume + "," + est.concreteCost + "," +
                    est.totalLaborHours + "," + est.laborCost + "," + est.totalCost + "\n");
            }
            fw.close();
            System.out.println("Saved to estimates.csv");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

// Simple data class to store estimate info
class ConcreteEstimate {
    String projectName;
    String location;
    double length;
    double width;
    double thickness;
    double area;
    double volumeCubicYards;
    double adjustedVolume;
    double concreteCost;
    int employees;
    double hoursPerEmployee;
    double totalLaborHours;
    double laborCost;
    double totalCost;
    
    ConcreteEstimate(String projectName, String location, double length, double width,
                     double thickness, double area, double volumeCubicYards, 
                     double adjustedVolume, double concreteCost, int employees,
                     double hoursPerEmployee, double totalLaborHours, 
                     double laborCost, double totalCost) {
        this.projectName = projectName;
        this.location = location;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.area = area;
        this.volumeCubicYards = volumeCubicYards;
        this.adjustedVolume = adjustedVolume;
        this.concreteCost = concreteCost;
        this.employees = employees;
        this.hoursPerEmployee = hoursPerEmployee;
        this.totalLaborHours = totalLaborHours;
        this.laborCost = laborCost;
        this.totalCost = totalCost;
    }
}
