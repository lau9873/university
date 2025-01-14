.data 
_msg1: .asciiz "Hello world"

.text
	li $v0, 4
	la $a0, _msg1
	syscall

li $v0, 10
syscall
