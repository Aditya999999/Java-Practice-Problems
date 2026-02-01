import os
from pathlib import Path


def fileCreation():
    try:

        file_name = "created_file.txt"
        file_path = "created_dir"

        os.makedirs(file_path, exist_ok=True)
        with open(Path(file_path) / file_name, "w") as file:
            print("Hello, \n Aditya!!", file=file)
        print("File successfully created")
    except FileNotFoundError as f:
        print("Exception occurred -->", f)

fileCreation()

# file = open(Path("created_dir") / "created_file.txt", 'r')
# content = file.read()
# print(content)