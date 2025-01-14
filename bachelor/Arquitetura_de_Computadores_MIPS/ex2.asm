.data
_array: .space 400 # 4*100
.text

_main:
	li $v0, 5
	syscall 
	
	move $t0, $v0 #upTo
	li $t1, 0 #i
	
loop: 
	mul $t2, $t1, $t1
	li $t4, 4
	mul $t3,$t1,$t4
	sw $t2,_array($t3) #label(register -> múltiplo de 4)
	addi $t1, $t1, 1
	blt $t1, $t0, loop
	
	
#	lw $t2,_array($t3)
#	li $v0, 1
#	move $a0, $t2
#	syscall
	
li $v0, 10
syscall	
	
