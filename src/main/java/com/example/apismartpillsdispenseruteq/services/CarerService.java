package com.example.apismartpillsdispenseruteq.services;

import com.example.apismartpillsdispenseruteq.entity.Carer;
import com.example.apismartpillsdispenseruteq.repositories.CarerRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CarerService {
    @Autowired
    private CarerRepository carerRepository;

    @Autowired
    private JavaMailSender mailSender;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Carer> findAll() throws Exception {
        try {
            return carerRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }


    //Este metodo permite: Byscar un país mediante su ID.
    public Carer findById(Integer id) throws Exception {
        try {
            Optional<Carer> entityOptional = carerRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Carer save(Carer entity) throws Exception {
        try {
            //numero random para la verificacion por correo electronico
            String randonCode = RandomString.make(8);
            entity.setVerificationCode(randonCode.toUpperCase());
            entity.setState(false);
            //entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
            entity.setPassword(entity.getPassword());
            entity = carerRepository.save(entity);
            email(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public void email(Carer carer) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("smartpillsdispenser@gmail.com");
        helper.setTo(carer.getEmail());
        helper.setSubject("ACCOUNT VERIFICATION");
        String content = "Hi " + carer.getName() + " welcome to smart pills dispenser. To verify your account enter the following code in the application." +
                "   CODE: " + carer.getVerificationCode();
        helper.setText(content);

        mailSender.send(message);
    }


    //Este metodo permite: Actualizar mediante ID
    public Carer update(Integer id, Carer entity) throws Exception {
        try {
            Optional<Carer> entityOptional = carerRepository.findById(id);
            Carer carer = entityOptional.get();
            carer = carerRepository.save(entity);
            return carer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (carerRepository.existsById(id)) {
                carerRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


/*    public Boolean loginString(String email, String pass, Carer carer) {
        if ((BCrypt.checkpw(pass, carer.getPassword())) && (email == carer.getEmail())) {
            // si es correcta
            return true;
        } else {
            // si es falsa
            return false;
        }

    }*/
}
