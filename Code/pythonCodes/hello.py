from enum import Enum


class AppConfig(Enum):
    Aditya = {
        "Address": "Ayodhya",
        "Phone": "9876654321"
    }
    Anamaya = {
        "Address": "Banaras",
        "Phone": "987654321"
    }


def load_config(name):
    config = AppConfig[name].value
    print(config["Address"])


def main():
    load_config("Aditya")


if __name__ == '__main__':
    main()
