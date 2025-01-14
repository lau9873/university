{
 "cells": [
  {
   "cell_type": "code",
   "execution_count": null,
   "id": "48bee8d2",
   "metadata": {},
   "outputs": [],
   "source": [
    "from Cryptodome.Cipher import AES\n",
    "import hashlib\n",
    "import sys\n",
    "import binascii\n",
    "\n",
    "\n",
    "plaintext='hello how are you?'\n",
    "password='qwerty123'\n",
    "\n",
    "\n",
    "if (len(sys.argv)>1):\n",
    "  plaintext=(sys.argv[1])\n",
    "if (len(sys.argv)>2):\n",
    "  password=(sys.argv[2])\n",
    "\n",
    "def encrypt(plaintext,key, mode):\n",
    "  encobj = AES.new(key, AES.MODE_GCM)\n",
    "  ciphertext,authTag=encobj.encrypt_and_digest(plaintext)\n",
    "  return(ciphertext,authTag,encobj.nonce)\n",
    "\n",
    "def decrypt(ciphertext,key, mode):\n",
    "  (ciphertext,  authTag, nonce) = ciphertext\n",
    "  encobj = AES.new(key,  mode, nonce)\n",
    "  return(encobj.decrypt_and_verify(ciphertext, authTag))\n",
    "\n",
    "key = hashlib.sha256(password.encode()).digest()\n",
    "\n",
    "print(\"GCM Mode: Stream cipher and authenticated\")\n",
    "print(\"\\nMessage:\\t\",plaintext)\n",
    "print(\"Key:\\t\\t\",password)\n",
    "\n",
    "\n",
    "ciphertext = encrypt(plaintext.encode(),key,AES.MODE_GCM)\n",
    "\n",
    "print(\"Cipher:\\t\\t\",binascii.hexlify(ciphertext[0]))\n",
    "print(\"Auth Msg:\\t\",binascii.hexlify(ciphertext[1]))\n",
    "print(\"Nonce:\\t\\t\",binascii.hexlify(ciphertext[2]))\n",
    "\n",
    "\n",
    "res= decrypt(ciphertext,key,AES.MODE_GCM)\n",
    "\n",
    "\n",
    "print (\"\\n\\nDecrypted:\\t\",res.decode())"
   ]
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3 (ipykernel)",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.10.3"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 5
}
