x = 10
print(type(x))
def my_func():
    global x
    return type(x)
# Basic Lambda Function
add = lambda a, b: a+b
print(add(12, 89))

# Lambda function with map
numbers = [32,34,3534,645,765]
print(numbers[-1]), print(numbers[-2])
squared = list(map(lambda num : num ** 2, numbers))
print("INFO :: Square of above list: ", squared)

# Lambda function with filter
even_numbers = list(filter(lambda x: x % 2 == 0, numbers))
print("INFO :: Even numbers in above list: ", even_numbers)

# fibbonacci series
a, b = 0, 1
for i in range(10):
    print(a, end=" ")
    a, b = b, a+b
print("________________")
# def fibbonacci(n):
#     if n <= 0:
#         return []
#     elif n == 1:
#         return [0]
#     elif n == 2:
#         return [0,1]
#     else:
#         fib_series = fibbonacci(n - 1)
#         fib_series.append(fib_series[-1] + fib_series[-2])
#         return fib_series
#
# n = 10
# fibbonacci(n)

###################################################################################
def fib(n):
    if n <=1 :
        return n
    else:
        return (fib(n-1) + fib(n-2))
n_terms = 10
for i in range(n_terms):
    print(fib(i), end=" ")
print("============")
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)
print(factorial(10))

number_list = [2,4,65,7,82,8,9]
list_lambda = list(map(lambda x: x**2, number_list))
print(list_lambda)