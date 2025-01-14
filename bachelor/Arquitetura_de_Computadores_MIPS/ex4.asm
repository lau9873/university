.data 
_text: .asciiz "This is the string to be used to generate the histogram"
_msg1: .asciiz "->"
_msg2: .asciiz "\n"
_aa: .asciiz "A"
_zz: .asciiz "Z"
_a: .asciiz "a"
_z: .asciiz "z"
.align 2
_histogram: .space 104
.text

_main:
	jal compute
	jal print	

li $v0, 10
syscall	

compute:
	li $t0, 0
	loop:
		lb $t1, _text($t0)
		li $t2, 65
		li $t3, 90
		li $t4, 97
		li $t5, 122
	
		blt $t1, $t2, here1
		bgt $t1, $t3, here1
		subi $t3, $t1, 65
		li $t4, 4
		mul $t3, $t3, $t4
		lw $s2, _histogram($t3)
		addi $s2, $s2, 1
		sw $s2, _histogram($t3)
		
		here1:
		blt $t1, $t4, here2
		bgt $t1, $t5, here2
		subi $t3, $t1, 97
		li $t4, 4
		mul $t3, $t3, $t4
		lw $t2, _histogram($t3)
		addi $t2, $t2, 1
		sw $t2, _histogram($t3)	
		
		here2:
		addi $t0, $t0, 1
		bne $t1, $zero, loop
	jr $ra			

print:
	li $t0, 0
	loop2:	
		li $v0, 11
		addi $a0, $t0, 97
		syscall 
		
		li $v0, 4
		la $a0, _msg1
		syscall 
		
		li $t4, 4
		mul $t3, $t0, $t4
		li $v0, 1
		lw $a0, _histogram($t3)
		syscall 
		
		li $v0, 4
		la $a0, _msg2
		syscall 
		
		
		addi $t0, $t0, 1
		li $t1, 26
		blt $t0, $t1,loop2
		
		
	jr $ra	
		
												
																						
																																
																																										
																																																				
																																																														
																																																																																		