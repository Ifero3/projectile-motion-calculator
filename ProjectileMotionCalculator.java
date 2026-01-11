import java.util.*;

public class ProjectileMotionCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Projectile Motion Calculator ===");

        boolean again = true;
        while (again) {
            double v0 = readDouble(sc, "Initial speed v0 (m/s): ", 0.0001, 1e9);
            double thetaDeg = readDouble(sc, "Launch angle theta (degrees 0-90): ", 0, 90);
            double h0 = readDouble(sc, "Initial height h0 (m >= 0): ", 0, 1e9);

            System.out.print("Gravity g (press Enter for 9.81): ");
            String gLine = sc.nextLine().trim();
            double g = gLine.isEmpty() ? 9.81 : Double.parseDouble(gLine);

            runAnalysis(v0, thetaDeg, h0, g);

            boolean sim = readYesNo(sc, "\nShow simulation table? (y/n): ");
            if (sim) {
                double dt = readDouble(sc, "Time step dt (e.g. 0.1): ", 0.0001, 10);
                simulate(v0, thetaDeg, h0, g, dt);
            }

            again = readYesNo(sc, "\nRun another case? (y/n): ");
            System.out.println();
        }

        System.out.println("Goodbye!");
        sc.close();
    }

    private static void runAnalysis(double v0, double thetaDeg, double h0, double g) {
        double theta = Math.toRadians(thetaDeg);
        double v0x = v0 * Math.cos(theta);
        double v0y = v0 * Math.sin(theta);

        // Solve y(t) = h0 + v0y t - 0.5 g t^2 = 0
        double a = 0.5 * g;
        double b = -v0y;
        double c = -h0;

        double T = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double tPeak = v0y / g;
        double hMax = h0 + (v0y * v0y) / (2 * g);
        double range = v0x * T;

        System.out.println("\n=== Analytical Results ===");
        System.out.printf(Locale.US, "Flight time T: %.3f s%n", T);
        System.out.printf(Locale.US, "Time to peak: %.3f s%n", tPeak);
        System.out.printf(Locale.US, "Max height: %.3f m%n", hMax);
        System.out.printf(Locale.US, "Range: %.3f m%n", range);
    }

    private static void simulate(double v0, double thetaDeg, double h0, double g, double dt) {
        double theta = Math.toRadians(thetaDeg);
        double v0x = v0 * Math.cos(theta);
        double v0y = v0 * Math.sin(theta);

        System.out.println("\n t(s)\t x(m)\t y(m)\t vx\t vy");
        double t = 0;

        while (true) {
            double x = v0x * t;
            double y = h0 + v0y * t - 0.5 * g * t * t;
            double vx = v0x;
            double vy = v0y - g * t;

            if (y < 0) {
                y = 0;
                System.out.printf(Locale.US, "%.2f\t %.2f\t %.2f\t %.2f\t %.2f%n",
                        t, x, y, vx, vy);
                break;
            }

            System.out.printf(Locale.US, "%.2f\t %.2f\t %.2f\t %.2f\t %.2f%n",
                    t, x, y, vx, vy);

            t += dt;
        }
    }

    private static double readDouble(Scanner sc, String prompt, double lo, double hi) {
        while (true) {
            System.out.print(prompt);
            try {
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v < lo || v > hi) {
                    System.out.println("Out of range.");
                } else return v;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    private static boolean readYesNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("y") || s.equals("yes")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            System.out.println("Enter y or n.");
        }
    }
}
