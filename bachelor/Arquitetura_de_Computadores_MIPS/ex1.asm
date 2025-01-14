.data 
_msg1: .asciiz "The result is "
_msg2: .asciiz "\n"
.text

_main:
	li $v0, 5
	syscall 
	
	move $t0, $v0 #upTo
	li $t1, 0 #i
	li $t2, 0 #sum
	
loop: 
	mul $t3, $t1, $t1
	add $t2, $t2, $t3
	addi $t1, $t1, 1
	blt $t1, $t0, loop
	
	li $v0, 4
	la $a0, _msg1
	syscall
	
	li $v0, 1
	move $a0, $t2
	syscall
	
	li $v0, 4
	la $a0, _msg2
	syscall	
	
li $v0, 10
syscall	