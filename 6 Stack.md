Stack
Data Structures and Algorithms

Definition
top
top
Pus
top
h
Stack

Definition
top
top
Po
top
p
Stack is an ADT that can handle ordered collection of item in
LIFO (Last In First Out)
Stack

Stack ADT
pop()
Stack()
push(obj)
Stack() {
ListNode top;
Stack(); // create empty stack
Stack
void push(Object obj); // push object to stack
Object pop(); // get & throw top element
Object top(); // get top element
boolean isEmpty(); // check if stack empty
}
top()
Stack

Sample code
stack = new Stack();
stack.push(‘Electrical’);
stack.push(‘Engineering’);
stack.push(‘Department’);
String str = stack.top();
stack.pop();
Departme
nt
Departme
str
nt
Engineerin
g
Electrical
The stack
Stack

Stack Application
Line editing
■
Bracket matching
■
Postfix calculation
■
Function call stack
■
Stack

Matching Parenthesis
Equal number of left and right parenthesis
◻
Right parenthesis is preceded by a matching left
◻
parenthesis
Expression: {x+(y-[a+b])}
|     |         | [         |               | [   |                |     |               |
| --- | ------- | --------- | ------------- | --- | -------------- | --- | ------------- |
|     | (       | (         |               | (   |                | (   |               |
| {   | {       | {         |               | {   |                | {   | {             |
| { … | { x+( … | {x+(y-[ … |               |     |                |     |               |
|     |         |           | {x+(y-[a+b] … |     | {x+(y-[a+b]) … |     | {x+(y-[a+b])} |
Stack

Converting Infix to Postfix Expression
Expression: 6 – (2 + 3) * 3
| No  | Symbol | Postfix String | Stack |
| --- | ------ | -------------- | ----- |
| 1   | 6      | 6              |       |
| 2   | -      | 6              | –     |
| 3   | (      | 6              | – (   |
| 4   | 2      | 6 2            | – (   |
| 5   | +      | 6 2            | – ( + |
| 6   | 3      | 6 2 3          | – ( + |
| 7   | )      | 6 2 3 +        | –     |
| 8   | *      | 6 2 3 +        | – *   |
| 9   | 3      | 6 2 3 + 3      | – *   |
| 10  |        | 6 2 3 + 3 *    | –     |
| 11  |        | 6 2 3 + 3 * –  |       |
Stack

Converting Infix to Postfix Expression
Expression: 6 + 2 / 3 * 3
| No  | Symbol | Postfix String | Stack |
| --- | ------ | -------------- | ----- |
| 1   | 6      | 6              |       |
| 2   | +      | 6              | +     |
| 3   | 2      | 6 2            | +     |
| 4   | /      | 6 2            | + /   |
| 5   | 3      | 6 2 3          | + /   |
| 6   | *      | 6 2 3 /        | + *   |
| 7   | 3      | 6 2 3 / 3      | + *   |
| 8   |        | 6 2 3 / 3 *    | +     |
| 9   |        | 6  2 3 / 3 * + |       |
Expression: {6 + [(2 / 3) * 3]}
Stack

Converting Infix to Postfix Expression
Expression: 6 + 2 / 3 ^ 3
| No  | Symbol | Postfix String | Stack |
| --- | ------ | -------------- | ----- |
| 1   | 6      | 6              |       |
| 2   | +      | 6              | +     |
| 3   | 2      | 6 2            | +     |
| 4   | /      | 6 2            | + /   |
| 5   | 3      | 6 2 3          | + /   |
| 6   | ^      | 6 2 3          | + / ^ |
| 7   | 3      | 6 2 3 3        | + / ^ |
| 8   |        | 6 2 3 3 ^      |  + /  |
| 9   |        | 6 2 3 3 ^ /    | +     |
| 10  |        | 6 2 3 3 ^ / +  |       |
Expression: {6 + [(2 / (3 ^ 3)]}
Stack

Evaluating a Postfix Expression
Expression: 6 2 3 + - 3 8 2 / + *
| No  | Symbol | Operand 1 |     | Operand  | Value | Stack |
| --- | ------ | --------- | --- | -------- | ----- | ----- |
2
| 1   | 6   |     |     |        |     | 6          |
| --- | --- | --- | --- | ------ | --- | ---------- |
| 2   | 2   |     |     |        |     | 6, 2       |
| 3   | 3   |     |     |        |     | 6, 2, 3    |
| 4   | +   |     | 2   | 3      | 5   | 6, 5       |
| 5   | -   |     | 6   | 5      | 1   | 1          |
| 6   | 3   |     | 6   | 5      | 1   | 1, 3       |
| 7   | 8   |     | 6   | 5      | 1   | 1, 3, 8    |
| 8   | 2   |     | 6   | 5      | 1   | 1, 3, 8, 2 |
| 9   | /   |     | 8   | 2      | 4   | 1, 3, 4    |
| 10  | +   |     | 3   | 4      | 7   | 1, 7       |
| 11  | *   |     | 1   | Stack7 | 7   | 7          |

Assignment
Make your own code for
Checking parenthesis
■
Converting infix to postfix
■
Evaluating postfix expression
■
Stack