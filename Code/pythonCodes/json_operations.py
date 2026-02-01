import json

data = {
    "name": "Aditya Dubey",
    "age": 24,
    "Address": "Ayodhya"
}
# Writing into json file
with open('test_json.json', 'w') as file:
    json.dump(data, file)

# Reading from the json
with open('test_json.json', 'r') as file:
    data = json.load(file)
    print(data)