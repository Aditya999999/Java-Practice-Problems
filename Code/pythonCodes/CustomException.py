class MyCustomException(Exception):
    def __init__(self, message, code):
        self.message = message
        self.code = code

    def __str__(self):
        return f"Message: {self.message} (Error Code: {self.code})"


class Operation:
    def math_operation(self):
        try:
            raise MyCustomException("NOT FOUND", 404)
        except MyCustomException as me:
            print(f"{me}")
        finally:
            print("This is always executed..")


opr = Operation()
opr.math_operation()
