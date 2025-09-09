import java.util.Scanner;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double f) {
        return celsiusToKelvin(fahrenheitToCelsius(f));
    }

    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return celsiusToFahrenheit(kelvinToCelsius(k));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n=== Temperature Converter ===");
            System.out.println("1. Celsius to Fahrenheit & Kelvin");
            System.out.println("2. Fahrenheit to Celsius & Kelvin");
            System.out.println("3. Kelvin to Celsius & Fahrenheit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for using the converter. Goodbye!");
                break;
            }

            double temperature;
            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    temperature = sc.nextDouble();
                    System.out.printf("Fahrenheit: %.2f°F%n", celsiusToFahrenheit(temperature));
                    System.out.printf("Kelvin: %.2fK%n", celsiusToKelvin(temperature));
                    break;

                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    temperature = sc.nextDouble();
                    System.out.printf("Celsius: %.2f°C%n", fahrenheitToCelsius(temperature));
                    System.out.printf("Kelvin: %.2fK%n", fahrenheitToKelvin(temperature));
                    break;

                case 3:
                    System.out.print("Enter temperature in Kelvin: ");
                    temperature = sc.nextDouble();
                    if (temperature < 0) {
                        System.out.println("Error: Kelvin cannot be negative!");
                        break;
                    }
                    System.out.printf("Celsius: %.2f°C%n", kelvinToCelsius(temperature));
                    System.out.printf("Fahrenheit: %.2f°F%n", kelvinToFahrenheit(temperature));
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }
        }

        sc.close();
    }
}
