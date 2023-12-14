package com.bloggingapp.BloggingApp.security;

import com.bloggingapp.BloggingApp.exception.ResourceNotFoundException;
import com.bloggingapp.BloggingApp.service.impl.CustomUserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private  JwtHelper jwtHelper;
    @Autowired
    private CustomUserDetailsServiceImpl customUserService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       // 1.get token
        String requestTokenheader=request.getHeader("Authorization");  // Authorization is the key which use in postman ,useing this we can get the  (authenticate  token) now we get the data(means authorization hogaya he abb cheack karo)
        //Bearer 23r3443hkjfgk
        String username=null;
        String token=null;
        if(requestTokenheader!=null && requestTokenheader.startsWith("Bearer")) {
            token = requestTokenheader.substring(7);
            try {
                // give token to jwtHelper get username
                username = this.jwtHelper.extractUsername(token);
                //once we get the token , now validate
                if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){   //securityContextHolder is where spring security store the details of who is authrnticated.
                    //get the details
                    UserDetails userDetails=this.customUserService.loadUserByUsername(username);    //
                    //now validate the token
                    if(this.jwtHelper.validateToken(token,userDetails)){
                        //now authenticate this
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                        //1st we have to crete details
                        // for that   have to need builder method  it is in new WebAuthenticationDetailsSource() after get builder method-> .buildDetails() ->then set request
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        //secutityContextholder use here to set uthorisation
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                    else{
                        System.out.println("invalid jwt token");
                    }

                }else {
                    System.out.println("username is null or context is not null ");//agar uthentication nahihu he to else path will exicte and commence method will exicute
                }
            }catch(IllegalArgumentException e){
                System.out.println("Unable to get jwt token");
            }
            catch(ExpiredJwtException e){
                System.out.println("token is expired!!!!!!");
            }
            catch(MalformedJwtException e){
                System.out.println("invalid jwt");
            }


        }else{
            System.out.println("jwt token does not begin with Bearer");
        }

        filterChain.doFilter(request,response);

    }
    }


