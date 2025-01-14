FROM ubuntu:latest

RUN apt -y update
RUN apt -y install build-essential iproute2 iputils-ping nano curl openssh-server

RUN echo "root:1n#3cur3_r0Ot_l0g1N" | chpasswd
RUN echo "PermitRootLogin yes" >> /etc/ssh/sshd_config
# run 'service ssh start' inside the ubuntu container to start ssh server

CMD ["/bin/bash"]
