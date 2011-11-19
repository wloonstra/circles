circle(big, 50).
circle(medium, 8).
circle(small, 1).

parent_circle(X, Y) :- 
    circle(X, A),
    circle(Y, B),
    A > B.
