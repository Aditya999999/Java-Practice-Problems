class CustomException(Exception):
    def __init__(self, message, code):
        self.message = message
        self.code = code

    def __str__(self):
        return f"Message: {self.message}, Code: {self.code}"


try:
    raise CustomException("Bad Request", 401)
except CustomException as ce:
    print(f"{ce}")

finally:
    print("Hi Aditya!!")
