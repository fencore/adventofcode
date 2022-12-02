import math

inputs = []
fuelneeded = 0

with open ('day01input.txt', 'r') as infile:
    inputs = [current_input.rstrip() for current_input in infile.readlines()]

for item in inputs:
    module_fuel = math.floor(int(item) / 3) - 2
    fuelneeded += module_fuel

print(fuelneeded)
