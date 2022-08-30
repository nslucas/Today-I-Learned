# Samba

Samba is an open source, fast, secure, stable and widely-used network file system that provides file sharing and print services for all clients using the SMB/CIFS protocol, such as Linux, all versions of DOS and Windows, OS/2, and so many other operating systems.

To install the Samba along with its dependencies use the yum package manager as shown.

    yum install samba samba-client samba-common


Once the installation is complete, start the Sambe service, enable it to auto-start at system boot time and verify that service using the systemctl commands as follows.

    systemctl start smb
    systemctl enable smb
    systemctl status smb


Next, if you have a firewalld configured, you need to add the Samba service in the firewall configuration to allow access to shared directories and files through system.

    sudo firewall-cmd --permanent --add-service=samba
    sudo firewall-cmd --reload


To configure Samba for file sharing, you need to create a backup copy of default samba configuration file which comes with pre-configuration settings and various configuration directives.

    cp /etc/samba/smb.conf /etc/samba/smb.conf.orig


## Public File Share 

In this section, the first step is to create the shared directory which will store files on the server. Then define the appropriate permissions on the directory as shown.

    mkdir -p /srv/samba/public
    chmod -R 0777 /srv/samba/public
    chown -R nobody:nobody /srv/samba/public


Next, using the chcon utility, change the SELinux security context for the created samba shared directory.

    chcon -t samba_share_t /srv/samba/public

Now open the configuration file using _vim_ to configure the public unsecured file sharing on a shared directory.

    vim /etc/samba/smb.conf


Modify the following global parameters and add a section for the Public share. Note that you can set your own values where necessary (read man smb.conf for more information). Save the changes in the file and close.

    [global]
        workgroup = WORKGROUP
        netbios name = rhel
        security = user
    ...
    [Public]
        comment = Public File Server Share
        path = /srv/samba/public
        browsable = yes
        writable = yes
        guest ok = yes
        read only = no
        force user = nobody


Then run the following command to verify if the configuration is correct.

    testparm


If the Samba configuration is OK, go ahead and restart the samba service for the recent changes to take effect. Then check all the shares available.

    systemctl restart smb
    smbclient -L \\\\10.1.1.69


Lastly, test if the Public share is working fine. From your Windows machine, open the Windows Explorer, click on Network, then click on the RHEL host, or else try to access the server using its IP address as explained before.

    \\10.1.1.69



## Private File Share 

In order to create a securely shared directory, you need to create a Samba system group. All users of the secured share will be added to this group. You can use the groupadd command to create the group as follows.

    groupadd maps_group


Then use usermod command to add all users, for example, tecmint to the group and set a password for each user as shown.

    usermod felipe.pitanga -aG maps_group
    smbpasswd -a felipe.pitanga
    Senha: felipe123


Next, create the secure directory which will securely store shared files, then set the appropriate permissions on the directory. Also, change the SELinux security context for the directory as follows.

    mkdir -p /srv/samba/private
    chmod -R 0770 /srv/samba/private
    chown -R root:maps_group /srv/samba/private
    chcon -t samba_share_t /srv/samba/private


Next, open the configuration file for editing.

    vim /etc/samba/smb.conf


And add the following section at the end of the file.

    [Private]
        comment = Private File Server Share
        path =  /srv/samba/private
        valid users = @felipe.pitanga
        guest ok = no
        writable = yes
        browsable = yes


Next, verify the samba configuration again, by running the testparm command.

    testparm


Restart Samba services to apply the changes. Then check ir your share is available.

    systemctl restart smb.service
    systemctl restart nmb.service
    smbclient -L \\\\10.1.1.69 -U 'felipe.pitanga'

Lastly, test if the Private share is working fine. From your Windows machine, open the Windows Explorer, click on Network, then click on the RHEL host, or else try to access the server using its IP address as explained before.

    \\10.1.1.69


## Hidden File Share 

Create the shared directory which will store files on the server. Then define the appropriate permissions on the directory as shown.

    mkdir -p /srv/samba/hidden
    chmod -R 0777 /srv/samba/hidden
    chown -R nobody:nobody /srv/samba/hidden


Next, using the chcon utility, change the SELinux security context for the created samba shared directory.

    chcon -t samba_share_t /srv/samba/hidden

Now open the configuration file using _vim_ to configure the public unsecured file sharing on a shared directory.

    vim /etc/samba/smb.conf


Modify the following global parameters and add a section for the Hidden share. Note that you can set your own values where necessary (read man smb.conf for more information). Save the changes in the file and close.

    [Hidden]
        comment = Hidden File Server Share
        path = /srv/samba/hidden
        browsable = no
        writable = yes
        guest ok = yes
        read only = no
        force user = nobody


Then run the following command to verify if the configuration is correct.

    testparm


If the Samba configuration is OK, go ahead and restart the samba service for the recent changes to take effect. Then check all the shares available.

    systemctl restart smb


Lastly, test if the Hidden share is working fine. From your Windows machine, open the Windows Explorer, click on Network, then click on the RHEL host, or else try to access the server using its IP address as explained before.

    \\10.1.1.69\Hidden


**References:**

[Documentation - firewall-cmd ](https://firewalld.org/documentation/man-pages/firewall-cmd.html)

[Sharing Files between RHEL 8 and Windows Systems with Samba](https://www.techotopia.com/index.php/Sharing_Files_between_RHEL_and_Windows_Systems_with_Samba)

[Using SMBClient to Enumerate Shares](https://bestestredteam.com/2019/03/15/using-smbclient-to-enumerate-shares/)

[Samba hidden share](https://www.linuxquestions.org/questions/linux-software-2/samba-hidden-share-33594/)

[Install Samba4 on RHEL 8 for File Sharing on Windows](https://www.tecmint.com/install-samba-on-rhel-8-for-file-sharing-on-windows/)