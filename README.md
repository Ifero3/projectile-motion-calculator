# Projectile Motion Calculator (Java)

## What it does
A console-based Java program that calculates projectile motion parameters
based on user input, including flight time, maximum height, and range.

## Modeling / How it works
This program models projectile motion using kinematic equations:

x(t) = v0x · t  
y(t) = h0 + v0y · t − ½ g t²  

The flight time is calculated by solving y(t) = 0.
An optional simulation prints the motion step-by-step using a fixed time step.

## How to run
Compile:
`javac ProjectileMotionCalculator.java`

Run:
`java ProjectileMotionCalculator`

## What I learned
- translating physics equations into code
- mathematical modeling and simulation
- using loops and input validation for scientific programs

## Testing
The program was tested using standard physics cases.

Example test case:
- Initial speed v0 = 20 m/s
- Launch angle θ = 45°
- Initial height h0 = 0 m
- Gravity g = 9.81 m/s²

Expected results (approximate):
- Flight time ≈ 2.9 s
- Time to peak ≈ 1.4 s
- Maximum height ≈ 10.2 m
- Range ≈ 40.8 m

The computed outputs closely match analytical solutions from kinematics,
confirming the correctness of the model.
