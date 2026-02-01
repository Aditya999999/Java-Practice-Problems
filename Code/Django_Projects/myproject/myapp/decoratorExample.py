def my_decorator(func):
    def wrapper():
        print("Do something here upside.......")
        func()
        print("Do something here bottomside........")
    return wrapper

@my_decorator
def say_hello():
    print("Hello , Aditya")

say_hello()