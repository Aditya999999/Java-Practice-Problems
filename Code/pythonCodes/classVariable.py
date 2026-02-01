class MyClass:
    class_variable = 0
    def __init__(self):
        MyClass.class_variable += 1

    @classmethod
    def get_class_variable(cls):
        return cls.class_variable

obj1 = MyClass()
obj2 = MyClass()
print(MyClass.get_class_variable())