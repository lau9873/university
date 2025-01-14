.data
_msg1: .asciiz "fib("
_msg2: .asciiz ") = "
_msg3: .asciiz "\n"
.text

_main:
	li $v0, 5
	syscall 
	
	move $a1, $v0
	
	li $v0, 4
	la $a0, _msg1
	syscall
	
	li $v0, 1
	move $a0, $a1
	syscall
	
	li $v0, 4
	la $a0, _msg2
	syscall
	
	jal fib
	
	li $v0, 1
	move $a0, $v1 # v1 -> resultado
	syscall
	
	li $v0, 4
	la $a0, _msg3
	syscall
	

li $v0, 10
syscall

fib: # a1 -> entrada, v1 -> saída

	li $t0, 2 
	blt  $a1,$t0, return #se <2 return
	
	addi $sp,$sp,-20
	sw $ra, 0($sp) # guardar ra antigo
	sw $t3, 4($sp)
	sw $t4, 8($sp)
	sw $t5, 12($sp)
	sw $t6, 16($sp)
	
	subi $t3, $a1, 1 # t3 = n-1
	subi $t4, $a1, 2 # t4 = n-2
		 
	move $a1, $t3 
	jal fib # fib(n-1)
	
	lw $ra, 0($sp) # recuperar o ra antigo
	addi $sp, $sp, 4 # ajustar
	
	move $t5,$v1 # resultado de fib(n-1) em t5
	
	addi $sp,$sp,-4 # ajustar
	sw $ra, 0($sp) # guardar ra antigo
	
	move $a1, $t4
	jal fib # fib(n-2)
	
	
	move $t6,$v1 # resultado de fib(n-2) em t6
	
	add $v1,$t5,$t6 # fib(n-2) + fib(n-1)
	
	lw $ra, 0($sp)
	lw $t3, 4($sp)
	lw $t4, 8($sp)
	lw $t5, 12($sp)
	lw $t6, 16($sp)
	addi $sp,$sp,20 #tem de ir ate 20 senao comeca a rescrever por cima, o 0 conta....(20=4*5)
	
	jr $ra
	
	
return:
	move $v1, $a1
	jr $ra	
