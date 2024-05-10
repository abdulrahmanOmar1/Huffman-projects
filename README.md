# Huffman Coding User Interface
This is a user interface for a Java desktop application, the application that would apply Huffman Coding.

# Huffman Coding
Huffman coding is a lossless data compression algorithm. The idea is to assign variable length codes to input characters; lengths of the assigned codes are based on the frequencies of corresponding characters. The most frequent character gets the smallest code and the least frequent character gets the largest code. The variable-length codes assigned to input characters are Prefix Codes, means the codes (bit sequences) are assigned in such a way that the code assigned to one character is not prefix of code assigned to any other character. This is how Huffman Coding makes sure that there is no ambiguity when decoding the generated bit stream.

In this project I used JavaFX For User Graphical inteface. This project is built as an assignment for Algorithm course.

# Running the project
This is only the user inerface used so in order to run the project, needs the JavaFx library to be build on the projecet path.

# File format
 File format could be anything, the applicaction must be able to compress any type of file.
