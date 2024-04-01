package org.example;
import java.util.Scanner;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice.";
    private static final String LOGIN_FAILED_MESSAGE = "Login failed.";
    private static final String CHECK_CREDENTIALS_MESSAGE = "Please check your credentials.";

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Application app = new Application();
        Scanner scanner = new Scanner(System.in);
        boolean running = true; // Control variable to manage loop execution

        while (running) {
            logger.info("Welcome to Event Planner System");

            logger.info("1- Admin");
            logger.info("2- Service Provider");
            logger.info("3- User");
            logger.info("Enter Number 1/2/3 or 0 to exit:");

            int choice = -1; // Default to an invalid option
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                // Clear buffer
                scanner.nextLine();
            } else {
                // Consume invalid input
                scanner.next();
            }

            // Use a single 'continue' to restart the loop for invalid input
            if (choice < 0 || choice > 3) {
                logger.info(INVALID_CHOICE_MESSAGE + " Please try again.");
                continue; // Skips the rest of the loop iteration and starts at the beginning
            }

            // Handle valid options without 'break' or 'continue'
            if (choice == 1) {
                loginAdmin(scanner, app);
            } else if (choice == 2) {
                loginServiceProvider(scanner, app);
            } else if (choice == 3) {
                loginUserOrSignup(scanner, app);
            } else if (choice == 0) {
                running = false;
            }
        }

        logger.info("Exiting the Event Planner System. Goodbye!");
        scanner.close();
    }



    private static void loginAdmin(Scanner scanner, Application app) {
        logger.info("Enter admin username: ");
        String username = scanner.next();
        logger.info("Enter admin password: ");
        String password = scanner.next();

        Admin admin = app.checkAdmin(username, password);
        if (admin != null) {
            logger.info("Login successful.");
            adminMenu(scanner, admin);
        } else {
            logger.info(LOGIN_FAILED_MESSAGE+CHECK_CREDENTIALS_MESSAGE);
        }
    }

    private static void loginServiceProvider(Scanner scanner, Application app) {
       logger.info("Enter service provider username: ");
        String username = scanner.next();
        logger.info("Enter service provider password: ");
        String password = scanner.next();

        ServiceProvider serviceProvider = app.checkServiceProvider(username, password);
        if(serviceProvider != null) {
            logger.info("Service Provider login successful.");
            serviceProviderMenu(scanner, serviceProvider); // Service Provider operations menu
        } else {
            logger.info(LOGIN_FAILED_MESSAGE+CHECK_CREDENTIALS_MESSAGE);
        }
    }

    private static void loginUserOrSignup(Scanner scanner, Application app) {
        // Assuming you have methods for login and signup already implemented
        logger.info("1. Login");
        logger.info("2. Sign Up");
        logger.info("Enter your choice: ");
        int choice = scanner.nextInt();
        User user;
        if (choice == 1) {
            user = loginUser(scanner, app); // Implement this method
        } else {
            user = signupUser(scanner, app); // Implement this method
        }

        if (user != null) {
            userMenu(scanner, user);
        }
    }

    private static void adminMenu(Scanner scanner, Admin admin) {
        while (true) {
            logger.info("\nAdmin Menu:");
            logger.info("1. Add ServiceProvider");
            logger.info("2. Delete ServiceProvider");
            logger.info("3. Print ServiceProviders");
            logger.info("4. Print Users");
            logger.info("5. Print Events");
            logger.info("6. Logout");
            logger.info("Choose an action:");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    addServiceProvider(scanner, admin);
                    break;
                case 2:
                    deleteServiceProvider(scanner, admin);
                    break;
                case 3:
                    String ss=admin.printServiceProviders();
                    logger.info(ss);
                    break;
                case 4:
                    String abc=admin.printUsers();

                    logger.info(abc);
                    break;
                case 5:
                    String ab=admin.printEvents();
                    logger.info(ab);
                    break;
                case 6:
                    admin.setLogged(false);
                    return;
                default:
                    logger.info(INVALID_CHOICE_MESSAGE);
                    break;
            }
        }
    }

    private static void addServiceProvider(Scanner scanner, Admin admin) {
        logger.info("Adding a new Service Provider:");

        // Clear the scanner buffer and prompt for service provider details
        scanner.nextLine(); // Necessary to catch any leftover newline characters

        logger.info("Enter service provider's username: ");
        String username = scanner.nextLine();

        logger.info("Enter service provider's password: ");
        String password = scanner.nextLine();

        logger.info("Enter service provider's phone number: ");
        String phoneNumber = scanner.nextLine();

        logger.info("Enter service provider's email: ");
        String email = scanner.nextLine();

        String result = admin.addServiceProvider(username, password, phoneNumber, email);
        logger.info(result); // Log the result of the operation
    }


    private static void deleteServiceProvider(Scanner scanner, Admin admin) {
        logger.info("Deleting a Service Provider:");

        // Clear the scanner buffer and prompt for service provider's details
        scanner.nextLine(); // This is to catch any leftover newline characters

        logger.info("Enter service provider's username: ");
        String username = scanner.nextLine();

        logger.info("Enter service provider's phone number: ");
        String phoneNumber = scanner.nextLine();

        // Call the Admin method to delete the specified ServiceProvider
        String result = admin.deleteServiceProvider(username, phoneNumber);

        // Log the outcome of the deletion attempt
        if (result == null) {
            logger.info("No matching service provider found.");
        } else {
            logger.info(result); // Log the success message
        }
    }


    private static void serviceProviderMenu(Scanner scanner, ServiceProvider serviceProvider) {
        while (true) {
            logger.info("\nService Provider Menu:");
            logger.info("1. Add Package");
            logger.info("2. Remove Package");
            logger.info("3. Update Package");
            logger.info("4. View My Packages");
            logger.info("5. View My Tasks");
            logger.info("6. View Messages");
            logger.info("7. Logout");
            logger.info("Choose an action: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    addPackage(scanner, serviceProvider);
                    break;
                case 2:
                    removePackage(scanner, serviceProvider);
                    break;
                case 3:
                    updatePackage(scanner, serviceProvider);
                    break;
                case 4:
                    // Since these are likely returning String for display, log them with logger.info
                    String ss=serviceProvider.showMyPackeges(serviceProvider.getUsername());
                    logger.info(ss);
                    break;
                case 5:
                    String ab=serviceProvider.showMyTasks(serviceProvider.getUsername());
                    logger.info(ab);
                    break;
                case 6:
                    String abc=serviceProvider.showMessages(serviceProvider.getUsername());
                    logger.info(abc);
                    break;
                case 7:
                    serviceProvider.setLogged(false); // Service Provider logs out
                    return; // Exit the service provider menu
                default:
                    logger.info(INVALID_CHOICE_MESSAGE);
                    break;
            }
        }
    }

    private static void addPackage(Scanner scanner, ServiceProvider serviceProvider) {
        logger.info("Adding a new package:");

        // Assuming package ID is auto-generated or unique, you might not need to ask for it
        // But if you decide to allow service providers to set package ID, ensure uniqueness
        logger.info("Enter package ID: ");
        int packageId = scanner.nextInt();

        logger.info("Enter package price: ");
        int price = scanner.nextInt();

        logger.info("Enter package capacity: ");
        int capacity = scanner.nextInt();

        scanner.nextLine(); // Consume newline left-over

        logger.info("Enter package location: ");
        String location = scanner.nextLine();

        logger.info("Enter place name: ");
        String placeName = scanner.nextLine();

        logger.info("Enter package services: ");
        String services = scanner.nextLine();

        String serviceProviderName = serviceProvider.getUsername();


        String result = serviceProvider.addPackage(packageId, price, capacity, location, placeName, services, serviceProviderName);
        logger.info(result);
    }



    private static void removePackage(Scanner scanner, ServiceProvider serviceProvider) {
        logger.info("Removing a package:");
        logger.info("Enter the package ID to remove: ");
        int packageId = scanner.nextInt();


        String result = serviceProvider.removePackage(packageId);
        logger.info(result);
    }


    private static void updatePackage(Scanner scanner, ServiceProvider serviceProvider) {
        logger.info("Updating a package:");
        logger.info("Enter the package ID to update: ");
        int packageId = scanner.nextInt();

        // Display update options
        logger.info("What detail would you like to update?");
        logger.info("1. Price");
        logger.info("2. Capacity");
        logger.info("3. Location");
        logger.info("4. Place Name");
        logger.info("5. Description");
        logger.info("6. Service Provider Name");
        logger.info("Choose an option (1-6): ");
        int updateType = scanner.nextInt();

        scanner.nextLine(); // Consume the leftover newline

        logger.info("Enter the new value: ");
        String newValue = scanner.nextLine();

        // Call the ServiceProvider method to update the specified package
        String result = serviceProvider.updatePackage(packageId, updateType, newValue);
        logger.info(result); // Log the result of the operation
    }


    private static void userMenu(Scanner scanner, User user) {
        while (true) {
            logger.info("\nUser Menu:");
            logger.info("1. Create Event");
            logger.info("2. View My Events");
            logger.info("3. Delete Event");
            logger.info("4. Logout");
            logger.info("Choose an action: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    createEvent(scanner, user);
                    break;
                case 2:
                    // Assuming showMyEvents logs or returns a string to be logged
                    user.showMyEvents(user.getUsername());
                    break;
                case 3:
                    deleteEvent(scanner, user);
                    break;
                case 4:
                    user.setLogged(false); // User logs out
                    logger.info("User logged out successfully.");
                    return; // Exit the user menu
                default:
                    logger.info(INVALID_CHOICE_MESSAGE);
                    break;
            }
        }
    }


    private static User loginUser(Scanner scanner, Application app) {
        logger.info("Enter username: ");
        String username = scanner.next();
        logger.info("Enter password: ");
        String password = scanner.next();

        User user = app.checkUser(username, password);
        if (user != null) {
            logger.info("Login successful.");
            user.setLogged(true);
            return user;
        } else {
            logger.info(LOGIN_FAILED_MESSAGE+CHECK_CREDENTIALS_MESSAGE);
            return null;
        }
    }


    private static User signupUser(Scanner scanner, Application app) {
        logger.info("Sign Up:");
        scanner.nextLine(); // Consume newline left-over

        logger.info("Enter a username: ");
        String username = scanner.nextLine();

        logger.info("Enter a password: ");
        String password = scanner.nextLine();

        logger.info("Enter your email: ");
        String email = scanner.nextLine();

        logger.info("Enter your phone number: ");
        String phoneNum = scanner.nextLine();




        app.registerUser(username,password,email,phoneNum);
        User newUser = app.checkUser(username,password);
        Application.users.add(newUser);
        newUser.setLogged(true);

        logger.info("Registration successful.");
        return newUser;
    }

    private static void createEvent(Scanner scanner, User user) {
        logger.info("Creating a new event:");

        scanner.nextLine(); // Consume any leftover newline characters

        logger.info("Enter event title: ");
        String eventTitle = scanner.nextLine();

        logger.info("Enter your budget: ");
        int budget = scanner.nextInt();

        logger.info("Enter location: ");
        scanner.nextLine(); // Consume newline
        String location = scanner.nextLine();

        logger.info("Enter number of invitees: ");
        int numInvitees = scanner.nextInt();

        logger.info("Enter date (e.g., YYYY-MM-DD): ");
        scanner.nextLine(); // Consume newline
        String date = scanner.nextLine();

        logger.info("Enter start time (HH:MM): ");
        String startTime = scanner.nextLine();

        logger.info("Enter end time (HH:MM): ");
        String endTime = scanner.nextLine();

        String result = user.creatEvent(eventTitle, budget, location, numInvitees, date, startTime, endTime);
        logger.info(result); // Log the result of the operation

        if (!result.startsWith("Please")) { // If the filtering does not ask for package selection
            return;
        }

        // Assuming package selection is needed after the initial event creation
        logger.info("Enter the package ID you want to approve: ");
        int packageId = scanner.nextInt();
        String packageChoiceResult = user.choosePackage(packageId);
        logger.info(packageChoiceResult); // Log the result of package selection
    }



    private static void deleteEvent(Scanner scanner, User user) {
       logger.info("Deleting an event:");
        scanner.nextLine(); // Consume any leftover newline characters

        logger.info("Enter the event title you want to delete: ");
        String eventTitle = scanner.nextLine();

        // This logic assumes you modify the User class to include a deleteEvent method
        // which handles event deletion based on the title or another unique identifier.
        user.deleteEvent(eventTitle);
    }

}