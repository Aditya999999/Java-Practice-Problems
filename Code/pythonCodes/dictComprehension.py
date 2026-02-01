from itertools import repeat
dict_comprehension = {x: x ** 2 for x in range(1, 5)}
print(dict_comprehension)

numbers = [1, 2, 3, 5, 6, 7, 7]
square_list = list(map(lambda x: x ** 2, numbers))
print(square_list)


def greet(name, message="Hello"):
    return f"{message} {name}"


print(greet("Aditya"))
print(greet("Ishika", "Hii"))

for i in repeat("Hello", 5):
    print(i, end=" ")