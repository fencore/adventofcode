import math

inputs = []
fuelneeded = 0

with open ('day01input.txt', 'r') as infile:
    inputs = [current_input.rstrip() for current_input in infile.readlines()]

for item in inputs:
    working_mass = int(item)
    while working_mass > 0:
        module_fuel = math.floor(int(working_mass) / 3) - 2
        if module_fuel > 0:
            fuelneeded += module_fuel
            working_mass = module_fuel
        else:
            break

print(fuelneeded)
