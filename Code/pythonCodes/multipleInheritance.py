class Animal:
    def __init__(self, name):
        self.name = name


class Mammal(Animal):
    def __init__(self, name):
        super().__init__(name)

    def feed_milk(self):
        return f"{self.name} is feeding milk.."


class Dog(Mammal):
    def speak(self):
        return f"{self.name} says woof.."


tango = Dog("Tango")
print(tango.speak())
print(tango.feed_milk())
