# Basic List Comprehension:
squares = [x ** 2 for x in range(1,10)]
print(squares)

# List Comprehension with Condition:

# # Create a list of even numbers from 1 to 10
even_numbers = [x for x in range(1, 11) if x % 2 == 0]
print(even_numbers)


# Nested List Comprehension:
pairs = [(x, y) for x in range(1, 10) for y in 'abc']
print(pairs)