import turtle

window = turtle.Screen()

t = turtle.Turtle()
t.color('red')
t.fillcolor('red')
t.penup()
t.goto(0, -150)
t.pendown()
t.begin_fill()
t.left(45)
t.forward(200)
t.circle(75, 180)
t.right(90)
t.circle(75, 180)
t.forward(200)
t.end_fill()

window.mainloop()
