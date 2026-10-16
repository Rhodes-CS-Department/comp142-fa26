# Lab 7: Snake

Team members (edit these):
1. Team member 1
2. Team member 2
3. Team member 3

## Goals

By the time you are done with this activity, you should be able to:
* improve your ability to make design decisions about classes.
* use ArrayLists and Strings more effectively.
* instantiate objects and call instance methods on them.
* work with your team more effectively.

## Overview

In this lab, you will write a SNAKE game, which has been demonstrated
to you at the beginning of class.  This classic game uses the keyboard
to navigate a "snake" around a 2-d grid, eating "apples" (red dots).
Your main goals for this lab are to (1) write the Snake class, which 
represents the snake on the game board, and (2) write the game logic
itself, which resides in the SnakeGame class.

Other files:
- RunSnakeGame.java: this file just contains the `main` method for
  the Snake game.  You probably won't need to modify this.
- Tests.java: You will write your test code here.
- Location.java: see next section for description.

## Part A: Explanation of the game and algorithms

To represent 2-d locations on the grid, we have given you a Location
class.  Open Location.java and acquaint yourself with the class. It 
is not complicated.

In particular, note that we use (x, y) locations, rather than
(row, column) in this lab.  Also, take note of the `equals()` method,
as you will need to use this later on.

To begin Part A, open the Snake.java file.  Right now, the Snake
class has a single instance variable called `body`, that represents
the "body" of a snake: a list of Locations.  Visually, you should
imagine a snake as a consecutive set of squares on the canvas,
where each square (or "segment" of the snake) is represented by
a Location object, and we store all of these Location objects in 
an ArrayList.  For instance, a snake with 3 "segments" at Locations
(5, 6), (5, 7), and (5, 8) would be represented by an arraylist 
like this (illustrating an arraylist of locations):

   [0]       [1]      [2]
----------------------------
|        |        |        |
| (5, 6) | (5, 7) | (5, 8) |
|        |        |        |
----------------------------

We will use the convention that the *head* of a snake is always
at index 0.  

Note that the picture above is *not* how the snake would be drawn
on the board: those three Locations all have the same X and different
Y's, indicating that this snake is oriented *vertically*, not 
horizontally.  

As the snake slithers around the board, we will of course need
to update the arraylist for its body.  Imagine the snake in the diagram
above moving one square upwards on the grid.  So the head of the
snake would move from (5, 6) to (5, 5), and the picture would change
to this:

   [0]      [1]      [2]
----------------------------
|        |        |        |
| (5, 5) | (5, 6) | (5, 7) |
|        |        |        |
----------------------------

Algorithmically, when a snake moves on the board, how do we 
update the arraylist?  The easiest way is to do 2 things:

- Add a new Location at the FRONT of the arraylist for the
  new head of the snake (in this case, the Location (5, 5)).
  This will temporarily increase the length of the snake by 1
  segment.
- Remove the LAST segment of the snake (at the BACK).  In this
  case, the old (5, 8) location was removed.  Notice
  that the length of the snake doesn't change!

A snake also can eat dots (apples) on the board.  When it eats
an apple, it grows an additional segment.  We accomplish this
in a similar way that we "move" a snake: we will add a new
Location to the front of the snake, but NOT remove the last
segment of the snake.  In this way, the length of the snake
increases by 1 when we grow it.

### Check-in with me if you have questions or something above
doesn't make sense.  Otherwise, go on.

## Part B: Implementing the Snake class

The first design decision you will make is how to store the direction
a snake is facing.  This detail is needed because as a snake moves
around the board, calculating where the new "head" of the snake
goes requires knowing what direction it is facing.

There are four different directions --- you can call them up/down/
left/right or north/east/south/west.  Add an instance variable
to the Snake class to represent this concept.  The data type is
up to you, but I would recommend either an int (using numbers 1-4),
or a char (using a letter for each direction), or a String (using
the complete word).  Don't forget to make the variable private!

Next, write the constructor for Snake, which takes a Location
corresponding to the starting position of the head of the snake.  
Initially, a snake only has one "segment", so all you need to do
in this constructor is add the given Location to the snake's body,
then set the direction of the snake to whatever you want (pick a 
default direction).

IMPORTANT NOTE: In this file and the Java files, when talking about the
snake segments, we use the term "body" to denote ALL of the segments of
the snake, including the head segment (which is always at index 0 in the
arraylist.)

Next, fill in the toString() method for Snake.  This method should
RETURN a String containing the direction the snake is facing, along
with all the segments in the snake's body.  You can get a String-ified
version of the body of the snake by calling body.toString().

STOP AND TEST.  Go to Tests.java and run the testToString method.
Do not go on until the println statements print the two snakes' 
directions and bodies with their segments.

Next, write getHeadLocation() and getBody().  Read the java comments
to see what these functions do.

Next, write changeDirection().  This function will be called whenever
you want the snake to change direction.  This is a "setter" method,
so you will need to add an argument to the function that has the same
data type as the instance variable you picked to represent the direction
of the snake.

Next, write the grow() method.  This method should examine the
direction the snake is facing, and add a new segment (Location) to 
the FRONT of the snake in the direction the snake is facing.
This increases the length of the snake by 1.  For example,  if the
snake is facing up/north, grow() should add a new segment at the
beginning of the arraylist that is "above" the current head of the 
snake.  (Therefore, grow() effectively gives the snake a new head,
keeping all the other parts of the body the same.)

Hint: you will need to use the 2-argument version of .add() for
ArrayLists.  Refer to your ArrayList handout, or the official 
Java documentation.

STOP AND TEST.  Go to Tests.java and write a testGrow method.  Inside
this method, create a new Snake, and call grow() on it a few times.  
Throw in a few calls to changeDirection() interspersed with the grow()s.
Use println calls to make sure the snake is growing in the correct
way.  Do not go on until the println statements indicate your grow
method is working.  

Next, write the move() method.  This method is just like grow(),
except after adding a new head to the snake (at the front of the
arraylist), this method should also remove the last segment of the
snake (at the back of the arraylist).  
Hint: you will need to use the 2-argument version of .add() for
ArrayLists, and the remove() method as well.  Refer to your ArrayList
handout, or the official Java documentation.

STOP AND TEST.  Go to Tests.java and write a testMove method.  Inside
this method, create a new Snake, and call grow() on it a few times to
make it longer, then add a few calls to move().  Throw in a few calls 
to changeDirection() interspersed with the grow()s and moves().
Use println calls to make sure the snake is growing & moving in the correct
way.  Do not go on until the println statements indicate your move
method is working.  

### Check-in with me if you have questions or something above
doesn't make sense.  Otherwise, go on.

## Part C: Implementing the game

Open SnakeGame.java and read through the code to familiarize yourself
with it.  You should try to understand all the instance variables and
the purpose of each method.

**A word about "final"**: The `final` keyword in Java can be used with
a variable to declare it as a constant (meaning, it doesn't change).
A variable declared "final" can only be set once.  It is typically used
for variables that the programmer creates to name a value or quantity
in a program that will not change as it runs.  Often times these constants
are declared with all uppercase names (like SQUARESIZE).  The purpose
of these constants are more for the programmer (the person) in that
they make your code easier to read, and also makes those constants easier
to change in one place in your code (if they need to be updated in the 
future.)

EXPLANATIONS: (just read, don't write anything yet)

SnakeGame Constructor: Constructs a new snake game, given the size of the board
to play on (rows and cols).  It also initializes the snake on the 
board (called snake1), and the location of the apple the snake is
trying to eat.  It also initializes the canvas.

.draw(): Draws the game board, including the snake and apple.  Note 
that this method DOES NOT CHANGE THE POSITION OF THE SNAKE OR APPLE,
it just draws wherever they are right now.

.runGame(): This is the "main loop" of the game, in that it just
keeps looping while the game is running.  In here is where you will
eventually write code to move/grow the snake and detect when it
eats the apple.
  Explanation of the snake counter (don't worry about this too much,
but here it is:)  In order to detect key presses on the keyboard,
we need to have the game loop only pause for about 20 milliseconds
(hence the canvas.pause(20)) at the end of the loop.  However, if we
also move the snake every 20 milliseconds, the snake moves much too
quickly for the game.  Therefore we keep a counter variable called
snakeCounter and increment it each time through the loop.  When it
gets to 5, we move the snake and reset the counter.  In effect, what
this does is the snake only moves every 100 milliseconds (20 * 5),
which is a good speed to play the game at.  This can be changed via
the GAMESPEED variable.

.handleKeyboard(): Called in runGame to detect key presses. 

Now that you understand the code, you should run RunSnakeGame.
You will see a new board with an apple (but no snake).  You can
click the screen to "start" the game, but nothing much will happen.
You can press the arrow keys and they should print messages, but nothing
will happen.

Now let's make the game work!  

**As you go through this section, if you encounter bugs, use lots of 
print statements to try to debug.  You can print a snake to see where
it is and what direction it is facing.  Call me over for help if you 
get stuck.**

First, fill in the part of draw() to draw the snake.  There's a
big comment that explains what to do to draw the snake.  You will
need to use the methods in the Snake class, and also in the Location
class, so have those open!

STOP AND TEST.  When you think you've got it, run the game and you
should see a 1-segment snake on the board.  It won't move yet, though,
even when you click to start the game.

Next, uncomment the call to snake1.move() around line 83 in runGame.

STOP AND TEST.  Now run the game and you should see a 1-segment snake 
on the board.  When you click to start the game, it should start 
moving on the board!

Next, let's make the key presses change the snake's direction. In
handleKeyboard(), modify the first 4 "if" statements to alter
the direction of the snake by calling your changeDirection method
that you wrote earlier.

STOP AND TEST.  When you think you've got it, run the game and you
should be able to control the snake with the keyboard.

Next, let's make the snake detect when it eats an apple.  Fill
in code in runGame (where the comment on eating the apple is) to
detect when the head of snake1 is at the same Location as the apple.
Hint: there's an equals() method in Location that will help you.
When the snake's head and the apple are at the same Location, do three
things:
  - Print a message (for debugging) that the snake is eating the apple.
  - Grow the snake
  - Move the apple to a new random Location.  Look in the constructor
     for an example of how to do this.

STOP AND TEST.  When you think you've got it, run the game and you
should be able to have the snake eat the apples, and it should grow
appropriately.

Next, let's make the snake detect collisions with the walls of
the board and itself.  You can do these in either order.  Write
code where the comments are in runGame() to detect these collisions.
When a collision is detected, you can set keepPlaying to false to
end the game loop.  STOP AND TEST after writing each piece.

Next, add a second snake to the game.  You will need to add a second
snake instance variable (snake2) in the appropriate place, and add
all the code to make it move and grow, and also detect collisions
with the wall and itself.  You should also detect collisions with the
other snake!  I recommend starting the second snake at a different
spot on the board than the first snake (far away from it).

Bonus enhancements: 
- Prevent snake from turning 180 degrees at once
  (i.e., snake can't switch from north to south at once; only
  90 degree turns are allowed).
- Detect which player wins at the end.
- Keep a score for each player.
- Add other things for the snakes to eat besides apples that might
  do different things.
- Speed up the game as it goes on.
- Have two (or more) apples on the board simultaneously.
