def print_args(*args):
    for i in args:
        print(i)

print_args(1,23,5,6)


def print_kwargs(**kwargs):
    for key, value in kwargs.items():
        print(f'key : {key}, value : {value}')

print_kwargs(a = 10, b = 20, c = 30)

names = ["Aditya", "Bob", "Charlie"]
sorted_names = sorted(names, key=lambda x: len(x))
print(sorted_names)
