package com.tpssoft.retro.services.ForgotPassword;

import com.tpssoft.retro.dto.EmailResponse;
import com.tpssoft.retro.dto.ResetPassWordReponse;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface ForgotPassService {
    public EmailResponse sendMailAttach(EmailResponse email) throws MessagingException;
    String forgotPassword(String email);
    public String resetPassword(ResetPassWordReponse resetPassWordReponse);
}
