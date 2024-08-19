# Find original password

Given a string of encrypted password, write a function to decrypt and return the original password.

The encryption process follows this rules:
    1.Initially i=0.
    2.if s[i] is lowercase and the next character s[i+1] is uppercase, swap them , add a ‘*’ after them,and move to i+2.
    3.if s[i] is a number,replace it with 0,place the original number at the start, and move to i+1.
    4.else, move to i+1.
    5.stop if i is more than or equal to the string length. Otherwise, goto step2.
```
Example
    Given the input or encrypted string =“43Ah*cK0rr0nK”, the output or decrypted string should be"hAcK3rr4nK"
```