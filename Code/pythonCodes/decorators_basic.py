def my_decorator_method(func):
    def wrapper():
        print("Something is wrapped upwards.")
        func()
        print("Something is wrapped downwards.")

    return wrapper


@my_decorator_method
def say_hello():
    print(f"HELLO, ADITYA!!")


say_hello()
