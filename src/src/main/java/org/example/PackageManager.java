package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PackageManager {

    private List<Packege> packages;

    public PackageManager() {
        this.packages = new ArrayList<>();
    }

    public String addPackage(Packege pkg) {
        this.packages.add(pkg);
        return "package added successfully";
    }

    public String removePackage(int packageId) {
        for (Packege pkg : packages) {
            if (pkg.getId() == packageId) {
                packages.remove(pkg);
                return "package deleted successfully";
            }
        }
        return "package not found";
    }

    public String updatePackage(int id) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input
        boolean updated = false;

        for (Packege pkg : packages) {
            if (pkg.getId() == id) {
                while (true) {
                    System.out.println("Enter the type you want to modify");
                    System.out.println("1. price\n2. capacity\n3. location\n4. place name" +
                            "\n5. services\n6. service provider name\n7. exit");

                    int key = Integer.parseInt(scanner.nextLine()); // Read the choice as an integer

                    if (key == 7) {
                        break; // Exit the loop
                    }

                    System.out.println("Enter the new value:");
                    String newValue = scanner.nextLine(); // Read the new value from user

                    switch (key) {
                        case 1:
                            pkg.setPrice(Integer.parseInt(newValue));
                            updated = true;
                            break;
                        case 2:
                            pkg.setCapacity(Integer.parseInt(newValue));
                            updated = true;
                            break;
                        case 3:
                            pkg.setLocation(newValue);
                            updated = true;
                            break;
                        case 4:
                            pkg.setPlace_name(newValue);
                            updated = true;
                            break;
                        case 5:
                            pkg.setServices_des(newValue);
                            updated = true;
                            break;
                        case 6:
                            pkg.setServiceProvider_name(newValue);
                            updated = true;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                }
                return updated ? "Package updated successfully." : "No updates made.";
            }
        }
        return "Package not found.";
    }



    public Packege getPackage(int packageId) {
        for (Packege pkg : packages) {
            if (pkg.getId() == packageId) {
                return pkg;
            }
        }
        return null;
    }

}
