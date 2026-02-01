person = {"name": "Aditya", "age": 26, "city": "Mumbai"}

for key in person:
    print(key, person[key])
print("###################")
for key, value in person.items():
    print(key, value)
for key, value in person.items():
    print(person[key], end=" ")