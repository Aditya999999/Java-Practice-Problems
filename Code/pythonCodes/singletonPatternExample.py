class SinglePattern:
    _instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super().__new__(cls, *args, **kwargs)
        return cls._instance


obj1 = SinglePattern()
obj2 = SinglePattern()
print(obj2 is obj1)
