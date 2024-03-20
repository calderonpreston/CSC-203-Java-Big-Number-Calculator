Infinite Precision Arithmetic

Overview

In most programming languages, integer datatypes have limits, restricting computations to a maximum value. However, scientific fields often require handling numbers far larger than these limits. To address this, I undertook a project to implement infinite precision arithmetic in Java. This involved representing large numbers as linked lists and performing addition and multiplication operations.

Objectives

Ground-up Development: This project was an opportunity to build software from scratch, allowing a deeper understanding of its components.
Linked Lists Mastery: I revisited linked lists, implementing them in Java to represent large integers.
Testing Proficiency: Writing comprehensive tests ensured the correctness of the implemented functions.
File Handling Practice: The project also involved reading arithmetic expressions from files, processing them, and printing the results.

Requirements

Large Number Representation: I defined a class capable of representing arbitrarily large numbers using linked lists.
File Input Processing: The program reads arithmetic expressions from a file, solves them, and prints the results.
Testing Suite: I created multiple tests to validate the functionality of the implemented functions.

Specification

Command-line Argument: The program accepts a filename as a command-line argument, specifying the input file.
Input Format: Each line of the input file contains an arithmetic expression (e.g., "1234567890 + 987654321").
Supported Operations: Addition and multiplication are supported, with correct formatting of results.
Output Format: Results are printed with the correct format, removing leading zeroes.

Implementation

Linked List Representation: I represented integers as linked lists of digits, facilitating easy manipulation.
Arithmetic Operations: Addition and multiplication were implemented iteratively or recursively, ensuring proper handling of carrying.
Custom Linked List: To adhere to project constraints, I implemented my own linked list class instead of using Java's standard library.

By working on this project, I gained a deeper understanding of linked lists, file handling, and arithmetic operations in Java. It was a rewarding experience building a solution tailored to the problem at hand, without unnecessary complexities.
