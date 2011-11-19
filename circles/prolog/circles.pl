circle(big, 50).
circle(medium, 8).
circle(small, 1).

circle(small_medium, 9).

parent_circle(X, Y) :- 
    circle(X, A),
    circle(Y, B),
    A > B.

add(Input, Result) :- 
    Input = ((C1, C2), S),

    order([C1, C2, S], [Small, Medium, Big]), 

    circle(Small, RadiusSmall),
    circle(Medium, RadiusMedium),
    NewRadius is RadiusSmall + RadiusMedium,
    circle(NewCircle, NewRadius),

    parent_circle(Big, NewCircle),
    Result = (NewCircle, Big).

order(Input, Sorted) :-
    member(P, Input),
    member(Q, Input),
    member(R, Input),
   
    circle(P, RadiusP),
    circle(Q, RadiusQ),
    circle(R, RadiusR),
    RadiusP < RadiusQ,
    RadiusQ < RadiusR,
    
    Sorted = [P, Q, R].

