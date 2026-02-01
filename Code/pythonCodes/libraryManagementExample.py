class Book:
    def __init__(self, title, author):
        self.title = title
        self.author = author

class Library:
    def __init__(self):
        self.books = []
    def add_books(self, book):
        self.books.append(book)
        print(f"Book '{book.title}' by {book.author} added to the library")
    def display_books(self):
        for book in self.books:
            print(f"Title: {book.title}, Author: {book.author}")

# Creating the Book object
book1 = Book("The Catcher in the Rye", "J.D. Salinger")
book2 = Book("To Kill a Mockingbird", "Harper Lee")

# Creating the Library object
library = Library()

# Adding books in library
library.add_books(book1)
library.add_books(book2)
library.display_books()
