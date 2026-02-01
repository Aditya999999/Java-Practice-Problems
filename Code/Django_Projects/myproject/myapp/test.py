import string

list_example = [1,2,3,4,5,7]
sq_list = [x ** 2 for x in list_example]
print("sq_list : ", sq_list)
# print(2 in list_example)
# print(6 in list_example)
squared_list = list(map(lambda x: x ** 2, list_example))
print("squared_list",squared_list)

even_number_list = list(filter(lambda  x : x % 2 == 0, list_example))
print("even_number_list: ",even_number_list)

x: string = "abc"
print(type(x))

my_list = {
    1 : "Aditya",
    2 : "Dubey"
   }
print (my_list)
for k in my_list:
    print(k, my_list[k])

for key, value in my_list.items():
    print(key, value)

# dict comprehension
dictionary = {x : x ** 2 for x in range(1,5)}
print(dictionary)


from collections import namedtuple

point = namedtuple('Points', ['x', 'y'])
p = point(11, 22)
print(p.x, p.y)