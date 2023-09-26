package com.team.back.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.team.back.provider.JwtProvider;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
     
     private final JwtProvider jwtProvider;
     
     @Override
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
               throws ServletException, IOException {
               
               try{
            String token = parseBearerToken(request);

            if(token == null){
                filterChain.doFilter(request, response);
                return;
            }

            Integer employeeCode = jwtProvider.validate(token); //? todo : employeeCode는 INTEGER인데 JwtProvider.create랑 같이 확인해볼것.
            if(employeeCode == null){ //? todo
                filterChain.doFilter(request, response);
                return;
            }

            AbstractAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(employeeCode, null, AuthorityUtils.NO_AUTHORITIES); //? todo
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);

        }catch(Exception exception){
            exception.printStackTrace();
            
        }

        filterChain.doFilter(request, response);
     }
     
     private String parseBearerToken(HttpServletRequest request){
        
          String authorization = request.getHeader("Authorization");
          
          boolean hasAuthorization = StringUtils.hasText(authorization);
          if(!hasAuthorization) return null;
  
          boolean isBearer = authorization.startsWith("Bearer ");
          if(!isBearer) return null;
  
          String token = authorization.substring(7);
  
          return token;
      }
}
