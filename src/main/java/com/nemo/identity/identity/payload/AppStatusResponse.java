package com.nemo.identity.identity.payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

public class AppStatusResponse {

    private String name;
    private String version;
    private Instant time;
    private String artifact;
    private String group;
    private String hostname;

    public AppStatusResponse(BuildProperties buildProperties) {
        this.name = buildProperties.getName();
        this.version = buildProperties.getVersion();
        this.time = buildProperties.getTime();
        this.artifact = buildProperties.getArtifact();
        this.group = buildProperties.getGroup();
        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


}
