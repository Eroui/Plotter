# Plotter
A Math Functions Plotter

## Grammar

Here i will describe the grammar I'm using to analyse and compile and math function expression.

<pre>
- f     : Function
- E     : Expression
- T     : Term
- F     : Factor
- NUM   : A number (0-9)
- WORD  : A word, generaly the variable x or a math function like sin cos ...
- $     : Stands for end of line or string
</pre>

<pre>
f &rightarrow; E
E &rightarrow; T    | -T    | T + T  | T - T
T &rightarrow; F    | F * F | F / F 
F &rightarrow; NUM  | WORD(E)  | (E)
</pre>

<pre>
- A function is an Expression followed by the end of string.
- An Expression is either a Term or a Negative Term Or Sum/Substrction of 2 Terms
- A Term is either a Factor or Multiplication/Division of 2 Factors
- A Factor might be a Number or a math function such as cos, sin ... followed by open paranthesis and an Expression then a close paranthesis, or an Expression between two parantheses.
</pre>
