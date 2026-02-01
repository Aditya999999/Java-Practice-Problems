numbers = [1,2,3,4,5,6,7,89,100]

generators = (x**2 for x in numbers)
print(generators)
for generator in generators:
    print(generator, end=" ")