class Person:
    def __init__(self, name, age):
        self.__name = name
        self.__age = age

    def __display_info(self):
        print(f"Name: {self.__name}, Age: {self.__age}")

    def greet(self):
        self.__display_info()


person = Person("Aditya", 24)
person.greet()
