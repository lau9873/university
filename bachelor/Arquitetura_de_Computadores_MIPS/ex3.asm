.data 
_array: .space 400 # 4*100
_msg1: .asciiz "The result is "
_msg2: .asciiz "\n"
.text

_main:
	li $v0, 5
	syscall 
	
	move $a1, $v0
	
	jal store
	
	li $v0, 4
	la $a0, _msg1
	syscall
	
	jal compute
	
	li $v0, 1
	move $a0, $a2 # $a2 resultado de compute
	syscall
	
	li $v0, 4
	la $a0, _msg2
	syscall	

li $v0, 10
syscall			


store:
	
	# $a1 -> upTo
	li $t1, 0 #i
	move $t0, $a1	
	
	loop: 
		li $t4, 4
		mul $t3,$t1,$t4
		mul $s0, $t1, $t1
		sw $s0,_array($t3) #label(register -> múltiplo de 4)
		addi $t1, $t1, 1
		blt $t1, $t0, loop
	
	jr $ra


compute:

	li $t2, 0 #sum
	li $t1, 0 #i
	
	loop2: 
		li $t4, 4
		mul $t3,$t1,$t4
		lw $t5,_array($t3) #label(register -> múltiplo de 4)
		add $t2,$t2,$t5
		addi $t1, $t1, 1
		blt $t1, $a1, loop2	
	
	move $a2, $t2
	jr $ra	
	
				
										
