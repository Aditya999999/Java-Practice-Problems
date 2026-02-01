from abc import ABC, abstractmethod


class Animal(ABC):
    @abstractmethod
    def sound(self, name):
        print(f"{name} Barks")

    def eats(self):
        return "eat something.."


class Dog(Animal):
    def sound(self, name):
        print(f"{name} barks..")


dog = Dog()
dog.sound("Tango")
print(dog.eats())
