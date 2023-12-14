package com.bloggingapp.BloggingApp.payloads;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private String authority;
    public Authority(String autority){
        this.authority=autority;
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
