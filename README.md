# SI_2026_lab2_233218

Bojan Kiselichki 
233218
---
# Control Flow Graph

## searchBookByTitle

Во продолжение е прикажан Control Flow Graph за функцијата searchBookByTitle.


<img width="651" height="912" alt="SearchBookByTitle drawio" src="https://github.com/user-attachments/assets/d7b80795-f01b-45df-b256-08e0eddc516c" />






## borrowBook

Во продолжение е прикажан Control Flow Graph за функцијата borrowBook.

<img width="582" height="1072" alt="BorrowBook" src="https://github.com/user-attachments/assets/b0406044-4899-4d45-a7ca-c513a3f58f85" />

---

# Cyclomatic Complexity

## searchBookByTitle

Цикломатската комплексност за функцијата searchBookByTitle е:

CC = 6

### Објаснување

Во функцијата постојат следните одлуки:

1. if (title.isEmpty())
2. for (Book book : books)
3. if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())
4. &&
5. if (results.isEmpty())

Според формулата:

CC = број на одлуки + 1

се добива:

CC = 5 + 1 = 6

---

## borrowBook

Цикломатската комплексност за функцијата borrowBook е:

CC = 7

### Објаснување

Во функцијата постојат следните одлуки:

1. if (title.isEmpty() || author.isEmpty())
2. ||
3. for (Book book : books)
4. if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author))
5. &&
6. if (!book.isBorrowed())

Според формулата:

CC = број на одлуки + 1

се добива:

CC = 6 + 1 = 7

---

# Every Statement Testing

## Тест случаи за searchBookByTitle

За исполнување на Every Statement критериумот потребни се минимум 3 тест случаи.
test1 - searchBookByTitle("Clean Code")
test2 - searchBookByTitle("Unknown")
test3 - searchBookByTitle("")


За исполнување на Every Branch потребни се минимум 4 тест случаи.
| Branch            | test1 | test2 | test3 | test4 |
| ----------------- | ----- | ----- | ----- | ----- |
| invalid input     | *     |       |       |       |
| successful borrow |       | *     |       |       |
| already borrowed  |       |       | *     |       |
| not found         |       |       |       | *     |



За исполнување на Multiple Condition потребни се минимум 4 тест случаи.


| Комбинација | Тест                         |
| ----------- | ---------------------------- |
| TT          | borrowBook("", "")           |
| TF          | borrowBook("", "Author")     |
| FT          | borrowBook("Book", "")       |
| FF          | borrowBook("Book", "Author") |


| Комбинација | Тест                            |
| ----------- | ------------------------------- |
| TT          | searchBookByTitle("Clean Code") |
| TF          | borrowed Clean Code             |
| FT          | searchBookByTitle("Python")     |
| FF          | borrowed Java + search Python   |


