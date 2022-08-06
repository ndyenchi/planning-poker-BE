package com.tpssoft.retro.controller.ForgotPassWord;

import com.tpssoft.retro.dto.EmailResponse;
import com.tpssoft.retro.dto.ResetPassWordReponse;
import com.tpssoft.retro.repository.UserRepository;
import com.tpssoft.retro.services.ForgotPassword.ForgotPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/forgot/password")
public class ForgotPassController {
    @Autowired
    private ForgotPassService forgotPassService;

    @PostMapping("/sendMail")
    public ResponseEntity<EmailResponse> sendMail(@RequestBody EmailResponse email) throws MessagingException {
        forgotPassService.sendMailAttach(email);
        return ResponseEntity.ok(email);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<ResetPassWordReponse> resetPassword(@RequestBody ResetPassWordReponse resetPassResponse) {
        forgotPassService.resetPassword(resetPassResponse);
        return ResponseEntity.ok(resetPassResponse);
    }
}
