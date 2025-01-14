
SRC = ast.c table.c interpret.c main.c ast.h table.h interpret.h

OBJS= ast.o table.o interpret.o main.o

%.o : %.c %.h
	gcc -c -g $< 

runtests : $(OBJS) $(SRC)
	gcc -g -o runtests $(OBJS)
