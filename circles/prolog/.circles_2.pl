circle(big, 50).
circle(medium, 8). 
circle(small, 1). 

circle(medium_small, 9). 

parent_circle(X, Y) :-  
    circle(X, A), 
    circle(Y, B), 
    A > B.

order(X, Y, Z) :-
    circle(X, A), 
    circle(Y, B), 
    circle(Z, C), 
    A > B,
    B > C.    
    
add(Input, Output) :-  
    Input = ((C1, C2), S), 

    parent_circle(C2, C1),

    circle(C1, Radius1),
    circle(S, RadiusS),
    NewRadius is Radius1 + RadiusS,
    circle(NewCircle, NewRadius),

    parent_circle(C2, NewCircle),
    Output = (NewCircle, C2).
