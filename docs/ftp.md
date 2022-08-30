# FTP (Install, Configure and Protect) 

FTP (stands for “File Transfer Protocol”) is a standard and old network protocol used for the transfer of files between a client and server on a computer network. It is built on a client-server model architecture, which offers access to files and directories via an FTP client, to upload files to the server as well as download files from it.
Use-o para criar, listar e transferir arquivos.

Pré-requisitos:
- ftp (cliente)
- vsftpd (servidor)

To install secure FTP package, use the following command.

    yum install ftp
    yum install vsftpd

When the installation is complete, you need to start the vsftpd service for the meantime, enable it to start automatically at system boot and then verify the status using the following _systemctl_ commands.

    systemctl start vsftpd
    systemctl enable vsftpd --now
    systemctl status vsftpd


Next, you need to open FTP port 21 on the system firewall to allow access to FTP services from external systems.

    firewall-cmd --zone=public --permanent --add-port=21/tcp
    firewall-cmd --zone=public --permanent --add-port=45073/tcp
    firewall-cmd --reload


To configure an FTP server, you need to take the backup of the main FTP configuration file /etc/vsftpd/vsftpd.conf using the following copy command.

    cp /etc/vsftpd/vsftpd.conf /etc/vsftpd/vsftpd.conf.orig


To test if the above FTP setup is running fine, start by creating an FTP user with useradd command and create a password for that user.

    useradd -m -c "felipe.pitanga"
    passwd felipe.pitanga
    Defina a senha: felipe123


Then add the user to the file /etc/vsftpd.userlist using the echo command as follows.

    echo "felipe.pitanga" | tee -a /etc/vsftpd.userlist
    cat /etc/vsftpd.userlist


Then create the alternative local root directory for the user and set the appropriate permissions on this directory.

    mkdir -p /home/felipe.pitanga/ftp
    chown nobody:nobody /home/felipe.pitanga/ftp
    chmod a-w /home/felipe.pitanga/ftp


Next, create a directory inside the local root location, where user’s will keep his/her files.

    mkdir /home/felipe.pitanga/ftp/files
    chown felipe.pitanga:felipe.pitanga /home/felipe.pitanga/ftp/files
    chmod 0700 /home/felipe.pitanga/ftp/files/

Then open the configuration file.

    vim /etc/vsftpd/vsftpd.conf

Set the following parameters with these corresponding values (see man vsftpd.conf for meanings of the configuration parameters):

    anonymous_enable=NO             
    local_enable=YES		
    write_enable=YES		
    local_umask=022		        
    dirmessage_enable=YES	        
    xferlog_enable=YES		
    connect_from_port_20=YES        
    xferlog_std_format=YES          
    listen=NO   			
    listen_ipv6=YES		        
    pam_service_name=vsftpd 


Next, you need to configure FTP to allow/deny users access to FTP services based on the user list file /etc/vsftpd.userlist.
By default, users listed in /etc/vsftpd.userlist file are denied access with the userlist_deny option set to YES, if userlist_enable=YES, it enables access.
But, setting the parameter userlist_deny=NO alters the setting, meaning that only users explicitly listed in userlist_file=/etc/vsftpd.userlist will be permitted to log in.
Therefore, add the following lines in your vsftpd.conf configuration file (or if there already exist, uncomment them and set their values as shown):

    vim /etc/vsftpd/vsftpd.conf

    userlist_enable=YES                   # allow access to list of usernames from the userlist_file
    userlist_file=/etc/vsftpd.userlist    # stores usernames.
    userlist_deny=NO   


Now add the following lines in your vsftpd.conf configuration file to restrict FTP users to their Home directories.

    vim /etc/vsftpd/vsftpd.conf

    chroot_local_user=YES		#means local users will be placed in a chroot jail, their home directory after login by default settings.
    user_sub_token=$USER         	
    local_root=/home/$USER/ftp 


Set the following SELinux boolean rule to enable FTP to read/write files of user’s home directory.

    semanage boolean -m ftpd_full_access --on

Finally restart the vsftpd service to affect all the changes we made so far above:

    systemctl restart vsftpd


Now connect to the FTP server using any FTP client as follows.

    ftp 10.1.1.69
    insira o usuario: felipe.pitanga
    senha: felipe123


**Referências:**

[How to Install FTP Client to Connect FTP Server on CentOS/Fedora/RHEL](https://www.looklinux.com/how-to-install-ftp-client-to-connect-ftp-server-on-centosfedorarhel/)

[Instalar e configurar um servidor FTP no CentOS](https://www.vivaolinux.com.br/artigo/Instalar-e-configurar-um-servidor-FTP-no-CentOS)

[How to Install, Configure and Secure FTP Server in RHEL 8](https://www.tecmint.com/install-ftp-server-in-rhel-8/)