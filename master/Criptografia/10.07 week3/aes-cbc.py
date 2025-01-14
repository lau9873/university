from base64 import b64encode
from Crypto.Cipher import *
from Crypto.Random import *
from Crypto.Util.Padding import *
import sys


key = get_random_bytes(16)
cipher = AES.new(key, AES.MODE_CBC)
file_name = sys.argv[1]
fp = open(file_name)
text = fp.readline()
data = bytes(text, 'utf-8')
iv = b64encode(cipher.iv).decode('utf-8')
ct_bytes = cipher.encrypt(pad(data, AES.block_size))
cipher_text = b64encode(ct_bytes).decode('utf-8')

print("iv: ", iv)
print("key: ", key)
print("ciphertext: ", cipher_text)

f = open("encrypted_file.txt", "w")
f.write(cipher_text)
