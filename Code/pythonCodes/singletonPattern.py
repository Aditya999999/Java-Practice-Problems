class Singleton:
    _instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super().__new__(cls, *args, **kwargs)
        return cls._instance


s1 = Singleton()
s2 = Singleton()
print(s1 is s2)
print(s1 == s2)
