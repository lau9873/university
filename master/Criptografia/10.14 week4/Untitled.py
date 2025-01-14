from Cryptodome.Cipher import AES
import hashlib
import sys
import binascii
import os


plaintext=sys.argv[1]
password=os.urandom(16)

def encrypt(plaintext,key, mode):
    encobj = AES.new(key, AES.MODE_GCM)
    ciphertext,authTag=encobj.encrypt_and_digest(plaintext)
    return(ciphertext,authTag,encobj.nonce)

def decrypt(ciphertext,key, mode):
    (ciphertext,  authTag, nonce) = ciphertext
    encobj = AES.new(key,  mode, nonce)
    return(encobj.decrypt_and_verify(ciphertext, authTag))


print("\nMessage:\t",plaintext)
print("Key:\t\t",password)


ciphertext = encrypt(plaintext.encode(),password,AES.MODE_GCM)

print("Auth Msg:\t",binascii.hexlify(ciphertext[1]))
print("Nonce:\t\t",binascii.hexlify(ciphertext[2]))
print("Cipher:\t\t",binascii.hexlify(ciphertext[0]))


res= decrypt(ciphertext,password,AES.MODE_GCM)


print ("\n\nDecrypted:\t",res.decode())