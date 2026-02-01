class Animal:
    def __init__(self) -> None:
        super().__init__()

    def speak(self):
        raise NotImplementedError("Subclass must implement abstract methods")

class Dog(Animal):
    def speak(self):
        return "Woof!!"

class Cat(Animal):
    def speak(self):
        return "Meow!!"

animals = [Dog(), Cat()]
for animal in animals:
    print(animal.speak())