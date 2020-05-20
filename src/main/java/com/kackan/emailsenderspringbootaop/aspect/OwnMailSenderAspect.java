package com.kackan.emailsenderspringbootaop.aspect;

import com.kackan.emailsenderspringbootaop.model.Movie;
import com.kackan.emailsenderspringbootaop.service.OwnMailSender;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OwnMailSenderAspect {

    private OwnMailSender mailSender;

    @Autowired
    public OwnMailSenderAspect(OwnMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Before("@annotation(OwnMailSenderAOP) && args(movie)")
    public void testOwnAspect(Movie movie)
    {
        mailSender.sendMail(movie.getEmail(),"Kackan app","You added your own movie to database!");
    }
}
