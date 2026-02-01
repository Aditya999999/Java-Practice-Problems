class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def greet(self):
        print(f"Hello, My name is {self.name} and i am {self.age} years old")


# Creating the object
person1 = Person("Aditya", 25)
person1.greet()
