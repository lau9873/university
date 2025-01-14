from pwn import *

r = process("./easy_canary")

s=r.recvuntil(
