fruits = ["apple", "banana", "cherry"]
numbers = [1, 2, 3, 4, 5]
print("This is a backslash: \\")

name = ("aditya", "dubey")
print(name)

name_list = list(name)
name_list.append("Ayodhya")
print(name_list)

name = tuple(name_list)
print(name)

sliced_fruit = fruits[::-1]
print(sliced_fruit)

numbers_list = [1,2,3,4,5]
print(numbers_list)
squared = list(map(lambda x: x ** 2, numbers_list))
print("INFO :: Using Lambda function: ", squared)
squared_numbers_list = [x ** 2 for x in numbers_list]
print("INFO :: Using list comprehension: ",squared_numbers_list)
