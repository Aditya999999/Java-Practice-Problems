n = int(input("Enter the number: \n"))
print("Number you entered", n)
factorial=1
print(factorial)
for i in range(1, n + 1):
    factorial = factorial * i

print(f"The factorial of the number you entered is {factorial}")