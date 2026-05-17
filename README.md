# SI_2026_lab2_233218

Bojan Kiselichki 
233218
---
# Control Flow Graph

## searchBookByTitle

Во продолжение е прикажан Control Flow Graph за функцијата searchBookByTitle.


<img width="651" height="912" alt="SearchBookByTitle drawio" src="https://github.com/user-attachments/assets/9b6add0f-8f0e-48a2-b52c-7b8095552891" />





## borrowBook

Во продолжение е прикажан Control Flow Graph за функцијата borrowBook.

<img width="582" height="1072" alt="BorrowBook" src="https://github.com/user-attachments/assets/84385a81-9523-46bb-8d2d-7b52b2d43f0f" />
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

### Тест случај 1

```java
List<Book> result = library.searchBookByTitle("Clean Code");
