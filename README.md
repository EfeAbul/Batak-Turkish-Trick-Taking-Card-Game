# Batak: A Turkish Trick-Taking Card Game

This project is a simple Java-based implementation of **Batak**, a popular Turkish trick-taking card game similar to **Spades**. The game is designed with an object-oriented structure and supports core game mechanics such as shuffling, dealing cards, taking tricks, and determining the winner.

---

## 📁 Project Structure

All source files are located under the `src/` folder:

```
src/
├── Card.java       # Represents a playing card (suit and rank)
├── Player.java     # Abstract base class for players
├── User.java       # Human player class (extends Player)
├── Table.java      # Controls game logic, turns, and trick tracking
└── Main.java       # Entry point of the program
```


## ▶️ How to Run

1. Clone or download the project.
2. Open the project in any Java IDE (such as IntelliJ IDEA or Eclipse), or compile manually:
   ```bash
   javac src/*.java
   java src.Main

# 🃏 Game Overview
Batak is a trick-based game typically played with 4 players. In this project:

A full deck (52 cards) is used.

Each player is dealt cards and the game progresses through multiple trick rounds.

Players try to win tricks and achieve their bids.

The highest card in the played suit (or trump suit, if used) wins the trick.


# 🔧 Features
Object-oriented architecture

Support for human players

Turn-based trick handling

Simple card comparison and winner determination

Console-based interaction

# 📌 Notes
This is a basic version of the game and can be extended with:

AI players

Full scoring system

Multiplayer support

GUI interface

