package org.example;

import java.util.ArrayList;
import java.util.List;

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

    public String updatePackage(int packageId, Packege updatedPackage) {
        for (Packege pkg : packages) {
            if (pkg.getId() == packageId) {
                pkg.setPrice(updatedPackage.getPrice());
                pkg.setCapacity(updatedPackage.getCapacity());
                pkg.setLocation(updatedPackage.getLocation());
                pkg.setPlace_name(updatedPackage.getPlace_name());
                pkg.setServices_des(updatedPackage.getServices_des());
                pkg.setServiceProvider_name(updatedPackage.getServicesProvider_name());
                return "package updated successfully";
            }
        }
        return "package not found";
    }



    public Packege getPackage(int packageId) {
        for (Packege pkg : packages) {
            if (pkg.getId() == packageId) {
                return pkg;
            }
        }
        return null; // or throw an exception depending on your error handling strategy
    }


}
