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
