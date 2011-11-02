circle(big, 50).
circle(small, 30).

parent_circle(X, Y) :- 
    circle(X, A),
    circle(Y, B),
    A > B.
