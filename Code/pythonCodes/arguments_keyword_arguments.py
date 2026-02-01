from functools import reduce
from collections import Counter
def test1(*args):
    for arg in args:
        print(arg)


test1(1, 23, 54, 65, 656345)


def test2(**kwargs):
    for k, v in kwargs.items():
        print(f"Key:{k}, Value:{v}", end=" ")
test2(a=1, b=2, c=3)

print("------------")
# Lambda Functions
numbers = [3,4,6,7,87]
square = list(map(lambda x: x ** 2, numbers))
print(square)
cube = list(map(lambda x : x ** 3, numbers))
print(cube)
# using reduce
sum_sqaure_numbers = reduce(lambda x, y : x + y, map(lambda x : x ** 2, numbers))
print("INFO :: Using reduce function: ", sum_sqaure_numbers)
print("-----------------")

names = ["Aditya", "Dubey", "Ayodhya"]
sorted_names = sorted(names, key=lambda x: len(x))
print(sorted_names)

str = "Aditya"
list_str = list(str.upper())
char_Count = Counter(list_str)
print(char_Count)