numbers = [12, 4234, 432, 43234,56]
second_max_index = len(numbers) - 2
print(second_max_index)
# num = 0
# for i in range(second_max_index - 1):
#     if numbers[i] > numbers[i - 1]:
#         num = numbers[i]
# max = num
# print(max)
sorted_numbers = sorted(numbers)
print(sorted_numbers)
numbers.sort()
print(numbers[second_max_index])

# str = "Aditya"
# list_str = list(str)
# reverse_str = list_str[::-1]
# list_str.reverse()

#
# print(list_str)
# print("".join(list_str))
# print("".join(reverse_str))


